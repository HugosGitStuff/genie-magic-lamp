package io.codeforall.bootcamp.magic_lamp;

/**
 * Test class demonstrating the Magic Lamp system functionality.
 */
public class Main {
    /**
     * Main method: Entry point of the program
     * Demonstrates the functionality of the Magic Lamp system
     */
    public static void main(String[] args) {
        // Create a magic lamp with capacity of 3 genies
        MagicLamp lamp = new MagicLamp(5);  // Constructor call
        
        // Display initial lamp state
        System.out.println("\nMagic Lamp1"); // testing lamp
        System.out.println("\nYou've got " + lamp.getRemainingGenies() + " genies!");

        // Test rubbing the lamp multiple times
        System.out.println("\nRubing...");
        for (int i = 1; i <= 6; i++) {  // Loop to test multiple rubs
            Genie genie = lamp.rub();    // Method call to create new genie
            System.out.println("\nRub " + i);
            
            // Get genie type using polymorphic method call
            int genieType = genie.getGenieType();
            
            // Identify genie type using type constants
            if (genieType == 1) {
                System.out.println("Hello! I'm your Friendly Genie and I can grant you 3 wishes!");
            } else if (genieType == 2) {
                System.out.println("Hurry up! What are your wishes!?");
            } else if (genieType == 3) {
                System.out.println("I'm your Angel Genie! I can grant unlimited wishes! But only until you recycle thelamp!");
            }

            // Test differentfor angel genie
            if (genieType == 3) {  // Special handling for Angel
                // Try to grant some wishes with Angel
                for (int j = 1; j <= 3; j++) {
                    System.out.println("Wish " + j + " granted: " + genie.grantWish());
                }
                
                // Test lamp recharging with angel
                System.out.println("\nTrying to recharge lamp with angel...");
                boolean recharged = lamp.recharge(genie);  // Method call to recharge lamp
                System.out.println("Lamp recharged: " + recharged);
                System.out.println("New remaining genies: " + lamp.getRemainingGenies());
                
                // Test wish granting after recycling
                System.out.println("Trying to grant wish after recycling: " + genie.grantWish());
            } else {
                // Test wish granting for regular genies
                System.out.println("What are your wishes?");
                System.out.println("Wish 1 granted: " + genie.grantWish());  // First wish
                System.out.println("Wish 2 granted: " + genie.grantWish()); // Second wish (will fail for GrumpyGenie)
                System.out.println("Wish 3 granted: " + genie.grantWish());  // Third wish (will fail for GrumpyGenie)
            }
            
            // Display remaining wishes
            System.out.println("Remaining wishes: " + genie.getRemainingWishes());
        }
    }
}