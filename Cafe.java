/**
 * The Cafe class represents a cafe building that manages a simple coffee inventory.
 * It extends the Building class and allows selling and restocking inventory.
 */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs a new Cafe with initial inventory values.
     * 
     * @param name           The name of the cafe.
     * @param address        The address of the cafe.
     * @param nFloors        Number of floors in the cafe.
     * @param nCoffeeOunces  Starting coffee inventory in ounces.
     * @param nSugarPackets  Starting sugar packet inventory.
     * @param nCreams        Starting cream inventory.
     * @param nCups          Starting cup inventory.
     */

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells a cup of coffee and updates inventory. Restocks automatically if needed.
     * 
     * @param size            Ounces of coffee in the drink.
     * @param nSugarPackets   Number of sugar packets.
     * @param nCreams         Number of cream splashes.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            System.out.println("Not enough inventory! Restocking..."); //commented out because restock was removed from carefrequirements in the repo
            restock(100, 50, 50, 50); // arbitrary restock values 
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Coffee Sold!");
    }

    /**
     * Restocks the cafe's inventory.
     * 
     * @param nCoffeeOunces  Amount of coffee to add in ounces.
     * @param nSugarPackets  Amount of sugar packets to add.
     * @param nCreams        Amount of cream to add.
     * @param nCups          Amount of cups to add.
     */

     public void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked inventory!");
    
    }

    /**
     * For testing the Cafe class.
     */
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "42 Elm St", 1, 100, 50, 50, 30);
        compass.sellCoffee(12, 2, 3); // Should work normally
        compass.sellCoffee(200, 10, 10); // Should trigger restock
    }
}