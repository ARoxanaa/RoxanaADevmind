package Polimorfism;

public class Main {
    public static void main (String[] args){
    ChemicalElement genericSolid = new ChemicalElement("Solid", 100,60,22);
    SolidElement gold = new SolidElement("Solid", 1064.18, 2970, 19.30,
            "Gold", 55,280,"Metallic Yellow");
    ChemicalElement gold2 = gold;

    genericSolid.whatAmI();
    gold.whatAmI();
    gold2.whatAmI();
    }
}
