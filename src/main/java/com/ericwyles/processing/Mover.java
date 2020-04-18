package com.ericwyles.processing;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Mover extends PApplet {
    PVector location;
    PVector velocity;
    PVector acceleration;
    RGBSpectrum spectrum;

    private float velocityLimit = 5.0f;

    private PApplet p;

    Mover(PApplet p) {
        spectrum = new RGBSpectrum();
        this.p = p;
        int initX = p.width/2;
        int initY = p.height/2;
        location = new PVector(initX, initY);
        velocity = new PVector(0,0);
        acceleration = new PVector(0,0);
    }


    void applyForce(PVector force) {
        acceleration = force;
    }

    void update() {
        //velocity.add(calcAcceleration());
        velocity.add(acceleration);
        location.add(velocity);
        //velocity.limit(velocityLimit);
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
        RGB currentRGB = spectrum.getNextRgb();
        p.stroke(currentRGB.r, currentRGB.g, currentRGB.b);
        p.strokeWeight(0);
        p.fill(currentRGB.r, currentRGB.g, currentRGB.b);
        p.ellipse(location.x, location.y, 40,40);
    }
}
