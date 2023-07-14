package OOP_Lesson_4.MyLinkedList;

import OOP_Lesson_4.Interface.DescendingIterator;
import OOP_Lesson_4.Interface.GBLinkedLists;

import java.util.Iterator;

public class GBLinkedList<T> implements GBLinkedLists<T>, Iterable<T>, DescendingIterator<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public GBLinkedList(){
        lastNode = new Node<>(null, firstNode, null);
        firstNode = new Node<>(null,null, lastNode);
    }

    @Override
    public void addLast(T t) {
        Node<T> prev = lastNode;
        prev.setCurElement(t);
        lastNode = new Node<>(null, prev, null);
        prev.setNextElement(lastNode);
        size++;

    }
    @Override
    public void addFirst(T t) {
        Node<T> next = firstNode;
        next.setCurElement(t);
        firstNode = new Node<>(null, null, next);
        next.setPrevElement(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElementByIndex(int index) {
        Node<T> result = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            result = getNextElement(result);
        }
        return result.getCurElement();
    }
    private Node<T> getNextElement(Node<T> cur){
        return cur.getNextElement();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                return getElementByIndex(count++);
            }
        };
    }

    @Override
    public Iterator<T> descendigIterator() {
        return new Iterator<T>() {
            int count = size - 1;
            @Override
            public boolean hasNext() {
                return count >= 0;
            }

            @Override
            public T next() {
                return getElementByIndex(count--);
            }
        };
    }

    private class Node<T> {
        private T curElement;
        private Node<T> nextElement;
        private Node<T> prevElement;

        private Node(T curElement, Node<T> prevElement, Node<T> nextElement) {
            this.curElement = curElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public T getCurElement() {
            return curElement;
        }

        public void setCurElement(T curElement) {
            this.curElement = curElement;
        }
        public Node<T> getNextElement(){
            return nextElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<T> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<T> prevElement) {
            this.prevElement = prevElement;
        }
    }
}
