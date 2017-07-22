package Modul3;

import java.util.HashMap;
import java.util.Scanner;


public class Modul3 {
    public  static  void main (String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Input array of int in line separated by space:");
        String line = in.nextLine();
        String[] arrStr = line.split(" ");

        int[] arrInt = new int [arrStr.length];

        for (int i=0; i<arrStr.length; i++) {
            arrInt[i] = Integer.parseInt(arrStr[i]);
        }

//min and max of array:
        int max = arrInt[0];
        int min = arrInt[0];
        for (int ind=1; ind<arrInt.length; ind++) {
            if (min > arrInt[ind]) {
                min = arrInt[ind];
            }
            if (max < arrInt[ind]) {
                max = arrInt[ind];
            }
        }
        System.out.printf("Min Element = %d\n", min);
        System.out.printf("Max Element = %d\n", max);

//repetition of 5 in array:
        int count = 0;
        for (int i:arrInt){
            if (i==5) {count++;}
        }
        System.out.printf("5 repeated %d times in a given array.\n", count);

//sorted array:
        for(int i=0; i<arrInt.length; i++) {
            for(int j=1; j<arrInt.length-i; j++){
                if (arrInt[j-1]>arrInt[j]) {
                    int temp = arrInt[j-1];
                    arrInt[j-1] = arrInt[j];
                    arrInt[j] = temp;
                }
            }
        }
        System.out.println("Sorted array:");
        for (int i: arrInt) {
            System.out.printf("%d, ", i);
        }

//Task #2 (Additional):

        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i:arrInt) {
            if (hmap.containsKey(i)) {
                hmap.put(i, hmap.get(i) + 1);
            } else {
                hmap.put(i, 1);
            }
        }
        //System.out.println();
        //System.out.println(hmap);
        //System.out.println(hmap.size());
        max = 1;
        min = arrInt.length;
        for (int value : hmap.values()) {
            if (value>max) {max=value;}
            if (value<min) {min=value;}
        }
        System.out.println("\n");
        System.out.printf("Highest repetition: %d\n", max);
        System.out.printf("Lowest repetition: %d\n", min);
//----------------------------------------------------------


    }
}
