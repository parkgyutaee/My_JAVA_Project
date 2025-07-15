package com.my.base;

public class TypeTest4 {
    static int select = 2;
    public static void main(String[] args){

        if(select == 1){
            int Loper = 10;
            int Roper = 0;
            int res = Loper / Roper;
            System.out.println(res);
        } else{
            int Loper = 10;
            double Roper = 0.0;
            double res = Loper / Roper;
            System.out.println(res);
        }
    }

}
