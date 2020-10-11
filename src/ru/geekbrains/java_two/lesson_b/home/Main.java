package ru.geekbrains.java_two.lesson_b.home;

import java.util.Scanner;

public class Main {

    private static String[][] strToArrayStr (String str){
        int countN = 0;
        for (int i = 0; i < str.length(); i++) {   //подсчитываем количество "строк"
            if (str.charAt(i) == '\n'){
                countN++;
            }
        }
        Scanner sc = new Scanner(str);
        String[] tempStr = new String[countN + 1];
        for (int i = 0; i < tempStr.length; i++) {
            tempStr[i] = sc.nextLine();
        }
        String[][] arrString = new String[tempStr.length][];
        for (int i = 0; i < arrString.length; i++) {
            arrString[i] = tempStr[i].split(" ");
        }
        return arrString;
    }
    private static float halfSumArray (String[][] arrayStr){
        float sum = 0;
        for (int i = 0; i < arrayStr.length; i++) {
            for (int j = 0; j < arrayStr[i].length; j++) {
                sum += Integer.parseInt(arrayStr[i][j]);
            }
        }
        return sum/2;
    }

    public static void main(String[] args){
        String userString = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] arrayString = strToArrayStr(userString);

//        for (int i = 0; i < arrayString.length; i++) {
//            for (int j = 0; j < arrayString[i].length; j++) {
//                System.out.print(arrayString[i][j] + ' ');
//            }
//            System.out.println();
//        }

        System.out.println(halfSumArray(arrayString));


    }
}
