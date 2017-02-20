package lab1;

import processing.core.PApplet;

class Drawing {

    //    Drawing params
    private float angle;
    private float basicRadius;
    private float deltaRadius;
    private int count;
    private PApplet parent;
    private BasicElement[] basicElements;

    public Drawing(float angle, float basicRadius, float deltaRadius, int count, PApplet parent) {

        this.angle         = angle;
        this.basicRadius   = basicRadius;
        this.deltaRadius   = deltaRadius;
        this.count         = count;
        this.parent        = parent;
        this.basicElements = new BasicElement[count];
        for (int i = 0; i < basicElements.length; i++)
            basicElements[i] = new BasicElement(0, 0, basicRadius + deltaRadius *i, parent);
    }

    void display(){
        for (BasicElement element : basicElements){
            element.display();
            parent.rotate(PApplet.radians(angle));
        }
    }
}
