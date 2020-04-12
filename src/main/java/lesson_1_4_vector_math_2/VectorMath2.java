package lesson_1_4_vector_math_2;

import processing.core.PApplet;
import processing.core.PVector;

public class VectorMath2 extends PApplet {
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
        mouse.mult(1f);

//        float m = mouse.mag();
//        fill(255,0,0);
//        rect(0,0,m,20);

        mouse.setMag(50);

        line(0,0,mouse.x, mouse.y);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"VectorMath2"}, new VectorMath2());
    }
}
