package hashmap;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

//sort a map by value
public class SortMapByValue {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Mango", 6);
        map.put("Orange", 8);
        map.put("Banana", 2);


        System.out.println(map);


        TreeMap<String,Integer> treeMap = new TreeMap<>((key1,key2) -> {
            int compare = map.get(key1).compareTo(map.get(key2));

            if(compare==0){
                return key1.compareTo(key2);
            }
            return compare;
        });

        treeMap.putAll(map);

        System.out.println(treeMap);

        Stack<Character> s = new Stack<>();
    }
}
