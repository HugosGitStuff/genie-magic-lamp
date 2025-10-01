package io.codeforall.bootcamp.magic_lamp;

/**
 * RecyclableAngel is a special type of Genie that can grant unlimited wishes until recycled.
 * This class demonstrates advanced inheritance and state management.
 * 
 * Key features:
 * - Inherits from base Genie class
 * - Can grant unlimited wishes until recycled
 * - Can be recycled once to recharge the MagicLamp
 * - Has type identifier 3 for angels
 * - Demonstrates state management with recycled flag
 */
public class RecyclableAngel extends Genie {
    // Instance variable to track if angel has been recycled
    private boolean recycled = false;

    /**
     * Constructor: Creates a new RecyclableAngel
     * Calls parent (Genie) constructor using super()
     * Maximum number of wishes (though angel can grant unlimited until recycled)
     */
    public RecyclableAngel(int maxWishes) {
        super(maxWishes);  // Call parent constructor
    }

    /**
     * Method: Override of parent's grantWish()
     * Angels can grant unlimited wishes until recycled
     * boolean indicating if wish was granted
     */
    @Override
    public boolean grantWish() {
        // Can't grant wishes if recycled
        if (recycled) {
            return false;
        }
        // Angel can grant unlimited wishes until recycled
        setRemainingWishes(getRemainingWishes() - 1);  // Update wish count (though unlimited)
        return true;
    }

    /**
     * Method: Special to RecyclableAngel
     * Attempts to recycle the angel to recharge a lamp
     * boolean indicating if recycling was successful
     */
    public boolean recycle() {
        // Can only be recycled once
        if (!recycled) {
            recycled = true;
            return true;
        }
        return false;
    }

    /**
     * Getter method: Checks if angel has been recycled
     * boolean indicating recycled status
     */
    public boolean isRecycled() {
        return recycled;
    }

    /**
     * Method: Override of parent's getGenieType()
     * int value 3 indicating RecyclableAngel type
     */
    @Override
    public int getGenieType() {
        return 3;  // Type 3 is Angel
    }
}