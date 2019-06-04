package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用2个队列来实现栈
 */
public class TwoQueueStack {
    static Queue<Integer> data = new LinkedList<>();
    static Queue<Integer> helper = new LinkedList<>();

    public static void push(int num) {
        data.offer(num);
    }

    public static int pop() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Stack is Empty!");
        }
        while (data.size() > 1) {
            helper.offer(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public static int peek() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Stack is Empty!");
        }
        while (data.size() > 1) {
            helper.offer(data.poll());
        }
        int res = data.poll();
        helper.offer(res);
        swap();
        return res;
    }

    public static void swap() {
        Queue<Integer> tmp = data;
        data = helper;
        helper = tmp;
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
