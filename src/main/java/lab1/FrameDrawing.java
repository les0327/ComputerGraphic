package lab1;

import processing.core.PApplet;

import java.awt.*;

public class FrameDrawing extends PApplet{




    private int   ROTATE  = 0;
    private boolean flag  = true;
    private BasicElement bs; // basic element
    private Drawing drawing;

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
//        drawing = new Drawing(3, 10, 5, 60, this);
//        drawing = new Drawing(60, 10, 5, 70, this);
//        drawing = new Drawing(30, 10, 10, 36, this);
        frameRate(60);
    }

    @Override
    public void draw() {
        background(0xFFFFFF);

        bs.display();

        translate(width/2, height/2);

        if (flag)
            rotate(radians(ROTATE++));
        else
            rotate(radians(ROTATE--));

        if (ROTATE == 60)
            flag = false;

        if (ROTATE == -60)
            flag = true;

        pushMatrix();
        drawing.display();
        popMatrix();
    }


}
