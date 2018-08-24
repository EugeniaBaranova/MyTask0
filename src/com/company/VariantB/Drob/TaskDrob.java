package com.company.VariantB.Drob;

public class TaskDrob {

    public static void main(String[] args) {
        // m - числитель, n - знаменатель
        Drob[] drobs = new Drob[7];
        drobs[0] = new Drob(4,9);
        drobs[1] = new Drob(2,9);
        drobs[2] = new Drob(5,9);
        drobs[3] = new Drob(5,11);
        drobs[4] = new Drob(2,9);
        drobs[5] = new Drob(3,8);
        drobs[6] = new Drob(5,6);

        Drob.printArray(drobs);

        Drob.slogenie(drobs[1], drobs[4]);
        Drob.vychitanie(drobs[1], drobs[0]);
        Drob.umnogenie(drobs[4], drobs[5]);
        Drob.delenie(drobs[3], drobs[6]);

        Drob.changeEvenElement(drobs);
        Drob.printArray(drobs);

    }

}
