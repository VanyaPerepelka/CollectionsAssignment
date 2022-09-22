package collections.test;

import collections.entities.ImplementedArrayList;
import org.junit.jupiter.api.*;

import java.util.ArrayList;


class ImplementedListTest implements ConsoleColors{

    ImplementedArrayList<Integer> list;

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

    @BeforeEach
    void setUp() {
        list = new ImplementedArrayList<>();
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
            list.add(i);
        }
        assertEquals("[0, 1, 2, 3, 4]", list.toString());
        assertEquals(5, list.size());
    }

    @Test
    void addWithBiggerIndexAndCheckLength(){ //without outing of actual capacity
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        list.add(5, 4);
        assertEquals(5, list.size());
        assertEquals("null", list.get(3));
        System.out.println(list);
    }

    @Test
    void addWithBiggerIndex(){
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println(list + "set up\n");

        list.add(20, 19);
        assertEquals(20, list.size());
        assertEquals(20, list.get(19));
        System.out.println(list);
    }

    @Test
    void get() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(99, list.get(list.size() - 1));
    }

    @Test()
    void getOutOfBoundsTest(){
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(101));
    }
    @Test
    void set() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.set(99, 0);
        list.set(0, list.size() - 1);
        assertEquals(0, list.get(list.size() - 1));
        assertEquals(99, list.get(0));
    }

    @Test
    void contains() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertTrue(list.contains(99));
        assertFalse(list.contains(-159));
    }

    @Test
    void indexOf() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(-1, list.indexOf(900));
        assertEquals(list.size() - 1, list.indexOf(list.size() - 1));
    }

    @Test
    void remove() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.remove(0);
        assertFalse(list.contains(0));
        assertTrue(list.contains(1));
        assertTrue(list.size() == 99);
    }


    @Test
    void clear() {
        for (int i = 0; i < 100; i++) {
            list.add(2);
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
            list.add(i);
            arrayList.add(String.valueOf(i));
        }
        assertEquals(arrayList.toString(), list.toString());
    }
}