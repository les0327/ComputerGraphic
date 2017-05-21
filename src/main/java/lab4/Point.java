package lab4;

/**
 * Created on 18.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
class Point {

    private double x;
    private double y;
    private double z;

    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    double getZ() {
        return z;
    }
}
