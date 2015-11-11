import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyHashMapTest {

    @Test
    public void testEmpty(){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
        assertThat(myHashMap.size(), equalTo(0));
        assertThat(myHashMap.isEmpty(), equalTo(true));
    }

    @Test
    public void testMyHashMap(){
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
    public void testMyHashMapReplaceValue(){
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


}