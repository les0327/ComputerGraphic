package lab1;

import processing.core.PApplet;

import java.awt.*;

public class FrameDrawing extends PApplet{

    private BasicElement bs; // basic element
    private Drawing drawing; // drawing
    private Animation animation; // animation


    public static void main(String[] args) {
        PApplet.main("lab1.FrameDrawing");
    }

    @Override
    public void settings() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        size(toolkit.getScreenSize().width, toolkit.getScreenSize().height);
    }

    @Override
    public void setup() {
        background(0xFFFFFF);
        stroke(0x000000);
        noFill();

        bs = new BasicElement(50, 50, 50, this);
        Shape[] shapes = new BasicElement[30];
        for (int i = 0; i < shapes.length; i++)
            shapes[i] = new BasicElement(0, 0, (i + 1) * 10, this);
        drawing = new Drawing(3, shapes, this);
        animation = new Animation(drawing, 360, 6, 0.016f/2f, this);

//        drawing = new Drawing(3, 10, 5, 60, this);
//        drawing = new Drawing(60, 10, 5, 70, this);
//        drawing = new Drawing(30, 10, 10, 36, this);
        frameRate(60);
    }

    @Override
    public void draw() {
        background(0xFFFFFF);
        stroke(0, 0, 255);
        bs.display();
        animation.start();
    }


}
