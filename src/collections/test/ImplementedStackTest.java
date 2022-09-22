package collections.test;

import collections.entities.ImplementedStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementedStackTest {

    public ImplementedStack<Integer> stack;

    @BeforeEach
    void setUp(){
        stack = new ImplementedStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @AfterEach
    void tearDown(){
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void simplePush(){
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        assertEquals("[0, 1, 2, 3, 4, 5]", stack.toString());
    }

    @Test
    void simplePop(){
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        Object top = stack.pop();

        assertEquals(5, top);
        assertEquals("[0, 1, 2, 3, 4]", stack.toString());
        assertEquals(5, stack.size());
    }

    @Test
    void simplePeek(){
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        Object top = stack.peek();
        assertEquals(5, top);
        assertEquals(top, stack.peek());
        assertEquals(6, stack.size());
    }

    @Test
    void exceptionHandling(){
        assertThrows(IllegalStateException.class, () -> stack.pop());
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            stack.pop();
        }
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    void growingInnerArrayWithCustomCapacity(){
        stack = new ImplementedStack<>(1);
        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }
    }

    @Test
    void sizeTest(){
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertEquals(10, stack.size());
        assertEquals(9, stack.pop());
    }

    @Test
    void orderTest(){
        Object[] tester = new Object[]{6, 5, 4, 3, 2, 1, 0};
        for (int i = 0; i < tester.length; i++) {
            stack.push(i);
        }
        for (Object o : tester) {
            assertEquals(o, stack.pop());
        }
    }

}

