package com.company.VariantB.Dot;


public class Dot {

    private double x;
    private double y;
    private double z;
    private double changingOfX;
    private double changingOfY;
    private double changingOfZ;
    private double time;

    /*
    public Dot() {

    }


    //передаеся значение ссылки в метод
    void method1(Dot object) {
        System.out.println(object);
//        object.setX(3);
        object = new Dot(2, 2, 2);
        System.out.println(object);
    }

    //передается значение в метод
    void method2(int primitive) {
        System.out.println(primitive);
        primitive = 3;
        System.out.println(primitive);
    }
    //пример для того, чтобы понять что передается в метод
    public static void main(String[] a) {
        Dot test = new Dot();

        Dot dot = new Dot(1, 1, 1);
        System.out.println(dot);
        test.method1(dot);
        System.out.println(dot);

        int primitive = 2;
        test.method2(primitive);
        System.out.println(primitive);
    }*/

    Dot(double x, double y, double z){
        setX(x);
        setY(y);
        setZ(z);
    }
    public Dot(double x, double y, double z, double changingOfX, double changingOfY, double changingOfZ){
        setX(x);
        setY(y);
        setZ(z);
        setChangingOfX(changingOfX);
        setChangingOfY(changingOfY);
        setChangingOfZ(changingOfZ);
    }

    private void setX(double x) {
        this.x = x;
    }
    private void setY(double y) {
        this.y = y;
    }
    private void setZ(double z) {
        this.z = z;
    }
    private void setChangingOfX(double changingOfX) {
        this.changingOfX = changingOfX;
    }
    private void setChangingOfY(double changingOfY) {
        this.changingOfY = changingOfY;
    }
    private void setChangingOfZ(double changingOfZ) {
        this.changingOfZ = changingOfZ;
    }
    private void setTime(double time){
        this.time = time;
    }

    private double getX() {
        return x;
    }
    private double getY() {
        return y;
    }
    private double getZ() {
        return z;
    }
    private double getTime() {
        return time;
    }

    private static double pathwayFromTo(Dot dot1, Dot dot2) {
        double projectionOnX;
        double projectionOnY;
        double projectionOnZ;
        double projectionOnXY;

        if(dot1.getX() > dot2.getX()) {
            projectionOnX= dot1.getX()-dot2.getX();
        } else {
            projectionOnX= dot2.getX()-dot1.getX();
        }

        if(dot1.getY() > dot2.getY()) {
            projectionOnY= dot1.getY()-dot2.getY();
        } else {
            projectionOnY= dot2.getY()-dot1.getY();
        }

        if(dot1.getZ() > dot2.getZ()) {
            projectionOnZ= dot1.getZ()-dot2.getZ();
        } else {
            projectionOnZ= dot2.getZ()-dot1.getZ();
        }

        projectionOnXY = Math.sqrt(Math.pow(projectionOnX, 2)+Math.pow(projectionOnY, 2));
        return Math.sqrt(Math.pow(projectionOnXY, 2)+Math.pow(projectionOnZ, 2));
    }


    private double[] traectoriaXYZ(double time) {
        return new double[]{getX()+ changingOfX*time, getY()+ changingOfY*time, getZ()+ changingOfZ*time};
    }

    private Dot dotInNSteps(double nSteps_time) {
        double[] newXYZdotInNStep = traectoriaXYZ(nSteps_time);
        return new Dot(newXYZdotInNStep[0], newXYZdotInNStep[1], newXYZdotInNStep[2]);
    }

    public double whatSpeed(double pathwayTime) {
        Dot finish = dotInNSteps(pathwayTime);
        return Dot.pathwayFromTo(this, finish)/pathwayTime;
    }


    public static String willPathwaysCrossEachOther(Dot dot1, Dot dot2) {
        Dot dot1InOneStep = dot1.dotInNSteps(1);
        Dot dot2InOneStep = dot2.dotInNSteps(1);

        if(Math.abs(dot1.getX()-dot2.getX()) < Math.abs(dot1InOneStep.getX()-dot2InOneStep.getX()) ||
           Math.abs(dot1.getY()-dot2.getY()) < Math.abs(dot1InOneStep.getY()-dot2InOneStep.getY()) ||
           Math.abs(dot1.getZ()-dot2.getZ()) < Math.abs(dot1InOneStep.getZ()-dot2InOneStep.getZ())) {
            return "No, pathways won't cross each other (100%).";
        }

        if(Math.abs(dot1.getX()-dot2.getX()) >= Math.abs(dot1InOneStep.getX()-dot2InOneStep.getX()) ||
           Math.abs(dot1.getY()-dot2.getY()) >= Math.abs(dot1InOneStep.getY()-dot2InOneStep.getY()) ||
           Math.abs(dot1.getZ()-dot2.getZ()) >= Math.abs(dot1InOneStep.getZ()-dot2InOneStep.getZ())) {
            for(double i = 0; i <= 10000; i++) {
                Dot checkpoint1OfDot1 = dot1.dotInNSteps(i);
                for(double j = 0; j <= 10000; j++) {
                    Dot checkpoint2OfDot2 = dot2.dotInNSteps(j);
                    if(checkpoint1OfDot1.getX() == checkpoint2OfDot2.getX() &&
                       checkpoint1OfDot1.getY() == checkpoint2OfDot2.getY() &&
                       checkpoint1OfDot1.getZ() == checkpoint2OfDot2.getZ()){
                        return "Yes, pathways will cross each other in point (x/y/z): " + checkpoint1OfDot1.getX() +
                                "/" + checkpoint1OfDot1.getY() +
                                "/" + checkpoint1OfDot1.getZ();
                    }
                }
            }

            Dot dot1In10000Step = dot1.dotInNSteps(10000);
            Dot dot1In10001Step = dot1.dotInNSteps(10001);
            Dot dot2In10000Step = dot2.dotInNSteps(10000);
            Dot dot2In10001Step = dot2.dotInNSteps(10001);
            if (Math.abs(dot1In10000Step.getX()-dot2In10000Step.getX()) >= Math.abs(dot1In10001Step.getX()-dot2In10001Step.getX()) ||
                Math.abs(dot1In10000Step.getY()-dot2In10000Step.getY()) >= Math.abs(dot1In10001Step.getY()-dot2In10001Step.getY()) ||
                Math.abs(dot1In10000Step.getZ()-dot2In10000Step.getZ()) >= Math.abs(dot1In10001Step.getZ()-dot2In10001Step.getZ())) {
                for(double ii = 10000; ii <= 20000; ii++) {
                    Dot checkpoint2OfDot1 = dot1.dotInNSteps(ii);
                    for(double jj = 10000; jj <= 20000; jj++) {
                        Dot checkpoint2OfDot2 = dot2.dotInNSteps(jj);
                        if (checkpoint2OfDot1.getX() == checkpoint2OfDot2.getX() &&
                                checkpoint2OfDot1.getY() == checkpoint2OfDot2.getY() &&
                                checkpoint2OfDot1.getZ() == checkpoint2OfDot2.getZ()) {
                            return "Yes, pathways will cross each other in point (x/y/z): " + checkpoint2OfDot1.getX() +
                                    "/" + checkpoint2OfDot1.getY() +
                                    "/" + checkpoint2OfDot1.getZ();
                        }
                    }
                }
            }
        }
        return "No, pathways won't cross each other (99,9%).";
    }


    @Override
    public String toString() {
        return "Dot: x = " + this.getX() + ", y = " + this.getY() + ", z = " + this.getZ();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Dot guest = (Dot) obj;
        return x == guest.x && y == guest.y && z == guest.z && time == guest.time;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + (int)x;
        result = prime*result + (int)y;
        result = prime*result + (int)z;
        result = prime*result + (int)time;
        return result;
    }


}
