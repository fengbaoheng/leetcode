package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1670.设计前中后队列
 */
public class Problem1670 {

    private static class FrontMiddleBackQueue {
        private final Deque<Integer> frontQ = new ArrayDeque<>();
        private final Deque<Integer> backQ = new ArrayDeque<>();

        public FrontMiddleBackQueue() {

        }

        public void pushFront(int val) {
            frontQ.addFirst(val);
            modify();
        }

        public void pushMiddle(int val) {
            frontQ.addLast(val);
            modify();
        }

        public void pushBack(int val) {
            backQ.addLast(val);
            modify();
        }

        public int popFront() {
            if (size() == 0) {
                return -1;
            }

            int result = frontQ.size() > 0 ? frontQ.removeFirst() : backQ.removeFirst();
            modify();
            return result;
        }

        public int popMiddle() {
            if (size() == 0) {
                return -1;
            }
            int result = frontQ.size() < backQ.size() ? backQ.removeFirst() : frontQ.removeLast();
            modify();
            return result;
        }

        public int popBack() {
            if (size() == 0) {
                return -1;
            }

            int result = backQ.size() > 0 ? backQ.removeLast() : frontQ.removeLast();
            modify();
            return result;
        }

        private int size() {
            return frontQ.size() + backQ.size();
        }

        private void modify() {
            if (frontQ.size() < backQ.size() - 1) {
                frontQ.addLast(backQ.removeFirst());
            } else if (frontQ.size() > backQ.size()) {
                backQ.addFirst(frontQ.removeLast());
            }
        }
    }


}