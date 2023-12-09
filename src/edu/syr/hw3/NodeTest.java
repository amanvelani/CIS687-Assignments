package edu.syr.hw3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NodeTest {

    // Use this method to access Node.value which is a private field
    public static <T> T getValue(Node<T> node) {
        Field f;
        try {
            f = Node.class.getDeclaredField("value");
            f.setAccessible(true);
            T value = (T) f.get(node);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class Foo {
        @Override
        public String toString() {
            return "Foo";
        }
    }

    @Test
    public void testConstructor() {
        Node<Double> a = new Node<Double>(3.1415926);
        assertEquals(3.1415926, getValue(a));
        assertNull(a.next);

        Node<String> b = new Node<String>("123");
        assertEquals("123", getValue(b));
        assertNull(b.next);

        Foo foo = new Foo();
        Node<Foo> c = new Node<NodeTest.Foo>(foo);
        assertEquals(foo, getValue(c));
        assertNull(c.next);

        Node<Float> d = new Node<Float>(3.1415926f);
        assertEquals(3.1415926f, getValue(d));
        assertNull(d.next);

        List<String> list = new ArrayList<>();
        Node<List<String>> node = new Node<List<String>>(list);
        assertEquals(list, getValue(node));
        assertNull(node.next);

        Book book = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.PAPERBACK);
        Node<Book> node1 = new Node<Book>(book);
        assertEquals(book, getValue(node1));
        assertNull(node1.next);

        Node<Integer> node3 = new Node<Integer>(10);
        Node<Node<Integer>> node4 = new Node<Node<Integer>>(node3);
        assertEquals(node3, getValue(node4));
        assertNull(node4.next);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("123", 123);
        Node<HashMap<String, Integer>> node5 = new Node<>(map);
        assertEquals(123, getValue(node5).get("123"));
        assertNull(node5.next);
    }

    @Test
    public void testBuild() {
        int p = 0;
        Integer[] ints = new Integer[10];
        for (int i = 0; i < 10; ++i) {ints[i] = i+1;}
        Node<Integer> head1 = Node.build(ints);
        while (head1 != null) {
            assertEquals(getValue(head1), ints[p++]);
            head1 = head1.next;
        }

        p = 0;
        String[] strs = new String[]{"a1", "b2", "c3"};
        Node<String> head2 = Node.build(strs);
        while (head2 != null) {
            assertEquals(getValue(head2), strs[p++]);
            head2 = head2.next;
        }

        p = 0;
        Character[] chars = new Character[]{'C', 'S', 'E', '6', '8', '7'};
        Node<Character> head3 = Node.build(chars);
        while (head3 != null) {
            assertEquals(getValue(head3), chars[p++]);
            head3 = head3.next;
        }
    }
}