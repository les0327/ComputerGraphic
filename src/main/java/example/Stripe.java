package example;

import processing.core.PApplet;

public class Stripe {

    private PApplet parent;
    private float x;
    private float speed;
    private float w;
    private boolean mouse;

    public Stripe(PApplet parent){
        this.parent = parent;
        this.x = 0;
        this.speed = parent.random(1);
        this.w = parent.random(10, 30);
        this.mouse = false;
    }

    public void display(){
        parent.fill(255,100);
        parent.noStroke();
        parent.rect(x,0,w,parent.height);
    }

    public void move() {
        x += speed;
        if (x > parent.width+20) x = -20;
    }
}
