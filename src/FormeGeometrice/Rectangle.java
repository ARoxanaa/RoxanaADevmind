package FormeGeometrice;

import java.util.Objects;

public class Rectangle extends Shape {
    private int width;
    private int height;

    // constructors
    public Rectangle(int width, int height){
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle(String text, String material, int width, int height){
        super(text, material);
        this.width = width;
        this.height = height;
    }
    // generate getters & setters

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // functionality
    public void displayRectangleHeight(){
        System.out.println("Rectangle height is: " + this.height);
    }

    // this method overrides the parent method and returns the rectangle area
    @Override
    public int getSize(){
        return this.width * this.height;
    }

    // this method overrides the toString method and prints the triangle state
    @Override
    public String toString(){
        return "This is a Rectangle;" +
                "its height is: " + this.height
                + ", and its width is " + this.width + "\n"
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
        Rectangle givenRectangle = (Rectangle) obj;
        return super.equals(givenRectangle) &&
                this.height == givenRectangle.height &&
                this.width == givenRectangle.width; // checks the equality of all object fields + parent
    }

    // this method overrides the equals method (auto-generated)
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }
}

