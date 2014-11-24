import java.io.Serializable;

public class MyString extends Object implements Serializable, Comparable<String>, CharSequence {

    private int length;
    private char[] elements;
//    private Object[] elements;

    public MyString(){
        this.length = 0;
    }

    private void setElements(){

    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int i) {
        if(i >= length){
            throw new ArrayIndexOutOfBoundsException("No element at this index.");
        }
        return elements[i];
    }

    @Override
    public CharSequence subSequence(int i, int i2) {
        return null;
    }

    @Override
    public int compareTo(String s) {
        return 0;
    }

    private double percentFull(){
        return length / elements.length;
    }

    @Override
    public String toString(){
        StringBuilder toString = new StringBuilder();
        for(int i = 0; i < length; i++){
            toString.append(elements[i]);
        }
        return toString.toString();
    }
}
