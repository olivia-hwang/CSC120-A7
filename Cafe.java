/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * This is the constructor for a Cafe building
     * @param name is the name of the cafe (e.g. Compass)
     * @param address is the address of the cafe
     * @param nFloors is the number of floors of the cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * restock will add the specified parameters to the existing inventory
     * @param nCoffeeOunces is the ounces of coffee to add to the inventory
     * @param nSugarPackets is the number of sugar packets to add to the inventory
     * @param nCreams is the number of creams to add to the inventory
     * @param nCups is the number of cups to add to the inventory
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    /**
     * sellCoffee will remove the specified parameters from the existing inventory by "making" a coffee
     * it will indicate insufficient inventory if there are not enough ingredients, and replenish the inventory to be sufficient for the coffee.
     * @param size is the ounces of coffee in the coffee to sell
     * @param nSugarPackets is the number of sugars in the coffee to sell
     * @param nCreams is the number of creams in the coffee to sell
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces>= size & this.nSugarPackets>= nSugarPackets & this.nCreams >= nCreams){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("coffee 4 u: ☕");
        } else{
            System.out.println("insufficient inventory to sell this coffee. restocking inventory...");
            this.restock(size, nSugarPackets, nCreams, 1);
            System.out.println("restocked! coffee brewing now...");
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("heres your coffee: ☕");
        }
    }



    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass", "Neilson lib", 1);
        compassCafe.sellCoffee(5, 2, 2);
    }
    
}
