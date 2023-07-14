package OOP_Lesson_4;

import OOP_Lesson_4.MyLinkedList.GBLinkedList;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        GBLinkedList<Integer> numbers = new GBLinkedList<>();
        numbers.addFirst(125);
        numbers.addFirst(826);
        numbers.addFirst(395);
        numbers.addFirst(15);
        numbers.addFirst(860);
        numbers.addLast(1236);
        numbers.addLast(18);
        numbers.addLast(13);

        System.out.println(numbers.size());
        System.out.println(numbers.getElementByIndex(0));
        System.out.println(numbers.getElementByIndex(7));
        System.out.println("+++++++++++++++++++++++++");

        for (Integer i : numbers) {
            System.out.println(i);
        }
        System.out.println("+++++++++++++++++++++++++");

        Iterator it = numbers.descendigIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
