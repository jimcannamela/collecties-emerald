package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Lord Doof")
public class LordDoofTest {
private LordDoof doofy;

@BeforeEach
void setUp() {doofy = new LordDoof();}

    @Test
     void shouldBeAbleToRename() {
        //Arrange
        String newName = "Doofy";
        //Action
        doofy.setNewName(newName);
        //Assert
        assertEquals(newName, doofy.getNewName());
    }

    @Test
    void shouldBeDoofySpecies() {
    //assert
        assertEquals("LordDoof", doofy.getSpecies());
    }
    @Test
    void shouldBeSteelType(){
    //assert
        assertEquals(CollectieType.STEEL, doofy.getType());
    }
    @Test
    void shouldProvideAGraphic() {
        //Arrange
        String graphic = doofy.getGraphic();
        //Action
        System.out.println(graphic);
        //Assert
        assertEquals(0, graphic.length());
    }

}
