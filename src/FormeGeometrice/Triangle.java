package FormeGeometrice;

import java.util.Objects;

public class Triangle extends Shape {
    private int base;
    private int height;

    // constructors
    public Triangle(int base, int height){
        super();
        this.base = base;
        this.height = height;
    }

    public Triangle (String text, String material, int base, int height){
        super(text, material);
        this.base = base;
        this.height = height;
    }

    // generate getters & setters

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // functionality
    public void displayTriangleHeight(){
        System.out.println("Triangle height is: " + this.height);
    }

    // this method overrides the parent method and returns the triangle area
    @Override
    public int getSize(){
        return (this.base * this.height) / 2;
    }

    // this method overrides the toString method and prints the triangle state
    @Override
    public String toString(){
        return "This is a Triangle;" +
                "its height is: " + this.height
                + ", and its base is " + this.base + "\n"
                + super.toString();
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
        Triangle givenTriangle = (Triangle) obj;
        return super.equals(givenTriangle) &&
                this.height == givenTriangle.height &&
                this.base == givenTriangle.base; // checks the equality of all object fields + parent
    }

    // this method overrides the equals method (auto-generated)
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), base, height);
    }
}
