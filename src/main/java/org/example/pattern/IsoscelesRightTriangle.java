package org.example.pattern;

import java.util.Scanner;

public class IsoscelesRightTriangle {

    public static void drawTriangle(int side){
        for (int i = 0; i < side; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side length:");
        int side = sc.nextInt();
        drawTriangle(side);
    }

}
