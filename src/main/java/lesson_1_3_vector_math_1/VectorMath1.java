package lesson_1_3_vector_math_1;

import processing.core.PApplet;
import processing.core.PVector;

public class VectorMath1 extends PApplet {
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

        mouse.mult(2f);

        line(0,0,mouse.x, mouse.y);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"VectorMath1"}, new VectorMath1());
    }
}
