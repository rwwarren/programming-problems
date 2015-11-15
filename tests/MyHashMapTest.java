import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyHashMapTest {

    @Test
    public void testEmpty() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
        assertThat(myHashMap.size(), equalTo(0));
        assertThat(myHashMap.isEmpty(), equalTo(true));
    }

    @Test
    public void testMyHashMap() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
        String key = "test";
        int value = 1;
        myHashMap.put(key, value);

        Integer result = myHashMap.get(key);
        assertThat(result, equalTo(value));
        assertThat(myHashMap.size(), equalTo(1));
        assertThat(myHashMap.isEmpty(), equalTo(false));
    }

    @Test
    public void testMyHashMapPutSame() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
        String key = "test";
        int value = 1;
        myHashMap.put(key, 2);
        myHashMap.put(key, 3);
        myHashMap.put(key, value);

        assertThat(myHashMap.size(), equalTo(1));
        assertThat(myHashMap.isEmpty(), equalTo(false));
        Integer result = myHashMap.get(key);
        assertThat(result, equalTo(value));
    }

    @Test
    public void testMyHashMapDoubleSize() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>(1);
        String key = "test";
        int value = 1;
        myHashMap.put(key, value);
        myHashMap.put("asdfff", 2);
        myHashMap.put("qwer", 3);
        myHashMap.put("fgh", 4);
        myHashMap.put("asuyrtdf", 5);
        myHashMap.put("vbnm", 6);
        myHashMap.put("iuty", 7);
        myHashMap.put("cfty", 8);
        myHashMap.put("1234rt", 9);
        myHashMap.put("asdf", 10);
        myHashMap.put("asdf", 11);

        assertThat(myHashMap.isEmpty(), equalTo(false));
        Integer result = myHashMap.get(key);
        assertThat(myHashMap.size(), equalTo(10));
        assertThat(result, equalTo(value));
    }

    @Test
    public void testMyHashMapReplaceValue() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
        String key = "test";
        int value = 1;
        int newValue = 2;
        myHashMap.put(key, value);
        myHashMap.put(key, newValue);

        Integer result = myHashMap.get(key);
        assertThat(result, equalTo(newValue));
        assertThat(myHashMap.size(), equalTo(1));
        assertThat(myHashMap.isEmpty(), equalTo(false));
    }

    @Test
    public void testRemove() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
        String key = "test";
        int value = 1;
        myHashMap.put(key, value);
        myHashMap.remove(key);

        Integer result = myHashMap.get(key);
        assertThat(result, equalTo(null));
        assertThat(myHashMap.size(), equalTo(0));
        assertThat(myHashMap.isEmpty(), equalTo(true));
    }

    @Test
    public void testMyHashMapDoubleSizeManyRemove() {
        {
            MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
            String key = "test";
            int value = 1;
            myHashMap.put(key, value);
            String secondInARow = "asdfff";
            String twoInARow = "cfty";
            myHashMap.put(secondInARow, 2);
            myHashMap.put("qwer", 3);
            myHashMap.put("fgh", 4);
            myHashMap.put("asuyrtdf", 5);
            myHashMap.put("vbnm", 6);
            myHashMap.put("iuty", 7);
            myHashMap.put(twoInARow, 8);
            myHashMap.put("1234rt", 9);
            myHashMap.put("asdf", 10);
            myHashMap.put("asdf", 11);

            assertThat(myHashMap.isEmpty(), equalTo(false));
            Integer result = myHashMap.get(key);
            assertThat(myHashMap.size(), equalTo(10));
            assertThat(result, equalTo(value));
            myHashMap.remove(secondInARow);
            Integer removedFirst = myHashMap.get(secondInARow);
            assertThat(removedFirst, equalTo(null));
            myHashMap.remove(twoInARow);
            Integer secondRemoved = myHashMap.get(twoInARow);
            assertThat(secondRemoved, equalTo(null));
            assertThat(myHashMap.size(), equalTo(8));
        }
        {
            MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
            String key = "test";
            int value = 1;
            myHashMap.put(key, value);
            String secondInARow = "asdfff";
            String twoInARow = "cfty";
            myHashMap.put(secondInARow, 2);
            myHashMap.put("qwer", 3);
            myHashMap.put("fgh", 4);
            myHashMap.put("asuyrtdf", 5);
            myHashMap.put("vbnm", 6);
            myHashMap.put("iuty", 7);
            myHashMap.put(twoInARow, 8);
            myHashMap.put("1234rt", 9);
            myHashMap.put("asdf", 10);
            myHashMap.put("asdf", 11);

            assertThat(myHashMap.isEmpty(), equalTo(false));
            Integer result = myHashMap.get(key);
            assertThat(myHashMap.size(), equalTo(10));
            assertThat(result, equalTo(value));
            myHashMap.remove(twoInARow);
            Integer removedFirst = myHashMap.get(twoInARow);
            assertThat(removedFirst, equalTo(null));
            myHashMap.remove(secondInARow);
            Integer removedSecond = myHashMap.get(secondInARow);
            assertThat(removedSecond, equalTo(null));
            assertThat(myHashMap.size(), equalTo(8));
        }
    }

    @Test
    public void testClear(){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
        String key = "test";
        String key2 = "test2";
        int value = 1;
        int newValue = 2;
        myHashMap.put(key, value);
        myHashMap.put(key2, newValue);
        myHashMap.clear();
        assertThat(myHashMap.isEmpty(), equalTo(true));
        assertThat(myHashMap.size(), equalTo(0));
    }



}