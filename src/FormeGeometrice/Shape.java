package FormeGeometrice;

import java.util.Objects;

public class Shape {
    private String text;
    private String material;

    // constructors
    public Shape(){
        this.text = "";
        this.material = "";
    }

    public Shape(String text, String material){
        this.text = text;
        this.material = material;
    }
    // generate getters & setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // functionality
    // this method returns the shape area
    public int getSize(){
        return -1;
    }

    // this method overrides the toString method and prints the shape state
    @Override
    public String toString(){
        return "The shape's made of " + this.material
                + ", and its text displays: " + this.text + ".";
    }

    // this method overrides the equals method
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true; // checks if their memory address is the same
        }
        if(obj == null){ // checks for null given object
            return false;
        }
        if(this.getClass() != obj.getClass()){ // checks to see if the objects are part of the same class
            return false;
        }
        Shape givenShape = (Shape) obj;
        return this.text.equals(givenShape.material) && this.material.equals(givenShape.material); // checks the equality of all object fields
    }

    // this method overrides the equals method (auto-generated)
    @Override
    public int hashCode() {
        return Objects.hash(text, material);
    }
}
