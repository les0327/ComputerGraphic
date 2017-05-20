package lab5;

import lab1.BasicElement;
import lab2.Cardioid;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created on 19.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class AnimationFrame extends PApplet {

    private BasicElement basicElement;
    private final float A = 2;
    private final float B = 8;
    private final float R = 4;
    private final int r   = 25;
    private float t = 0;
    private Function x = (t) -> A*R*cos(t)-R*cos(B*t);
    private Function y = (t) -> A*R*sin(t)-R*sin(B*t);
    private Cardioid cardioid;

    public static final int ppc = 25;

    public static void main(String[] args) {
        PApplet.main("lab5.AnimationFrame");
    }

    @Override
    public void settings() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        size(toolkit.getScreenSize().width - 50, toolkit.getScreenSize().height - 50);
    }

    @Override
    public void setup() {

        background(0xFFFFFF);
        stroke(13, 200, 255);
        noFill();
        translate(width/2, height/2);

        basicElement = new BasicElement(x.calculate(t), y.calculate(t), r, this);
        cardioid = new Cardioid(0, 0, A, B, R, 2, 0.01f, this);

        frameRate(60);
    }

    @Override
    public void draw() {
        background(0xFFFFFF);
        translate(width/2, height/2);
        stroke(255, 0, 0);
        basicElement.display();
        stroke(0, 0, 255);
        cardioid.display();
        t += 0.01f;
        t %= 2*PI;
        basicElement.setCenterX(ppc*x.calculate(t));
        basicElement.setCenterY(ppc*y.calculate(t));
    }

}
