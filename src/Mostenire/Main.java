package Mostenire;

public class Main {
    public static void main (String[] args){
        // create objects
        OnRoad masina = new OnRoad("AKH129",4, "Kia", 6, 8);
        OnAir avion = new OnAir("AUE7263",2,"Avion",2,false);
        OnWater barca = new OnWater("POE2736",8,"Random female name", 2,50);

        // test OnRoad object
        masina.printInfo();
        System.out.print(masina.getSerialNumber());
        masina.goTo(22.7,18.2);
        masina.addFuel(40);
        masina.printInfo();

        // test OnAir object
        avion.printInfo();
        System.out.print(avion.getSerialNumber());
        avion.goTo(22.7,18.2);
        avion.addFuel(40);
        avion.printInfo();

        // test OnWater object
        barca.printInfo();
        System.out.print(barca.getSerialNumber());
        barca.goTo(22.7,18.2);
        barca.addFuel(40);
        barca.printInfo();
    }
}
