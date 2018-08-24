package com.company.VariantB.Drob;

public class Drob {

    private int m; //числитель
    private int n; //знаменатель

    Drob(int m, int n){
        setM(m);
        setN(n);
    }

    private void setM(int m){
        this.m = m;
    }
    private void setN(int n){
        this.n = n;
    }

    private int getM(){
        return m;
    }
    private int getN(){
        return n;
    }

    @Override
    public String toString() {
        return "дробь " + getM() + "/" + getN();
    }

    public static void printArray(Drob[] drobs){
        System.out.println("Список дробей:");
        for (Drob drob: drobs) {
            System.out.println(drob.toString());
        }
        System.out.println(" ");
    }

    private static int[] sokrashchenieDrobi(int newM, int newN){
        if(newM > newN) {
            for (int i = 2; i <= newM/2; i++){
                if(newM%i == 0 && newN%i == 0){
                    newM = newM/i; newN = newN/i;
                }
            }
        } else {
            for (int i = 2; i <= newN/2; i++){
                if(newM%i == 0 && newN%i == 0){
                    newM = newM/i; newN = newN/i;
                }
            }
        }
        return new int[] {newM, newN};
    }

    public static void slogenie(Drob drob1, Drob drob2){
        int newM;
        int newN;
        if (drob1.getN() == drob2.getN()){
            newM = drob1.getM()+drob2.getM();
            newN = drob1.getN();
        } else{
            newN = drob1.getN()*drob2.getN();
            newM = (drob1.getM()*drob2.getN())+(drob2.getM()*drob1.getN());
        }
        int[] newMandN= Drob.sokrashchenieDrobi(newM, newN);
        newM = newMandN[0];
        newN = newMandN[1];
        System.out.println("Результат сложения: " +  drob1 + " + " + drob2 + " = " + newM + "/" + newN + "\n");
    }

    public static void vychitanie(Drob drob1, Drob drob2){
        int newM;
        int newN;
        if (drob1.getN() == drob2.getN()){
            newM = drob1.getM()-drob2.getM();
            newN = drob1.getN();
        } else{
            newN = drob1.getN()*drob2.getN();
            newM = (drob1.getM()*drob2.getN())-(drob2.getM()*drob1.getN());
        }
        int[] newMandN= Drob.sokrashchenieDrobi(newM, newN);
        newM = newMandN[0];
        newN = newMandN[1];
        System.out.println("Результат вычитания: " +  drob1 + " - " + drob2 + " = " + newM + "/" + newN + "\n");
    }

    public static void umnogenie(Drob drob1, Drob drob2){
        int newM = drob1.getM()*drob2.getM();
        int newN = drob1.getN()*drob2.getN();
        int[] newMandN = Drob.sokrashchenieDrobi(newM, newN);
        newM = newMandN[0];
        newN = newMandN[1];
        System.out.println("Результат умножения: " +  drob1 + " * " + drob2 + " = " + newM + "/" + newN + "\n");
    }

    public static void delenie(Drob drob1, Drob drob2){
        int newM = drob1.getM()*drob2.getN();
        int newN = drob1.getN()*drob2.getM();
        int[] newMandN= Drob.sokrashchenieDrobi(newM, newN);
        newM = newMandN[0];
        newN = newMandN[1];
        System.out.println("Результат деления: " +  drob1 + " / " + drob2 + " = " + newM + "/" + newN + "\n");
    }

    public static void changeEvenElement(Drob[] drobs){
        for (int i = 0; i < drobs.length-1; i++) {
            if(i%2 == 0){
                if (drobs[i].getN() == drobs[i+1].getN()){
                    drobs[i].m = drobs[i].getM()+drobs[i+1].getM();
                } else{
                    int newN = drobs[i].getN()*drobs[i+1].getN();
                    int newM = (drobs[i].getM()*drobs[i+1].getN())+(drobs[i+1].getM()*drobs[i].getN());
                    drobs[i].n = newN;
                    drobs[i].m = newM;
                }
                int[] newMandN= Drob.sokrashchenieDrobi(drobs[i].n, drobs[i].m);
                drobs[i].n = newMandN[0];
                drobs[i].m = newMandN[1];
            }
        }
    }
}
