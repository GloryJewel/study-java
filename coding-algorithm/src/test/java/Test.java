import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    @org.junit.jupiter.api.Test
    void queue(){

        Queue<String> queue = new LinkedList<String>();
        queue.offer("손영주");
        queue.offer("케이");
        if(!queue.isEmpty())
            assertEquals(queue.poll(), "손영주");
    }

    @org.junit.jupiter.api.Test
    void stack(){

        Stack<String> stack = new Stack<>();
        stack.push("손영주");
        stack.push("케이");

        if(!stack.empty())
            assertEquals(stack.pop(), "케이");
    }

    @org.junit.jupiter.api.Test
    void arrayToListObject(){

        Integer[] objectInts = {1,2,3};

        //asList에서 나오는 타입은 add를 하지 못한다 고정 사이즈 해서 arrayList로 만들어줘야한다.
        List<Integer> integerList = new ArrayList<>(Arrays.asList(objectInts));
        integerList.add(1);

        assertEquals(Arrays.toString(new Integer[] {1,2,3,1}) ,Arrays.toString(integerList.toArray()));

        //primitive 타입을 객체 타입으로 변환 시켜줘야한다.
        int[] primitiveInts = {1,2,3};
        List<Integer> integerList2 = Arrays.stream(primitiveInts).boxed().collect(Collectors.toList());

        assertEquals(Arrays.toString(primitiveInts) ,Arrays.toString(integerList2.toArray()));
    }

    @org.junit.jupiter.api.Test
    void viewArray(){

        int[] primitiveInts = {1,2,3};

        assertEquals("[1, 2, 3]", Arrays.toString(primitiveInts));
    }

    @org.junit.jupiter.api.Test
    void stringToChat(){

        String strName="손영주";

        char[] character = strName.toCharArray();

        assertEquals("[손, 영, 주]", Arrays.toString(character));

        char ch = strName.charAt(0);

        assertEquals('손', ch);
    }

    @org.junit.jupiter.api.Test
    void toStream(){

        int[] primitiveInts = {1,2,3};

        assertEquals(Arrays.stream(primitiveInts).count(), 3);
        assertEquals(Stream.of(1,2,3).count(), 3);
    }
}
