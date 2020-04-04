package Polimorfism;

public class SolidElement extends ChemicalElement{
    private int elasticity, plasticity;
    private String solidType, color;

    // constructors
    public SolidElement(String stateOfMatter, double meltingPoint, double boilingPoint, double density,
                        String solidType, int elasticity, int plasticity, String color){
        super(stateOfMatter,meltingPoint, boilingPoint,density);
        this.color = color;
        this.elasticity = elasticity;
        this.plasticity = plasticity;
        this.solidType = solidType;
    }

    // functionality
    @Override
    public void whatAmI(){
        System.out.println("Hey, I'm a solid element, of type " + solidType +".");
    }

}
