package org.example;

import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor

public class CreakingHeart {
    private final int x, y, z;
    private Creaking creaking;

    /**
     * Returns the {@link Creaking} of this {@link CreakingHeart},
     * if there isn't one, creates a new one and sets it for the return
     * @return A {@link Creaking} bounded to this {@link CreakingHeart}
     */
    public Creaking spawnCreaking(){
        if (creaking == null){
            creaking = new Creaking(this);
        }
        return creaking;
    }

    /**
     * Sets the {@link Creaking} of this {@link CreakingHeart} to null
     */
    public void breaks(){
        creaking = null;
    }
}
