package ru.geekbrains.java_two.lesson_b.home;

public class Main {

    public static void main(String[] args){
        String userString = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            ArrayString arr = new ArrayString(userString);
            System.out.println("Our array: \n" + arr.printArrayString());
            System.out.println("HalfSum of Int Elements of Array = " + arr.getHalfSumEl());
        } catch (SizeStringArrayException e) {
            System.out.print("EXCEPTION: ");
            System.out.print(e.getMessage() + e.getCountString() + "x" + e.getCountColumn() + ", ");
            System.out.println("Need " + ArrayString.MAX_STRING + "x" + ArrayString.MAX_COLUMN);
        } catch (NotNumberException e2){
            System.out.print("EXCEPTION: ");
            System.out.println(e2.getMessage());
        }


    }
}
