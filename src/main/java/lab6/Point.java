package lab6;


import lombok.Getter;
import lombok.Setter;

class Point {

    float x;
    float y;
    float z;

    Point(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // angle in radians
    void rotateX(float angle){
        float prevY = y;
        float prevZ = z;
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        y = prevY * cos - prevZ * sin;
        z = prevY * sin + prevZ * cos;
    }

    void rotateY(float angle){
        float prevX = x;
        float prevZ = z;
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        x =  prevX * cos + prevZ * sin;
        z = -prevX * sin + prevZ * cos;
    }

    void rotateZ(float angle){
        float prevX = x;
        float prevY = y;
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        x = prevX * cos - prevY * sin;
        y = prevX * sin + prevY * cos;
    }
}
