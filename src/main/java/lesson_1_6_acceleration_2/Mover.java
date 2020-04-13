package lesson_1_6_acceleration_2;

import processing.core.PApplet;
import processing.core.PVector;

public class Mover extends PApplet {
    PVector location;
    PVector velocity;

    private PApplet p;

    Mover(PApplet p) {
        this.p = p;
        location = new PVector(p.width/2, p.height/2);
        velocity = new PVector(0,0);
    }

    void update() {
        velocity.add(calcAcceleration());
        location.add(velocity);
        velocity.limit(3);
    }

    private PVector calcAcceleration() {
        return new PVector(p.mouseX, p.mouseY)
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
        p.stroke(0);
        p.strokeWeight(1);
        p.fill(255, 0, 0);
        p.ellipse(location.x, location.y, 10,10);
    }

}
