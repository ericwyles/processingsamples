package lesson_1_5_Acceleration;

import processing.core.PApplet;

public class Acceleration extends PApplet {
    Mover m;

    @Override
    public void settings() {
        size(640,360);
        m = new Mover(this);
    }

    @Override
    public void draw() {
        background(255);
        m.update();
        m.edges();
        m.display();
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"Acceleration2"}, new Acceleration());
    }
}
