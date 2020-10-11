package ru.geekbrains.java_two.lesson_b.home;

import java.util.Scanner;

public class ArrayString {
    private float halfSumEl;
    private String[][] arrayFromString;
    private int countStringArr;
    private int countColumnArr;
    public static int MAX_STRING = 4;
    public static int MAX_COLUMN = 4;

    public float getHalfSumEl() {
        return halfSumEl;
    }

    public int getCountStringArr() {
        return countStringArr;
    }

    public int getCountColumnArr() {
        return countColumnArr;
    }

    public String printArrayString(){
        String strToPrint = new String();
        for (int i = 0; i < this.arrayFromString.length; i++) {
            for (int j = 0; j < this.arrayFromString[i].length; j++) {
            strToPrint += this.arrayFromString[i][j] + ' ';
            }
            strToPrint += '\n';
        }
        return strToPrint;
    }

    private void countString (String str){  //подсчитываем количество "строк"
        int countN = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\n'){
                countN++;
            }
        }
        this.countStringArr = countN+1;
    }

    private void countColumn (int indexI){    //подсчет маскимального количества столбцов по сомой длинной подстроке
        if (this.countColumnArr < this.arrayFromString[indexI].length){
            this.countColumnArr = this.arrayFromString[indexI].length;
        }
    }

    private void strToArrayStr (String str) throws SizeStringArrayException{  //строку в двумерный массив
        countString(str);
        Scanner sc = new Scanner(str);
        String[] tempStr = new String[this.countStringArr];
        for (int i = 0; i < tempStr.length; i++) {
            tempStr[i] = sc.nextLine();

        }

        this.arrayFromString = new  String[tempStr.length][];
        for (int i = 0; i < this.arrayFromString.length; i++) {
            this.arrayFromString[i] = tempStr[i].split(" ");
            countColumn(i);
        }

        if (this.countStringArr > MAX_STRING || this.countColumnArr > MAX_COLUMN){      //условия выкидывания исключения
            throw new SizeStringArrayException("Your array's size ", this);
        }

    }

    private boolean isNumeric(String str)   //проверка, есть ли в строке кроме чисел символы (данную конструкцию подсмотрел на просторах)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private void halfSumArray () throws NotNumberException{            //подсчет полусуммы элементов
        float sum = 0;
        for (int i = 0; i < this.arrayFromString.length; i++) {
            for (int j = 0; j < this.arrayFromString[i].length; j++) {
                if (isNumeric(this.arrayFromString[i][j])){
                    sum += Integer.parseInt(this.arrayFromString[i][j]);
                } else {
                    throw new NotNumberException("Element \'" + this.arrayFromString[i][j] + "\' not Integer Number");
                }
            }
        }
        this.halfSumEl = sum/2;
    }

    public ArrayString(String s){
        strToArrayStr(s);       //преобразуем строку в двумерный стрковый массив
        halfSumArray();         //преобразуем элементы в int И считаем половину суммы элементов массива
    }
}
