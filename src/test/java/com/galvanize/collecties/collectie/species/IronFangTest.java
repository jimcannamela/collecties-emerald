package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: IronFang")
public class IronFangTest {
private IronFang fangy;

@BeforeEach
void setUp() {fangy = new IronFang();}

    @Test
     void shouldBeAbleToRename() {
        //Arrange
        String newName = "fangy";
        //Action
        fangy.setNewName(newName);
        //Assert
        assertEquals(newName, fangy.getNewName());
    }

    @Test
    void shouldBeIronFangSpecies() {
    //assert
        assertEquals("IronFang", fangy.getSpecies());
    }
    @Test
    void shouldBeFairyType(){
    //assert
        assertEquals(CollectieType.FAIRY, fangy.getType());
    }
    @Test
    void shouldProvideAGraphic() {
        //Arrange
        String graphic = fangy.getGraphic();
        //Action
        System.out.println(graphic);
        //Assert
        assertNotEquals(0, graphic.length());
    }
   @Test
    void shouldHaveCorrectSound() {
        assertEquals("BIDOOOOOOOF", fangy.speak());
   }

   @Test
    void shouldPreferBogBiomes(){
     assertEquals(Biome.BOG, fangy.getPreferredBiome());
   }

   @Test
    void shouldReturnAttack() {
    assertEquals(100, fangy.performAttack());
   }

   @Test
    void shouldNeverLoseDefense() {

    assertTrue(fangy.defend(10));
   }
   @Test
    void shouldGetIronFangClone() {
    IronFang clone = fangy.clone();
    assertNotEquals(clone, fangy);
   }
   @Test
    void shouldTestIfHPIsZero() {
    boolean currentHP = fangy.subtractHealth(2);

    assertEquals(false, currentHP);
   }

}
