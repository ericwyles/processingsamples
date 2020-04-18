package com.ericwyles.processing;

import processing.core.PApplet;
import processing.core.PVector;

public class App extends PApplet {
    Mover m1, m2, m3, m4;
    boolean background=false;

    @Override
    public void settings() {
        size(1280,720);
        m1 = new Mover(this, new RGB(255,0,0));
//        m2 = new Mover(this, new RGB(0,255,0));
//        m3 = new Mover(this, new RGB(0,0,255));
//        m4 = new Mover(this, new RGB(128,0,128));
    }

    @Override
    public void draw() {
        if (!background) {
            background(244, 252, 3);
            //background = true;
        }

        PVector gravity = new PVector(0f,0.3f);
        PVector wind = new PVector(0.2f,0f);
//        PVector f2 = new PVector(0.25f,-0.21f);
//        PVector f3 = new PVector(-0.35f,0.31f);
//        PVector f4 = new PVector(-0.45f,-0.41f);

        m1.applyForce(gravity);

        if (mousePressed)
            m1.applyForce(wind);

        processMover(m1);
//        processMover(m2,f2);
//        processMover(m3,f3);
//        processMover(m4,f4);
    }

    void processMover(Mover m) {
        m.update();
        m.edges();
        m.display();
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"App"}, new App());
    }
}
