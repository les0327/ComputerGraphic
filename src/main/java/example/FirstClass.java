package example;

import processing.core.*;

public class FirstClass extends PApplet {

    private Stripe[] stripes = new Stripe[50];

    public static void main(String[] args) {
        PApplet.main("example.FirstClass");
    }

    @Override
    public void settings() {
        size(200, 300);
    }

    @Override
    public void setup() {
        for (int i = 0; i < stripes.length; i++) {
            stripes[i] = new Stripe(this);
        }
    }

    @Override
    public void draw() {
        background(100);
        for (Stripe stripe : stripes) {
            stripe.move();
            stripe.display();
        }
    }
}
