package lesson_1_6_acceleration_2;

import processing.core.PApplet;
import processing.core.PVector;

public class Mover extends PApplet {
    PVector location;
    PVector velocity;
    PVector acceleration;

    private PApplet p;

    Mover(PApplet p) {
        this.p = p;
        location = new PVector(p.width/2, p.height/2);
        velocity = new PVector(0,0);
    }

    void update() {
        acceleration = PVector.random2D();


        velocity.add(acceleration);
        location.add(velocity);
        velocity.limit(10);
    }

    void edges() {
        if (location.x > p.width) location.x=0;
        if (location.x < 0) location.x = p.width;
        if (location.y > p.height) location.y=0;
        if (location.y < 0) location.y = p.height;
    }

    void display() {
        p.stroke(0);
        p.strokeWeight(2);
        p.fill(127);
        p.ellipse(location.x, location.y, 48,48);
    }

}
