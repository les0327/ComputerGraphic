package lab1;

import processing.core.PApplet;

public class Drawing  implements Shape{

    //    Drawing params
    private float angle;
    private PApplet parent;
    private Shape[] shapes;

    public Drawing(float angle, Shape[] shapes, PApplet parent) {
        this.angle         = angle;
        this.parent        = parent;
        this.shapes        = shapes;
    }

    @Override
    public void display(){
        for (Shape shape : shapes){
            shape.display();
            parent.rotate(PApplet.radians(angle));
        }
    }
}
