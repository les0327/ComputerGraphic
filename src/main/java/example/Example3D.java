package example;

import processing.core.PApplet;
import processing.core.PShape;

import java.awt.*;

/**
 * Created on 02.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class Example3D extends PApplet {

    float x;
    float y;
    float z;
    float angle = 0;

    public static void main(String[] args) {
        PApplet.main("example.Example3D");
    }

    @Override
    public void settings() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        size((int)toolkit.getScreenSize().getWidth() - 100, (int) toolkit.getScreenSize().getHeight() - 100, P3D);
    }

    @Override
    public void setup() {
//        background(0xFFFFFF);
//
//        x = width/2;
//        y = height/2;
//        z = -100;
//

    }

    @Override
    public void draw() {
//        translate(x,y,z);
//        rotateX((angle += random(5) % 360));
//        rotateY((angle += random(5) % 360));
//        rotateZ((angle += random(5) % 360));
//        rectMode(CENTER);
//        rect(0 + random(x/1.5f),0 + random(y/1.5f),random(100),random(100));
//        fill(random(0, 255), random(0, 255), random(0, 255));
//        stroke(random(0, 255), random(0, 255), random(0, 255));
//
//        z++; // The createR moves forward as z increments.

    }
}
