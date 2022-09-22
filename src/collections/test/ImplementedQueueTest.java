package collections.test;

import collections.entities.ImplementedQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementedQueueTest {
    ImplementedQueue<Integer> queue = new ImplementedQueue<>();

    @BeforeEach
    void setUp(){
        assertTrue(queue.isEmpty());
    }

    @AfterEach
    void tearDown(){
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    void innerStructureTest(){
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        Object[] expected = new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(Arrays.toString(expected), queue.toString());
    }

    @Test
    void pollTest(){
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        assertEquals(0, queue.poll());
        assertEquals(1, queue.poll());
    }

    @Test
    void peekTest(){
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        assertEquals(0, queue.peek());
        assertEquals(0, queue.poll());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.poll());
        assertEquals(3, queue.size());
    }

    @Test
    void exceptionTest(){
        queue = new ImplementedQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        assertThrows(IllegalArgumentException.class, () -> queue.add(0));
    }

    @Test
    void offerTest() {
        queue = new ImplementedQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        assertFalse(queue.offer(0));
        queue.poll();
        assertTrue(queue.offer(0));
        assertEquals(10, queue.size());
    }





}
