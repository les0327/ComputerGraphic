package lab7;

import processing.core.PApplet;
import processing.core.PShape;

class ShapeFactory {

    private PApplet parent;
    private int rgb;

    ShapeFactory(PApplet parent, int rgb) {
        this.parent = parent;
        this.rgb = rgb;
    }

    PShape createT(Point p1, Point p2, Point p3){
        PShape shape = parent.createShape();
        shape.beginShape();
        shape.noStroke();
        shape.fill(rgb);
        shape.vertex(p1.x, p1.y, p1.z);
        shape.vertex(p2.x, p2.y, p2.z);
        shape.vertex(p3.x, p3.y, p3.z);
        shape.endShape(PApplet.CLOSE);
        return shape;
    }

    PShape createR(Point p1, Point p2, Point p3, Point p4){
        PShape shape = parent.createShape();
        shape.beginShape();
        shape.noStroke();
        shape.fill(rgb);
        shape.vertex(p1.x, p1.y, p1.z);
        shape.vertex(p2.x, p2.y, p2.z);
        shape.vertex(p3.x, p3.y, p3.z);
        shape.vertex(p4.x, p4.y, p4.z);
        shape.endShape(PApplet.CLOSE);
        return shape;
    }
}
