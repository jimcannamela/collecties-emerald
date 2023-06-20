package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: VeganChili")
public class VeganChiliTests {

    VeganChili veganChili;

    @BeforeEach
    public void testSetup() {
        veganChili = new VeganChili();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("A nutritious batch of chili, now featuring 0 collectie parts or byproducts!", veganChili.getName());
    }
}