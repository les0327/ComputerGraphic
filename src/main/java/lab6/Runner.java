package lab6;

import processing.core.PApplet;

import java.awt.*;

public class Runner extends PApplet{

    public static void main(String[] args) {
        PApplet.main("lab6.Runner");
    }

    private Pyramid pyramid = new Pyramid(100);
    private float angle = 0.5f;

    @Override
    public void settings() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        size(toolkit.getScreenSize().width - 50, toolkit.getScreenSize().height - 50, P3D);
    }

    @Override
    public void setup() {
        background(0xFFFFFF);
        stroke(255, 0, 255);
        translate(width/2, height/2);
        frameRate(120);
//        pyramid.rotateX(90);
//        pyramid.rotateY(90);
    }

    @Override
    public void draw() {
        background(0xFFFFFF);
        translate(width/2, height/2);
        pyramid.draw(this);
        pyramid.rotateX(angle);
        pyramid.rotateY(angle);
//        pyramid.rotateZ(angle);
        pyramid.solveAllPlanes();
    }



}
