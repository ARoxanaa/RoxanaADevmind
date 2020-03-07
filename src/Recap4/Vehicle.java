package Recap4;

public class Vehicle {
    private static String producedBy;
    private int productionYear;
    private String vin;
    private String plateNumber;
    private double kilometers;
    private int lastSoldOnYear;
    private double positionX, positionY;

    public Vehicle(String producedBy, String vin, int productionYear, String plateNumber, double kilometers,
                   int lastSoldOnYear, double positionX, double positionY){
        Vehicle.producedBy = producedBy;
        this.vin = vin;
        this.productionYear = productionYear;
        this.plateNumber = plateNumber;
        this.kilometers = kilometers;
        this.lastSoldOnYear = lastSoldOnYear;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Vehicle(String producedBy, String vin, int productionYear){
        this(producedBy,vin,productionYear,"UNKNOWN",0,0,0.0,0.0);
    }

    public Vehicle(String producedBy, String vin, int productionYear, String plateNumber, int lastSoldOnYear){
        this(producedBy,vin,productionYear,plateNumber,0,lastSoldOnYear,0.0,0.0);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getKilometers() {
        return kilometers;
    }


    public void sellVehicle(String plateNumber, int lastSoldOnYear){
        setPlateNumber(plateNumber);
        this.lastSoldOnYear = lastSoldOnYear;
        System.out.println("Sold!");
    }

    public void moveCar(double positionY, double positionX){
        double oldPositionX = this.positionX;
        double oldPositionY = this.positionY;
        this.positionX = positionX;
        this.positionY = positionY;
        kilometers += Math.sqrt(Math.pow(positionX - oldPositionX,2) + Math.pow(positionY - oldPositionY,2));
        System.out.println("Done! Total Kilometers: " + this.getKilometers());
    }

    public boolean isVinValid(boolean isDrivingInNorthAmerica){
        if(!isDrivingInNorthAmerica){
            return true;
        }

        if(this.vin.length() < 17){
            return false;
        }
        char[] vinArr = this.vin.toUpperCase().toCharArray();
        return validateVIN(vinArr);
    }

    private boolean validateVIN(char[] arr){
        int[] weight = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] vinArr = new int[17];
        char check = arr[8];
        int checkDigit;
        if(!Character.isDigit(check) && check != 'X'){
            return false;
        } else if (check == 'X'){
            checkDigit = 10;
        } else {
            checkDigit = Character.getNumericValue(check);
        }

        for(int i = 0; i < arr.length;i++){
            char checkArr = arr[i];
            if(Character.isAlphabetic(checkArr)){
                switch (arr[i]) {
                    case 'A':
                    case 'J':
                        vinArr[i] = 1;
                        break;
                    case 'B':
                    case 'K':
                    case 'S':
                        vinArr[i] = 2;
                        break;
                    case 'C':
                    case 'L':
                    case 'T':
                        vinArr[i] = 3;
                        break;
                    case 'D':
                    case 'M':
                    case 'U':
                        vinArr[i] = 4;
                        break;
                    case 'E':
                    case 'N':
                    case 'V':
                        vinArr[i] = 5;
                        break;
                    case 'F':
                    case 'W':
                        vinArr[i] = 6;
                        break;
                    case 'G':
                    case 'P':
                    case 'X':
                        vinArr[i] = 7;
                        break;
                    case 'H':
                    case 'Y':
                        vinArr[i] = 8;
                        break;
                    case 'R':
                    case 'Z':
                        vinArr[i] = 9;
                        break;
                }
            } else {
                vinArr[i] = Character.getNumericValue(arr[i]);
            }
        }

        int result = 0;
        for(int i = 0; i < 17; i++){
            result += vinArr[i] * weight[i];
        }

        return result % 11 == checkDigit;
    }

    public void printVinDecomposed(){
        System.out.println("Identificatorul producatorului: " + this.vin.substring(0,2));
        System.out.println("Atributele vehiculului: " + this.vin.substring(3,7));
        System.out.println("Cifra de verificare: " + this.vin.charAt(8));
        System.out.println("Anul productiei modelului: " + this.vin.charAt(9));
        System.out.println("Seria fabricii: " + this.vin.charAt(10));
        System.out.println("Identificatorul numeric: " + this.vin.substring(11,16));
    }

    public void display(){
        System.out.println(Vehicle.producedBy);
        System.out.println(this.productionYear);
        System.out.println(this.vin);
        System.out.println(this.plateNumber);
        System.out.println(this.kilometers);
        System.out.println(this.lastSoldOnYear);
        System.out.println(this.positionX);
        System.out.println(this.positionY);
    }
}
