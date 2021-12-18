
public class Stack<Item extends Object> {
    Item[] stack;
    int position;

    // Constructor
    public Stack() {
        stack = (Item[])new Object[2];
        position = 0;
    }

    // Pushes an item onto the stack
    public void push(Item item) {
        if(stack.length == position) {
            resize(stack);
        } else if(stack.length/4 == position) {
            shrink(stack);
        }

        stack[position++] = item;
    }

    // Pops an item from the stack
    public void pop() throws Exception {
        if(position == 0) {
            throw new Exception("Stack is empty");
        }
        stack[--position] = null;
    }

    // Returns the value on the top of the stack
    public Item peek() {
        return stack[position-1];
    }

    // Returns number of items on the stack
    public int size() {
        return position;
    }

    public boolean isEmpty() {
        return position == 0;
    }

    // Resizes the stack if it's full
    public void resize(Item[] inputArray) {
        Item[] doubleArray = (Item[])new Object[inputArray.length*2];

        for(int i = 0; i < inputArray.length; i++) {
            doubleArray[i] = inputArray[i];
        }

        stack = doubleArray;
    }

    // Shrinks the stack if it is only a quarter full
    public void shrink(Item[] inputArray) {
        Item[] halfArray = (Item[])new Object[inputArray.length/2];

        for(int i = 0; i < halfArray.length; i++) {
            halfArray[i] = inputArray[i];
        }

        stack = halfArray;
    }
    
}
