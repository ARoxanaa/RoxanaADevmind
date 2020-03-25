package FormeGeometrice;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        // creating 6 shapes
        Shape genericShape1 = new Shape();
        Shape genericShape2 = new Shape("Text on shape", "Stone");

        Triangle triangle1 = new Triangle(5, 12);
        Triangle triangle2 = new Triangle("Text on triangle shape", "Paper", 6, 10);

        Rectangle rectangle1 = new Rectangle(8,3);
        Rectangle rectangle2 = new Rectangle("Text on rectangle shape", "Steel", 8, 3);

        // testing the shapes
        System.out.println(genericShape1.equals(genericShape2));
        System.out.println(genericShape1.getSize());
        System.out.println(genericShape1.hashCode());
        System.out.println(genericShape2.hashCode());
        genericShape1.setMaterial("Stone");
        genericShape1.setText("Text on shape");
        System.out.println(genericShape1.equals(genericShape2));
        genericShape1 = genericShape2;
        System.out.println(genericShape1.hashCode());
        System.out.println(genericShape2.hashCode());
        System.out.println(genericShape1.equals(genericShape2));
        System.out.println(genericShape1.toString());
        System.out.println(genericShape2.toString());


        // testing triangles

        System.out.println(triangle1.equals(triangle2));
        System.out.println(triangle1.getSize());
        System.out.println(triangle1.hashCode());
        System.out.println(triangle2.hashCode());
        triangle1.setBase(12);
        System.out.println(triangle1.hashCode());
        triangle1.setMaterial("Paper");
        triangle1.setText("Text on triangle shape");
        System.out.println(triangle1.hashCode());

        // ex. 7.
        ArrayList<Shape> shapesList = new ArrayList<>();
        shapesList.add(genericShape1);
        shapesList.add(genericShape2);
        shapesList.add(triangle1);
        shapesList.add(triangle2);
        shapesList.add(rectangle1);
        shapesList.add(rectangle2);

        // run toString on all elements
        for(int i = 0; i < shapesList.size(); i++){
            System.out.println(shapesList.get(i).toString());
        }

        // run getSize on all elements
        for(int i = 0; i < shapesList.size(); i++){
            System.out.println(shapesList.get(i).getSize());
        }
        // looks like both getSize and toString prints the overriden methods from the corresponding child classes

        // ex. 8 Downcasting

        for(int i = 0; i < shapesList.size();i++){
            if(shapesList.get(i) instanceof Triangle){
                ((Triangle) shapesList.get(i)).displayTriangleHeight();
            }
            if(shapesList.get(i) instanceof Rectangle){
                ((Rectangle) shapesList.get(i)).displayRectangleHeight();
            }
        }

    }
}
