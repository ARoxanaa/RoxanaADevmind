package Polimorfism;

public class ChemicalElement {
    String stateOfMatter;
    double meltingPoint, boilingPoint, density;

    // constructors
    public ChemicalElement(String stateOfMatter, double meltingPoint, double boilingPoint, double density){
        this.stateOfMatter = stateOfMatter;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.density = density;
    }

    // functionality
    public void whatAmI(){
        System.out.println("Hey, I'm a generic " + this.stateOfMatter + " element.");
    }
}
