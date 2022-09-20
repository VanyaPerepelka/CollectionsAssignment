package collections.test;

import collections.entities.ImplementedLinkedList;
import org.junit.jupiter.api.*;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedImplementedListTest implements ConsoleColors{

    ImplementedLinkedList<Integer> list;
/*

    void assertEquals(Object expected, Object actual){
        String comparing = "expected [" + expected + "]; actual [" + actual + "]\n";
        if (expected.equals(actual)){
            System.out.println( ANSI_GREEN + "    pass: " + comparing + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "!  FAILED: " + comparing + ANSI_RESET);
        }
    }

    void assertTrue(boolean actual){
        String comparing = "expected [" + true + "]; actual [" + actual + "]\n";
        if (actual){
            System.out.println( ANSI_GREEN + "    pass: " + comparing + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "!  FAILED: " + comparing + ANSI_RESET);
        }
    }

    void assertFalse(boolean actual){
        String comparing = "expected [" + false + "]; actual [" + actual + "]\n";
        if (!actual){
            System.out.println( ANSI_GREEN + "    pass: " + comparing + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "!  FAILED: " + comparing + ANSI_RESET);
        }
    }
*/

    @BeforeEach
    void setUp() {
        list = new ImplementedLinkedList<>();
        assertTrue(list.isEmpty());

    }

    @AfterEach
    void tearDown() {
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void simpleAddingTest() {
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }
        assertEquals("[0, 1, 2, 3, 4]", list.toString());
        assertEquals(5, list.size());
    }

    @Test
    public void addFirstTest(){
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        assertEquals("[4, 3, 2, 1, 0]", list.toString());
        assertEquals(5, list.size());
    }

    @Test
    void pasteAtIndex(){
        for (int i = 0; i < 4; i++) {
            list.addLast(i);
        }
        System.out.println(list + " before inserting \n");
        list.add(100, 2);
        assertEquals("[0, 1, 100, 2, 3]", list.toString());
        assertEquals(list.get(2), 100);
        System.out.println(list + " after inserting \n");
    }

    @Test
    void get() {
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        assertEquals(99, list.get(list.size() - 1));
    }

    @Test()
    void getOutOfBoundsTest(){
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        assertEquals(100, list.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(101));
    }
    @Test
    void toDel(){
        Queue<Integer> q = new LinkedList<>();
    }
    @Test
    void set() {
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        list.set(99, 0);
        list.set(0, list.size() - 1);
        assertEquals(0, list.get(list.size() - 1));
        assertEquals(99, list.get(0));
    }

    @Test
    void contains() {
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        assertTrue(list.contains(99));
        assertFalse(list.contains(-159));
    }

    @Test
    void indexOf() {
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        assertEquals(-1, list.indexOf(900));
        assertEquals(list.size() - 1, list.indexOf(list.size() - 1));
    }

    @Test
    void remove() throws UnexpectedException {
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        list.delete(59);
        assertFalse(list.contains(59));
        assertTrue(list.contains(1));
    }

    @Test
    public void removeFirst(){
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.deleteFirst();
        assertFalse(list.contains(0));
        assertEquals(1, (int) list.getFirst());
        assertEquals(9, list.size());
    }

    @Test
    public void removeLast(){
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        list.deleteLast();
        assertFalse(list.contains(99));
        assertEquals(98, (int) list.getLast());
        assertEquals(98, (int) list.getLast());
    }

    @Test
    void clear() {
        for (int i = 0; i < 100; i++) {
            list.addLast(2);
        }
        list.clear();
        assertEquals(-1, list.indexOf(2));
        assertTrue(list.isEmpty());
        assertFalse(list.contains(2));
    }

    @Test
    void testToString() {
        ArrayList<String> arrayList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
            arrayList.add(String.valueOf(i));
        }
        assertEquals(arrayList.toString(), list.toString());
    }

    @Test
    void addByIndex(){
        for (int i = 0; i < 3; i++) {
            list.addLast(i); //0,1,2
        }
        list.addLast(4);
        list.add(3, 3);

        assertEquals("[0, 1, 2, 3, 4]", list.toString());
    }

    @Override
    public String toString() {
        return "ImplementedListTest{" +
                "list=" + list +
                '}';
    }
}
