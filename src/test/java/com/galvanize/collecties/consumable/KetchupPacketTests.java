package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.species.Bunz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KetchupPacketTests {

    KetchupPacket testPacket;

    @BeforeEach
    public void setup() {
        testPacket = new KetchupPacket();
    }

    @Test
    public void testGetName() {
        assertEquals("Brand-name Ketchup Packet", testPacket.getName());
    }

    @Test
    public void testConsume_ShouldOnlyHaveOneUsage() {
        assertTrue(testPacket.consume());
    }

    @Test
    public void testClone_CreateNewInstanceOfKetchupPacket(){
        Consumable clone = testPacket.clone();
        assertNotEquals(clone, testPacket);
    }

    @Test
    public void shouldBeAbleReturnASpecificBiome() {
        Biome actual = testPacket.getContainingBiome();
        assertEquals(Biome.BEACH,actual);
    }
}
