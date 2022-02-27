package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(5);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        System.out.println(arb.peek());
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(6);
        System.out.println(arb.peek());
        arb.enqueue(7);
        System.out.println(arb.fillCount());
    }
}
