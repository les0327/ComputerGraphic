package lab2;

import lab1.Animation;
import lab1.Drawing;
import lab1.Shape;
import processing.core.PApplet;

import java.awt.*;

public class FrameCardioid extends PApplet{

    private Shape cardioid;
    private Drawing shape;
    private Animation animation;

    public static final int ppc = 25;

    public static void main(String[] args) {
        PApplet.main("lab2.FrameCardioid");
    }

    @Override
    public void settings() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        size(toolkit.getScreenSize().width - 50, toolkit.getScreenSize().height - 50, P2D);
    }

    @Override
    public void setup() {

        background(0xFFFFFF);
        stroke(0x000000);
        strokeWeight(0.5f);
        noFill();
        translate(width/2, height/2);
        textSize(10);

        cardioid = new Cardioid(-23, -12, 2, 2, 1, 2, 0.01f, this);

        Shape[] shapes = new Shape[10];
        for (int i = 0; i < shapes.length; i++)
            shapes[i] = new Cardioid(0, 0, 2, 2,(i + 1)/2.0f , 2, 0.05f,  this);
        shape = new Drawing(30, shapes, this);
        animation = new Animation(shape, 60, 1, 0.016f, this);

        frameRate(25);
    }

    @Override
    public void draw() {
        background(0xFFFFFF);

        pushMatrix();
            translate(width/2, height/2);
            cardioid.display();
        popMatrix();

        drawCoordinateSystem();
        animation.start();
    }

    private void drawCoordinateSystem(){
        int bufx = width/2;
        int bufy = height/2;
        line(0, bufy, width, bufy);
        line(bufx, 0, bufx, height);

        int position = 0;
        while(position * ppc < bufx){
            position++;
            line( bufx + position * ppc, bufy - 3,  bufx + position * ppc, bufy +3);
            line( bufx - position * ppc, bufy - 3,  bufx - position * ppc, bufy +3);
            text(position + "", bufx + position * ppc - textWidth(position + "") / 2, bufy + 10);
            fill(0x000000);
            text(-position + "", bufx - position * ppc - textWidth(-position + "") / 2, bufy + 10);
            fill(0x000000);
    }

        position = 0;
        while(position * ppc < bufy){
            position++;
            line( bufx - 3, bufy + position * ppc,  bufx + 3, bufy + position * ppc);
            line( bufx - 3, bufy - position * ppc,  bufx + 3, bufy - position * ppc);
            text(position + "", bufx - 10 - textWidth(position + "") / 2, bufy + position * ppc );
            fill(0x000000);
            text(-position + "", bufx - 10 - textWidth(-position + "") / 2, bufy - position * ppc );
            fill(0x000000);
        }
    }
}
