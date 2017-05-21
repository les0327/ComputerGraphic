package lab7;

import processing.core.PApplet;
import processing.core.PShape;

import java.awt.*;

public class Runner extends PApplet {

    private float angle = 0;
    private PShape s;

    public static void main(String[] args) {
        PApplet.main("lab7.Runner");
    }

    @Override
    public void settings() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        size((int)toolkit.getScreenSize().getWidth() - 100, (int) toolkit.getScreenSize().getHeight() - 100, P3D);
    }

    @Override
    public void setup() {
        background(0);

        noStroke();

        s = createShape(GROUP);

        Point A = new Point(0, 0, 0);
        Point B = new Point(0, 50, 0);
        Point C = new Point(50, 0, 0);
        Point D = new Point(30, 0, 100);
        Point F = new Point(30, 0, 0);
        Point A1 = new Point(0, 0, 70);
        Point B1 = new Point(0, 50, 100);
        Point C1 = new Point(50, 0, 100);
        Point D1 = new Point(0, 30, 100);
        Point F1 = new Point(0, 30, 0);


        ShapeFactory factory = new ShapeFactory(this, 128);

        s.addChild(factory.createT(A, B,C));
        s.addChild(factory.createT(A1, D1, D));
        s.addChild(factory.createR(C, C1, B1, B));
        s.addChild(factory.createR(D, C1, B1, D1));
        s.addChild(factory.createR(F, C, C1, D));
        s.addChild(factory.createR(A, F, D, A1));
        s.addChild(factory.createR(F1, B, B1, D1));
        s.addChild(factory.createR(A, F1, D1, A1));

        frameRate(30);

    }

    @Override
    public void draw() {
        background(0xFFFFFF);
        translate(width/2, height/2, 0);
        pointLight(128, 128, 255, 0, 0, 10000000);
        scale(2.5f);
        rotateX(radians(angle++));
        rotateY(radians(angle));
        shape(s, 0, 0);
    }


}
