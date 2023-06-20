package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@DisplayName("Consumable: Sub Sandwich")
public class SubSandwichTest {

    SubSandwich sandwich;

    @BeforeEach
    public void testSetup() {
        sandwich = new SubSandwich();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("This is a Roast Rextore sub, made from the finest Rextore.", sandwich.getName());
    }

    @Test
    public void shouldOnlyHaveOneUsage() {
        assertTrue(sandwich.consume());
    }
}
