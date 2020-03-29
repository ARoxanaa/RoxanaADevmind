package Compunere;

import java.util.ArrayList;

public class Screen {
    private ArrayList<Pixel> pixels;
    private Dimensions dimensions;

    // constructors
    public Screen(int pixels, Dimensions dimensions){
        this.pixels = new ArrayList<Pixel>(pixels);
        this.dimensions = dimensions;
    }

    public Screen(int pixels, int width, int length, int depth){
        this.pixels = new ArrayList<Pixel>(pixels);
        this.dimensions = new Dimensions(width, length, depth);
    }

    // functionality
    public void setPixel(int index, String color){
        this.pixels.get(index).setColor(color);
    }

    // eu asta am inteles ca trebuia sa fac in urma descrierii metodei "Metoda va colora tot ecranul in acea culoare.";
    // deci am golit ArrayListul de pixeli si am adaugat unul singur de culoarea primita; ¯\_(ツ)_/¯
    public void colorScreen(String color){
        this.pixels.clear();
        Pixel newPixel = new Pixel(color);
        this.pixels.add(newPixel);
    }
}
