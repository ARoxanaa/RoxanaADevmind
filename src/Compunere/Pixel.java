package Compunere;

public class Pixel {
    private String color;

    // constructors
    public Pixel(){
        this.color = "#FFFFFF";
    }

    public Pixel(String color){
        this.color = color;
    }

    // setter
    public void setColor(String color){
        this.color = color;
    }
}
