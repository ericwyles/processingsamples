package com.ericwyles.processing;

import processing.core.PApplet;

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
        if (background == false) {
            background(244, 252, 3);
            background = true;
        }

        m.update();
        m.edges();
        m.display();
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"App"}, new App());
    }
}
