package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CreakingTest {
    CreakingHeart creakingHeart;

    /**
     * Creates a {@link CreakingHeart} in the coordinates x:150, y:10, z:250
     * and spawns a {@link Creaking} linked to it
     */
    @BeforeEach
    void setUp() {
        creakingHeart = new CreakingHeart(150,10,250);
        creakingHeart.spawnCreaking();
    }

    /**
     * Checks that the move method of the {@link Creaking} don´t let him go out of
     * a 50x25x50 area around the {@link CreakingHeart}
     */
    @Test
    void moveTest() {
        assertFalse(creakingHeart.getCreaking().move(1000,200,1000));
        assertTrue(creakingHeart.getCreaking().move(180,20,200));
        assertEquals(180, creakingHeart.getCreaking().getX());
        assertEquals(20, creakingHeart.getCreaking().getY());
        assertEquals(200, creakingHeart.getCreaking().getZ());
    }

    /**
     * Verify if the {@link Creaking} when gets hitted show the correct coordinates
     * of his linked {@link CreakingHeart}
     */
    @Test
    void getHitTest() {
        assertEquals("The Creaking Heart bounded to this Creaking is in (150, 10, 250)",
                creakingHeart.getCreaking().getHit());
    }

    /**
     * Check if the {@link CreakingHeart} returns the same {@link Creaking}
     * when trying to generate a new one after having already generated one
     */
    @Test
    void spawnCreakingAlreadySpawnedTest() {
        String memDirec1 = creakingHeart.getCreaking().getMemoryDirection();
        creakingHeart.spawnCreaking();
        String memDirec2 = creakingHeart.spawnCreaking().getMemoryDirection();
        assertEquals(memDirec1, memDirec2);
    }

    /**
     * Check if the {@link CreakingHeart} returns a new {@link Creaking}
     * when trying to generate a new one after destroying it
     */
    @Test
    void spawnCreakingNotSpawnedTest(){
        String memDirec1 = creakingHeart.getCreaking().getMemoryDirection();
        creakingHeart.breaks();
        creakingHeart.spawnCreaking();
        String memDirec2 = creakingHeart.getCreaking().getMemoryDirection();
        assertNotEquals(memDirec1, memDirec2);
    }
}