package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieStatus;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;

/*
 * Manages a single encounter
 */
public class Encounter {

  //----------------------------------------------------
  // ENCOUNTER STATICS
  //----------------------------------------------------

  // Just a static array of the choices players have in an encounter
  private static final String[] battleChoices = {
    "Attack",
    "Run"
  };

  //----------------------------------------------------
  // ENCOUNTER INSTANCES
  //----------------------------------------------------

  private final Printer printer;
  private final Prompt prompt;
  private final Collectie opponent;
  private final Collectie challenger;

  /*
   * Basic constructor, expect we take in a bio then use the
   * static helper on Collectie to get a random Collectie for that biome
   */
  public Encounter(Printer printer, Prompt prompt, Collectie challenger, Biome biome) {
    this.printer = printer;
    this.prompt = prompt;
    this.challenger = challenger;
    this.opponent = Collectie.getRandomCollectieForBiome(biome);
  }

  /*
   * It is best to give the user of this class the option to decide when to
   * start the encounter instead of implicitly starting it in the constructor
   * This returns true if the player knocks out the wild Collectie AND decides to keep it
   * and false otherwise
   * This return type was a design decision based on how encounters work and their
   * usage in the main Game class.
   */
  public boolean start() {
    printer.print(opponent.getGraphic());
    printer.multiline(
      "%s! You have encountered a wild %s!",
      "What would you like to do?"
    )
    .print(
      opponent.speak(),
      opponent.getSpecies()
    );

    // Notice the static choices defined above are passed here
    printer.formatAsList(battleChoices).print();

    // If the player chooses to attack, do a skirmish
    // otherwise cheese it
    if (prompt.getChoice(battleChoices.length) == 1) {
      if (challenger.getStatus() == CollectieStatus.UNCONSCIOUS) {
        printer.multiline(
                "", // Add space before
                "Your protector is unconscious so you GTFO!!"
        ).print();
        return false;
      }
      // skirmish returns true if the player wins
      if (skirmish()) {
          printer.multiline(
          "", // Add space before
          "Would you like to capture the wild %s?"
        )
        .print(opponent.getSpecies());

        // return the choice the player gives for keeping the wild Collectie
        return prompt.getYesNo();
      }
    } else {
      int min = 1;
      int max = 100;
      int range = max - min + 1;
      int surpriseAttack = (int) Math.floor((Math.random()* range) +  min);
      if(surpriseAttack < 75){
        opponent.performAttack();
        printer.print(opponent.getSpecies() + " attacked you while you were running!!");
      }
      printer.print("You cheese it the heckin' out of there.");
      //if run then opponent perform attack at math.random percent

    }


    // If you loose (or run) you cannot keep the wild Collectie
    // So false is returned for those cases
    return false;
  }

  /*
   * This looks more complex than it really it
   * Just attack, if the opponent survives it counter-attacks
   * return true if the player wins, false otherwise
   */
  private boolean skirmish() {
    printer.print(
      "%s attacks the wild %s!",
      challenger.getName(),
      opponent.getSpecies()
    );

    printer.wait(3);

    // The opponent is defending against the player's attack
    // This if is true if the opponent SURVIVES
    // (defend returns true to denote successful defense)
    while(!opponent.isHealthZero() && !challenger.isHealthZero()) {

      if (opponent.defend(challenger.performAttack())) {
//        printer.multiline(
//                        "", // Add space before
//                        "The wild %s manages to protect itself from the blow!",
//                        "It counter-attacks!"
//                )
//                .print(opponent.getSpecies());
      } else {
        opponent.subtractHealth(challenger.performAttack());
        //Prompt.fakeWait(3);
//        printer.multiline("%s opponent health after attack").print(opponent.getHp());
      }
      if (opponent.isHealthZero()) {
        opponent.setStatus(CollectieStatus.UNCONSCIOUS);
        printer.multiline(
                        "", //Add space before
                        "%s has fallen and is unconscious!",
                        "Your %s won the battle with %s hp left"
                )
                .print(opponent.getName(),challenger.getName(),challenger.getHp());
        opponent.setHp(0);

        return true;
      }
      if (challenger.defend(opponent.performAttack())) {
//        printer.multiline(
//                        "", // Add space before
//                        "The wild %s manages to protect itself from the blow!",
//                        "It counter-attacks!"
//                )
//                .print(challenger.getSpecies());
      } else {
        challenger.subtractHealth(opponent.performAttack());
        //Prompt.fakeWait(3);
//        printer.multiline("%s challenger health after attack").print(challenger.getHp());

      }
      if (challenger.isHealthZero()) {
        challenger.setStatus(CollectieStatus.UNCONSCIOUS);
        printer.multiline(
                        "", //Add space before
                        "%s has fallen and is unconscious!",
                        "The wild %s won the battle with %s hp left"
                )
                .print(challenger.getName(),opponent.getName(),opponent.getHp());
        challenger.setHp(0);

        return false;
      }
        // The player defends against the wild attack
        // The if is true the player SURVIVES
//        if (challenger.defend(opponent.performAttack())) {
//          printer.multiline(
//                          "", //Add space before
//                          "%s survives the blow!"
//                  )
//                  .print(challenger.getName());
//        } else {
//          challenger.setStatus(CollectieStatus.UNCONSCIOUS);
//          printer.multiline(
//                          "", //Add space before
//                          "%s has fallen and is unconscious!",
//                          "%s challenger current health"
//                  )
//                  .print(challenger.getName(), challenger.getHp());
//
//        }

        // Regardless of surviving the counter attack
        // if the wild Collectie survives the player lost

      }
        return true;
  }

  /*
   * The main Game needs access to the opponent
   * so it can be added to the player's collection
   * if applicable
   */
  public Collectie getOpponent() {
    return opponent;
  }
}
