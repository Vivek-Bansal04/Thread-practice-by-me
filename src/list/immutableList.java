package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class immutableList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("as");

        List<String> list2 = List.of("Geek","for","Geeks");
    }
}
