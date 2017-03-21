package lab1;

import processing.core.PApplet;

public class Animation {

    private Shape shape;
    private float maxAngle;
    private float deltaAngle;
    private float deltaScale;
    private PApplet parent;


    private float ROTATE  = 0;
    private float SCALE   = 0;
    private boolean flag  = true;

    public Animation(Shape shape, float maxAngle, float deltaAngle, float deltaScale, PApplet parent) {
        this.shape = shape;
        this.maxAngle = maxAngle;
        this.deltaAngle = deltaAngle;
        this.deltaScale = deltaScale;
        this.parent = parent;
    }

    public void start(){
        parent.translate(parent.width/2, parent.height/2);

        if (flag) {
            parent.rotate(PApplet.radians(ROTATE += deltaAngle));
            parent.scale(SCALE += deltaScale);
        }
        else {
            parent.rotate(PApplet.radians(ROTATE -= deltaAngle));
            parent.scale(SCALE -= deltaScale);
        }

        if (ROTATE > maxAngle) {
            flag = false;
        }

        if (ROTATE < -maxAngle)
            flag = true;

        parent.pushMatrix();
            shape.display();
        parent.popMatrix();
    }
}
