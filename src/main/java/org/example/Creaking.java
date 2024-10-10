package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Creaking {
    private final CreakingHeart creakingHeart;
    private float x, y, z;

    /**
     * Creates a {@link Creaking} in a 20x20 area around the (X, Z)
     * coordinates of the {@link CreakingHeart} and in its same Y coordinate
     * @param creakingHeart : The {@link CreakingHeart} linked to this {@link Creaking}
     */
    protected Creaking(CreakingHeart creakingHeart){
        this.creakingHeart = creakingHeart;
        this.x = (int) (Math.random() * 40) + creakingHeart.getX()-20;
        this.y = creakingHeart.getY();
        this.z = (int) (Math.random() * 40) + creakingHeart.getZ()-20;
    }

    /**
     * Moves the {@link Creaking} to the indicated coordinates if
     * they are not outside a 50x25x50 area around the Creaking Heart
     * @param x : The new X coordinate for the Creaking
     * @param y : The new Y coordinate for the Creaking
     * @param z : The new Z coordinate for the Creaking
     * @return True if the new coordinates are valid, else false
     */
    public boolean move(int x, int y, int z){
        int xDistance = Math.abs(x - this.creakingHeart.getX());
        int yDistance = Math.abs(y - this.creakingHeart.getY());
        int zDistance = Math.abs(z - this.creakingHeart.getZ());

        if (xDistance <= 50 && zDistance <= 50 && yDistance <= 25){
            this.x = x;
            this.y = y;
            this.z = z;
            return true;
        }
        return false;
    }

    /**
     * Indicates the coordinates of the {@link CreakingHeart} bounded to this {@link Creaking}
     * @return The coordinates of the {@link CreakingHeart} of to this {@link Creaking}
     */
    public String getHit(){
        return "The Creaking Heart bounded to this Creaking is in (" + creakingHeart.getX()
                + ", " + creakingHeart.getY() + ", " + creakingHeart.getZ() + ")";
    }

    /**
     * Returns the memory direction of the {@link Creaking}
     * @return The memory direction of the {@link Creaking}
     */
    public String getMemoryDirection(){
        return  Integer.toHexString(System.identityHashCode(this));
    }
}
