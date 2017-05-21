package lab6;

import lombok.Getter;
import processing.core.PApplet;

import java.util.Arrays;

public class Pyramid {

    private float[] a = new float[4];
    private float[] b = new float[4];
    private float[] c = new float[4];
    private float[] d = new float[4];
    private float[] f = new float[4];

    private static  @Getter Point S;
    private static  @Getter Point A;
    private static  @Getter Point B;
    private static  @Getter Point C;
    private static  @Getter Point D;

    Pyramid(int ppc){
        S  = new Point(0, 0, 0);
        A  = new Point(1f * ppc, 1f * ppc, -1f * ppc);
        B  = new Point(-1f * ppc, 1f * ppc, -1f * ppc);
        C  = new Point(-1f * ppc, -1f * ppc, -1f * ppc);
        D  = new Point(1f * ppc, -1f * ppc, -1f * ppc);

        solveAllPlanes();
    }

    void draw(PApplet parent){
        boolean[] visibility = visibility();

        if (visibility[0] || visibility[1]) // SB
            parent.line(S.x, S.y, S.z, B.x, B.y, B.z);
        if (visibility[1] || visibility[2]) // SC
            parent.line(S.x, S.y, S.z, C.x, C.y, C.z);
        if (visibility[2] || visibility[3]) // SD
            parent.line(S.x, S.y, S.z, D.x, D.y, D.z);
        if (visibility[3] || visibility[0]) // SA
            parent.line(S.x, S.y, S.z, A.x, A.y, A.z);
        if (visibility[0] || visibility[4]) // AB
            parent.line(A.x, A.y, A.z, B.x, B.y, B.z);
        if (visibility[1] || visibility[4]) // BC
            parent.line(B.x, B.y, B.z, C.x, C.y, C.z);
        if (visibility[2] || visibility[4]) // CD
            parent.line(C.x, C.y, C.z, D.x, D.y, D.z);
        if (visibility[3] || visibility[4]) // DA
            parent.line(D.x, D.y, D.z, A.x, A.y, A.z);

        parent.fill(0x000000);
        parent.text("S", S.x, S.y, S.z);
        parent.text("A", A.x, A.y, A.z);
        parent.text("B", B.x, B.y, B.z);
        parent.text("C", C.x, C.y, C.z);
        parent.text("D", D.x, D.y, D.z);
    }

    void rotateX(float angle){
        angle = (float) Math.toRadians(angle);
        S.rotateX(angle);
        A.rotateX(angle);
        B.rotateX(angle);
        C.rotateX(angle);
        D.rotateX(angle);
    }

    void rotateY(float angle){
        angle = (float) Math.toRadians(angle);
        S.rotateY(angle);
        A.rotateY(angle);
        B.rotateY(angle);
        C.rotateY(angle);
        D.rotateY(angle);
    }

    public void rotateZ(float angle){
        angle = (float) Math.toRadians(angle);
        S.rotateZ(angle);
        A.rotateZ(angle);
        B.rotateZ(angle);
        C.rotateZ(angle);
        D.rotateZ(angle);
    }

    void solveAllPlanes(){
        solvePlane(a, S, A, B);
        solvePlane(b, S, B, C);
        solvePlane(c, S, C, D);
        solvePlane(d, S, D, A);
        solvePlane(f, A, B, C);
        normalizePlane(a);
        normalizePlane(b);
        normalizePlane(c);
        normalizePlane(d);
        normalizePlane(a);
        normalizePlaneF();
    }

    private void solvePlane(float[] plane, Point p1, Point p2, Point p3){

        float A = (p2.y - p1.y) * (p3.z - p1.z) - (p2.z - p1.z) * (p3.y - p1.y);
        float B = (p2.x - p1.x) * (p3.z - p1.z) - (p2.z - p1.z) * (p3.x - p1.x);
        float C = (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);


        plane[0] = A;
        plane[1] = -B;
        plane[2] = C;
        plane[3] = -p1.x * A + p1.y * B + -p1.z * C;

    }

    private void normalizePlane(float[] plane){
        float[] point = new float[4];
        point[0]      = ((A.x + C.x) / 2 + S.x) / 2;
        point[1]      = ((A.y + C.y) / 2 + S.y) / 2;
        point[2]      = ((A.z + C.z) / 2 + S.z) / 2;

        float scalar = scalar(plane, point);
        if (scalar >= 0)
            for (int i = 0; i < plane.length; i++)
                plane[i] *= -1;
    }

    private void normalizePlaneF(){
        float[] point = new float[4];
        point[0]      = ((A.x + C.x) / 2 + S.x) / 2;
        point[1]      = ((A.y + C.y) / 2 + S.y) / 2;
        point[2]      = ((A.z + C.z) / 2 + S.z) / 2;

        float scalar = scalar(f, point);

        if (scalar <= 0)
            for (int i = 0; i < f.length; i++)
                f[i] *= -1;
    }

    private boolean[] visibility(){
        boolean[] visibility = new boolean[5];
        float[] observer = {0, 0, 1, 0};

        visibility[0] = scalar(observer, a) >= 0;
        visibility[1] = scalar(observer, b) >= 0;
        visibility[2] = scalar(observer, c) >= 0;
        visibility[3] = scalar(observer, d) >= 0;
        visibility[4] = scalar(observer, f) > 0;

        return visibility;
    }

    private float scalar(float[] v1, float[] v2){
        float scalar = 0;

        for (int i =0; i < v1.length; i++)
            scalar += v1[i] * v2[i];

        return scalar;
    }
}
