package com.company.VariantB.Dot;

import javax.swing.*;

public class TaskDot {

    public static void main(String[] args) {

        Dot dot1 = new Dot(2, 3, 4, -1, -2,-1);
        Dot dot2 = new Dot(2, 5, 3, 2, 4, 1);

        Dot dot3 = new Dot(0,0,0, 1,1,1);
        Dot dot4 = new Dot(5,5,5, 1,1,1);


        System.out.println("Speed of dot1: " + dot1.whatSpeed(5));
        System.out.println("Speed of dot2: " + dot2.whatSpeed( 5));

        System.out.println("Speed of dot3: " + dot3.whatSpeed( 10));
        System.out.println("Speed of dot4: " + dot4.whatSpeed( 10));

        System.out.println(Dot.willPathwaysCrossEachOther(dot1, dot2));
        System.out.println(Dot.willPathwaysCrossEachOther(dot3, dot4));

        System.out.println(Dot.willPathwaysCrossEachOther(dot1, dot3));
        System.out.println(Dot.willPathwaysCrossEachOther(dot2, dot4));


    }

}
