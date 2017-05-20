package lab1;


import processing.core.PApplet;

public class BasicElement implements Shape{

    private float centerX;
    private float centerY;
    private float radius;

    private PApplet parent;

    public BasicElement(float centerX, float centerY, float radius, PApplet parent) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius  = radius;
        this.parent  = parent;
    }

    @Override
    public void display() {
        float x1 = centerX;
        float y1 = centerY - radius;
        float x2 = (float) (centerX - radius * Math.sin(Math.toRadians(60)));
        float y23 = (float) (centerY + radius * Math.cos(Math.toRadians(60)));
        float x3 = (float) (centerX + radius * Math.sin(Math.toRadians(60)));

        parent.ellipse(centerX, centerY, radius*2, radius*2);
        parent.triangle(x1, y1, x2, y23, x3, y23);
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }
}