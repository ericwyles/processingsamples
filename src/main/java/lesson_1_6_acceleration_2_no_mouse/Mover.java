package lesson_1_6_acceleration_2_no_mouse;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Mover extends PApplet {
    PVector location;
    PVector velocity;

    List<RGB> rgbList;
    boolean increment=true;
    int currentRgb=0;
    private float velocityLimit = 3.5f;

    private PApplet p;

    Mover(PApplet p) {
        initRgbList();
        this.p = p;
        int initX = p.width/5+30;
        int initY = p.height/5+100;
        location = new PVector(initX, initY);
        velocity = new PVector(0.5f,1.5f);
        velocity.limit(velocityLimit);
    }

    void initRgbList() {
        rgbList = new ArrayList<>();
        int red, green, blue;
        int step=15;

        for (green = 0; green < 255; green=green+step) {
            for (blue = 0; blue < 255; blue=blue+step) {
                for (red = 0; red < 255; red=red+step) {


                    rgbList.add(new RGB(red,green,blue));
                }
            }
        }
    }

    void update() {
        velocity.add(calcAcceleration());
        location.add(velocity);
        velocity.limit(velocityLimit);
    }

    private PVector calcAcceleration() {
        return new PVector(p.width/2, p.height/2)
                    .sub(location)
                    .setMag(0.03f);
    }

    void edges() {
        location.x = bound(location.x, p.width);
        location.y = bound(location.y, p.height);
    }

    private float bound(float value, int max) {
        return min(
                    max(value, 0),
                    max);
    }

    void display() {
        RGB currentRGB = getNextRgb();
        p.stroke(currentRGB.r, currentRGB.g, currentRGB.b);
        p.strokeWeight(0);
        p.fill(currentRGB.r, currentRGB.g, currentRGB.b);
        p.ellipse(location.x, location.y, 10,10);
        if (currentRgb % 100 == 0) {
            System.out.println(String.format("On value %d of %d. %d percent", currentRgb, rgbList.size(), currentRgb*100 / rgbList.size()));
            System.out.println(String.format("r=%d, g=%d, b=%d",currentRGB.r, currentRGB.g, currentRGB.b));
        }
    }

    RGB getNextRgb() {
        RGB rgb = rgbList.get(currentRgb);

        if (increment) {
            currentRgb++;
            increment = currentRgb < rgbList.size()-1;
        } else {
            currentRgb--;
            increment = currentRgb == 0;
        }


        return rgb;
    }

    class RGB {
        int r, g, b;

        RGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

}
