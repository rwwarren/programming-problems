import java.io.Serializable;

public class MyString extends Object implements Serializable, Comparable<String>, CharSequence {
    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i2) {
        return null;
    }

    @Override
    public int compareTo(String s) {
        return 0;
    }
}
