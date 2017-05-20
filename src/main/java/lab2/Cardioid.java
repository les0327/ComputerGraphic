package lab2;

import lab1.Shape;
import processing.core.PApplet;

import java.util.ArrayList;

/**
 * Created on 21.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class Cardioid implements Shape {

    private int cx;
    private int cy;

    private float A;
    private float B;
    private float R;
    private float N;
    private float dt;

    private PApplet parent;

    private float[] x;
    private float[] y;

    public Cardioid(int cx, int cy, float a, float b, float r, float n, float dt, PApplet parent) {
        this.cx     = cx;
        this.cy     = cy;
        A           = a;
        B           = b;
        R           = r;
        N           = n;
        this.dt     = dt;
        this.parent = parent;

        ArrayList<Float> xList = new ArrayList<>();
        ArrayList<Float> yList = new ArrayList<>();

        float t = 0;
        while (t < N * PApplet.PI){
            t += dt;
            xList.add(A * R * PApplet.cos(t) - R * PApplet.cos(B * t) + cx);
            yList.add(-A * R * PApplet.sin(t) + R * PApplet.sin(B * t) + cy);
        }

        double[] xd = xList.stream().mapToDouble(x -> x * FrameCardioid.ppc).toArray();
        double[] yd = yList.stream().mapToDouble(y -> y * FrameCardioid.ppc).toArray();

        x = new float[xd.length];
        y = new float[yd.length];

        for (int i = 0; i < x.length; i++){
            x[i] = (float) xd[i];
            y[i] = (float) yd[i];
        }
    }

    @Override
    public void display() {
        for (int i = 1; i < x.length; i++)
            parent.line(x[i - 1], y[i - 1], x[i], y[i]);
    }

    public float[] getX() {
        return x;
    }

    public float[] getY() {
        return y;
    }
}
