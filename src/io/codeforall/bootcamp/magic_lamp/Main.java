package io.codeforall.bootcamp.magic_lamp;

/**
 * Main class that demonstrates the usage of the Magic Lamp system.
 * This class shows how all the components work together.
 * 
 * Key demonstrations:
 * - Creating and using a MagicLamp
 * - Getting different types of genies
 * - Granting wishes with different genie types
 * - Recharging the lamp using a RecyclableAngel
 * - Testing all major functionality of the system
 */
public class Main {
    /**
     * Main method: Entry point of the program
     * Demonstrates the functionality of the Magic Lamp system
     */
    public static void main(String[] args) {
        // Create a magic lamp with capacity of 3 genies
        MagicLamp lamp = new MagicLamp(3);  // Constructor call
        
        // Display initial lamp state
        System.out.println("Testing Magic Lamp:");
        System.out.println("Initial remaining genies: " + lamp.getRemainingGenies());

        // Test rubbing the lamp multiple times
        System.out.println("\nRubbing the lamp multiple times:");
        for (int i = 1; i <= 4; i++) {  // Loop to test multiple rubs
            Genie genie = lamp.rub();    // Method call to create new genie
            System.out.println("\nRub #" + i);
            
            // Get genie type using polymorphic method call
            int genieType = genie.getGenieType();
            
            // Identify genie type using type constants
            if (genieType == 1) {
                System.out.println("Got a Friendly Genie!");
            } else if (genieType == 2) {
                System.out.println("Got a Grumpy Genie!");
            } else if (genieType == 3) {
                System.out.println("Got a Recyclable Angel!");
            }

            // Test different behavior based on genie type
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
                System.out.println("Granting 2 wishes:");
                System.out.println("Wish 1 granted: " + genie.grantWish());  // First wish
                System.out.println("Wish 2 granted: " + genie.grantWish());  // Second wish (will fail for GrumpyGenie)
            }
            
            // Display remaining wishes
            System.out.println("Remaining wishes: " + genie.getRemainingWishes());
        }
    }
}