package ru.geekbrains.java_two.lesson_b.home;

public class SizeStringArrayException extends ArrayIndexOutOfBoundsException{
    private int countString;
    private int countColumn;

    public int getCountColumn() {
        return countColumn;
    }

    public int getCountString() {
        return countString;
    }

    public SizeStringArrayException(String message, ArrayString arrStr){
        super(message);
        this.countColumn = arrStr.getCountColumnArr();
        this.countString = arrStr.getCountStringArr();
    }

}
