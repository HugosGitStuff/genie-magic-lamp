package io.codeforall.bootcamp.magic_lamp;

/**
 * MagicLamp represents a magical lamp that can create different types of genies.
 * This class demonstrates object creation, inheritance, and state management.
 * 
 * Key features:
 * - Creates alternating types of genies (Friendly and Grumpy)
 * - Can be recharged using a RecyclableAngel
 * - Keeps track of remaining genies and recharge count
 */
public class MagicLamp {
    // Instance variables to track lamp state
    private int maxGenies;        // Maximum number of genies the lamp can create
    private int remainingGenies;  // Current number of genies left in the lamp
    private int rechargeCount;    // Number of times the lamp has been recharged
    private int genieCount;       // Total number of genies created (used for alternating types)

    /**
     * Constructor: Creates a new MagicLamp with specified capacity
     * Maximum number of genies this lamp can create
     */
    public MagicLamp(int maxGenies) {
        this.maxGenies = maxGenies;
        this.remainingGenies = maxGenies;
        this.rechargeCount = 0;
        this.genieCount = 0;
    }

    /**
     * Method: Creates and returns a new Genie when the lamp is rubbed
     * A new Genie (either FriendlyGenie, GrumpyGenie, or RecyclableAngel)
     */
    public Genie rub() {
        if (remainingGenies > 0) {
            remainingGenies--;  // Decrease available genies
            genieCount++;      // Increment total genies created
            
            // Even numbers create FriendlyGenie, odd numbers create GrumpyGenie
            if (genieCount % 2 == 0) {
                return new FriendlyGenie(3); // 3 wishes for each genie
            } else {
                return new GrumpyGenie(3);
            }
        }
        // When no genies left, return RecyclableAngel with 1000 wishes
        return new RecyclableAngel(1000);
    }

    /**
     * Method: Attempts to recharge the lamp using a RecyclableAngel
     * The genie to attempt recharging with (must be RecyclableAngel)
     * boolean indicating if recharge was successful
     */
    public boolean recharge(Genie genie) {
        // Check if it's an Angel by checking its type
        if (genie.getGenieType() == 3) {
            RecyclableAngel angel = (RecyclableAngel) genie;  // Type casting
            if (!angel.isRecycled() && angel.recycle()) {
                remainingGenies = maxGenies;  // Reset genies to max
                rechargeCount++;              // Increment recharge count
                return true;
            }
        }
        return false;
    }

    /**
     * Getter method: Returns number of genies left in lamp
     */
    public int getRemainingGenies() {
        return remainingGenies;
    }

    /**
     * Getter method: Returns number of times lamp has been recharged
     */
    public int getRechargeCount() {
        return rechargeCount;
    }
}