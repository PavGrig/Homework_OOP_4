package OOP_Lesson_4.Interface;

public interface GBLinkedLists<T> {
    void addLast(T t);
    void addFirst(T t);
    int size();

    T getElementByIndex(int index);

}
