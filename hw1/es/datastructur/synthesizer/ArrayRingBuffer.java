package es.datastructur.synthesizer;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T>  implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;
    private int size;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        size = capacity;
        first = 0;
        last = 0;
        fillCount = 0;
        rb = (T[])new Object[size]; // 创建泛型数组

        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     * @param x
     */
    @Override
    public void enqueue(T x) {
        if (isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount += 1;
        last = (last + 1)%size;

        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        return;
    }
    // return size of the buffer
    @Override
    public int capacity() {
        return size;
    }
    // return number of items currently in the buffer
    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        fillCount = fillCount - 1;
        int f = first;
        first = (first + 1)%size;
        return rb[f];
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        if (isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
        // TODO: Return the first item. None of your instance variables should
        //       change. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
    // TODO: Remove all comments that say TODO when you're done.
