package org.example.pattern;

import java.util.Scanner;

public class SimpleDiamondShape {

    public static void drawDiamond(int side) {
        for (int i = 0; i <= side; i++) {
            for (int j = side - i; j >= 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }


        for (int i = 0; i < side - 1; i++) {
            for (int j = 0; j <= i + 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < side - (i + 1); k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter side length: ");

        int side = scanner.nextInt();

        drawDiamond(side);
    }
}
