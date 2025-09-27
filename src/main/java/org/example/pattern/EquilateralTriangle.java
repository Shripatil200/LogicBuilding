package org.example.pattern;

import java.util.Scanner;

public class EquilateralTriangle {

    public static void drawTriangle(int side){

        for (int i = 1 ; i <= side ; i++){
            for (int j = side - i; j >= 0; j--){
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter side length: ");
        int side = sc.nextInt();

        drawTriangle(side);
    }
}
