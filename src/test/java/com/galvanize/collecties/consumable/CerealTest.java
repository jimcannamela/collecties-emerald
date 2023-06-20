package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Consumable: Cereal")
public class CerealTest {

    Cereal cereal;

    @BeforeEach
    public void testSetup() {cereal = new Cereal();}

    @Test
    void shouldHaveTheRightName() {assertEquals("Chocolate Blasted Sugar Bombs", cereal.getName());}

    @Test
    public void shouldOnlyHaveOneUsage() {
        assertTrue(cereal.consume());
    }
}
