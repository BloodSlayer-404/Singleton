package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CreakingTest {
    CreakingHeart creakingHeart;

    @BeforeEach
    void setUp() {
        creakingHeart = new CreakingHeart(150,10,250);
        creakingHeart.spawnCreaking();
    }

    @Test
    void moveTest() {
        assertFalse(creakingHeart.getCreaking().move(1000,200,1000));
        assertTrue(creakingHeart.getCreaking().move(180,20,200));
        assertEquals(180, creakingHeart.getCreaking().getX());
        assertEquals(20, creakingHeart.getCreaking().getY());
        assertEquals(200, creakingHeart.getCreaking().getZ());
    }

    @Test
    void getHitTest() {
        assertEquals("The Creaking Heart bounded to this Creaking is in (150, 10, 250)",
                creakingHeart.getCreaking().getHit());
    }

    @Test
    void spawnCreakingAlreadySpawnedTest() {
        String memDirec1 = creakingHeart.getCreaking().getMemoryDirection();
        creakingHeart.spawnCreaking();
        String memDirec2 = creakingHeart.getCreaking().getMemoryDirection();
        assertEquals(memDirec1, memDirec2);
    }

    @Test
    void spawnCreakingNotSpawnedTest(){
        String memDirec1 = creakingHeart.getCreaking().getMemoryDirection();
        creakingHeart.breaks();
        creakingHeart.spawnCreaking();
        String memDirec2 = creakingHeart.getCreaking().getMemoryDirection();
        assertNotEquals(memDirec1, memDirec2);
    }
}