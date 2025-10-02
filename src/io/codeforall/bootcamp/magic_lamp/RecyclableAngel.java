package io.codeforall.bootcamp.magic_lamp;

/**
 * A special genie that grants unlimited wishes until recycled to recharge the lamp.
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
            System.out.println("This angel has been recycled and can no longer grant wishes!");
            return false;
        }
        // Angel can grant unlimited wishes until recycled, regardless of maxWishes
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