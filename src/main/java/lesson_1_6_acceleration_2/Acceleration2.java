package lesson_1_6_acceleration_2;

import processing.core.PApplet;

public class Acceleration2 extends PApplet {
    Mover m;

    @Override
    public void settings() {
        size(640,360);
        m = new Mover(this);
    }

    @Override
    public void draw() {
        //background(255);
        m.update();
        m.edges();
        m.display();
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"YarnOfSpace"}, new Acceleration2());
    }
}
