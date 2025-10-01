package io.codeforall.bootcamp.magic_lamp;

/**
 * GrumpyGenie is a type of Genie that only grants one wish, regardless of maxWishes.
 * This class demonstrates inheritance and different behavior implementation.
 * 
 * Key features:
 * - Inherits from base Genie class
 * - Only grants one wish total, then refuses all others
 * - Uses a boolean flag to track if wish was granted
 * - Has type identifier 2 for grumpy genies
 */
public class GrumpyGenie extends Genie {
    // Instance variable to track if the single wish was granted
    private boolean wishGranted = false;

    /**
     * Constructor: Creates a new GrumpyGenie
     * Calls parent (Genie) constructor using super()
     * Maximum number of wishes (though GrumpyGenie only grants one)
     */
    public GrumpyGenie(int maxWishes) {
        super(maxWishes);  // Call parent constructor
    }

    /**
     * Method: Override of parent's grantWish()
     * GrumpyGenie only grants one wish total, regardless of maxWishes
     * boolean indicating if wish was granted
     */
    @Override
    public boolean grantWish() {
        if (!wishGranted) {           // Check if wish hasn't been granted yet
            wishGranted = true;        // Mark wish as granted
            setRemainingWishes(getRemainingWishes() - 1);  // Update wish count
            return true;
        }
        return false;  // Always refuse after first wish
    }

    /**
     * Method: Override of parent's getGenieType()
     * int value 2 indicating GrumpyGenie type
     */
    @Override
    public int getGenieType() {
        return 2;  // Type 2 is Grumpy
    }
}