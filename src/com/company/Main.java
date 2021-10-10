package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Input: ");
        int numberOf=scanner.nextInt();
        int factor=(int)Math.pow(2,numberOf);

        int[][] binaryInt =new int[factor][numberOf];

        for (int i = 0; i < factor; i++) {
            int tempFactor=i;
            for (int j = numberOf-1; j >= 0; j--) {
                binaryInt[i][j]=tempFactor&1;
                tempFactor>>=1;
            }
        }

        for (int[] bi :binaryInt) {
            System.out.println(Arrays.toString(bi));
        }
        System.out.print("\nOutput: ");
        filterBinaries(binaryInt);
        System.out.println();
    }

    private static void filterBinaries(int[][] binaryArray) {
        int numberOf=binaryArray[0].length;
        for (int[] ints : binaryArray) {
            boolean even = (numberOf % 2) == 0;
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < numberOf; i++) {
                if (even) {
                    if (i < numberOf/2) {
                        sumA += ints[i];
                    } else {
                        sumB += ints[i];
                    }
                }else{
                    if (i < (numberOf-1)/2) {
                        sumA += ints[i];
                    } else if (i > (numberOf-1)/2) {
                        sumB += ints[i];
                    }
                }
            }
            if (sumA == sumB) {
                for (int i = 0; i < numberOf; i++) {
                    System.out.print(ints[i]);
                }
                System.out.print(" ");
            }
        }
    }
}