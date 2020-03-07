package Recap4;

public class Main {
    public static void main (String []args){
        Vehicle myVehicle = new Vehicle("Opel", "JH4DA1850KS002731",2009,"B22PMV",2009);
        myVehicle.moveCar(33.5,22.8);
        myVehicle.display();
        myVehicle.sellVehicle("CT22WER",2020);
        myVehicle.display();
        System.out.println(myVehicle.isVinValid(true));
        myVehicle.printVinDecomposed();

    }
}
