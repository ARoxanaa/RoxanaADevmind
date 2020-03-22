package Mostenire;

public class OnAir extends Vehicle {
    private int noTurbines = 2;
    private boolean hasFirstClass;

    //constructors
    public OnAir(String serialNumber, int noPersons){
        super(serialNumber, noPersons);
    }

    public OnAir(String serialNumber, int noPersons, String name){
        super(serialNumber, noPersons, name);
    }

    public OnAir(String serialNumber, int noPersons, String name, int noTurbines){
        this(serialNumber, noPersons, name);
        this.noTurbines = noTurbines;
    }

    public OnAir(String serialNumber, int noPersons, String name, int noTurbines, boolean hasFirstClass){
        this(serialNumber, noPersons, name, noTurbines);
        this.hasFirstClass = hasFirstClass;
    }

    //functionality
    public boolean goTo(double positionX, double positionY){
        System.out.println("Flying the airplane to coordinates: [" + positionX + ", " + positionY + "]");
        return true;
    }

    @Override
    public boolean addFuel(double amount) {
        System.out.println("Adding " + amount + " l of fuel to the airplane");
        return true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Vessel properties:" + "\n\t - number of turbines: " + this.noTurbines +
                "\n\t");
        if(this.hasFirstClass){
            System.out.print("- has first class");
        } else {
            System.out.print("- does not have first class");
        }
    }
}
