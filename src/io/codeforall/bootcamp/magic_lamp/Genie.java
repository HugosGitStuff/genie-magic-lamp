package io.codeforall.bootcamp.magic_lamp;

/**
 * Base class for all Genie types in the system.
 * This is an example of inheritance and polymorphism in Object-Oriented Programming.
 * 
 * Key concepts:
 * - Abstract base class that defines common behavior for all genies
 * - Manages wish granting functionality and wish counting
 * - Uses polymorphism through method overriding in child classes
 */
public class Genie {
    // Instance variables for wish management
    private int maxWishes;        // Maximum number of wishes this genie can grant
    private int remainingWishes;  // Number of wishes left to grant

    /**
     * Constructor: Creates a new Genie with specified number of wishes
     * Maximum number of wishes this genie can grant
     */
    public Genie(int maxWishes) {
        this.maxWishes = maxWishes;
        this.remainingWishes = maxWishes;
    }

    /**
     * Method: Attempts to grant a wish
     * oolean indicating if wish was granted
     */
    public boolean grantWish() {
        if (remainingWishes > 0) {
            remainingWishes--;  // Decrease remaining wishes
            return true;
        }
        return false;
    }

    /**
     * Getter method: Returns number of wishes left
     */
    public int getRemainingWishes() {
        return remainingWishes;
    }

    /**
     * Setter method: Sets number of remaining wishes
     * Used by subclasses to manage wish count
     */
    public void setRemainingWishes(int remainingWishes) {
        this.remainingWishes = remainingWishes;
    }

    /**
     * Getter method: Returns maximum wishes
     */
    public int getMaxWishes() {
        return maxWishes;
    }

    /**
     * Method: Returns genie type identifier
     * Overridden by subclasses to return their specific type
     * int representing genie type (0 for base class)
     */
    public int getGenieType() {
        return 0;  // Base genie type
    }
}