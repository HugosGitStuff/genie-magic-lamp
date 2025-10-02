package io.codeforall.bootcamp.magic_lamp;

/**
 * A genie that grants all wishes until reaching maximum limit.
 */
public class FriendlyGenie extends Genie {
    /**
     * Constructor: Creates a new FriendlyGenie
     * Calls parent (Genie) constructor using super()
     *Maximum number of wishes this genie can grant
     */
    public FriendlyGenie(int maxWishes) {
        super(maxWishes);  // Call parent constructor
    }

    /**
     * Method: Override of parent's grantWish()
     * Friendly genies grant all wishes until they run out
     * boolean indicating if wish was granted
     */
    @Override
    public boolean grantWish() {
        if (getRemainingWishes() > 0) {
            setRemainingWishes(getRemainingWishes() - 1);  // Decrease wishes using parent's methods
            return true;
        }
        return false;
    }

    /**
     * Method: Override of parent's getGenieType()
     * int value 1 indicating FriendlyGenie type
     */
    @Override
    public int getGenieType() {
        return 1;  // Type 1 is Friendly
    }
}