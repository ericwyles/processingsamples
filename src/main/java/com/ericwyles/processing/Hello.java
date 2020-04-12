package com.ericwyles.processing;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

public class Hello extends PApplet {
    @Override
    public void settings() {
        size(500,300);
    }

    @Override
    public void draw() {
        background(255);
        strokeWeight(2);
        stroke(0);
        noFill();

        translate(width/2,height/2);
        ellipse(0,0,4,4);
        PVector mouse = new PVector(mouseX, mouseY);
        PVector center = new PVector(width/2,height/2);
        mouse.sub(center);

        line(0,0,mouse.x, mouse.y);

    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"Hello"}, new Hello());
    }
}
