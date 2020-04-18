package com.ericwyles.processing;

import processing.core.PApplet;
import processing.core.PVector;

public class App extends PApplet {
    Mover m;
    boolean background=false;

    @Override
    public void settings() {
        size(1280,720);
        m = new Mover(this);
    }

    @Override
    public void draw() {
        if (!background) {
            background(244, 252, 3);
            background = true;
        }

        PVector force = new PVector(0,0.1f);

        m.applyForce(force);

        m.update();
        m.edges();
        m.display();
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"App"}, new App());
    }
}
