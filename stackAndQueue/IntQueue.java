package stackAndQueue;

public class IntQueue {
    private int max; // 큐의 용량
    private int front; // 첫번째 요소 커서
    private int rear; // 마지막 요소 커서
    private int num; // 현재 데이터 수
    private int[] que; // 큐 본체

    // 예외 클래스 생성
    class EmptyIntQueueException extends RuntimeException{
        @Override
        public String getMessage() {
            return "큐가 비어있습니다.";
        }
    }
    class OverflowIntQueueException extends RuntimeException{
        @Override
        public String getMessage() {
            return "큐가 가득 찼습니다.";
        }
    }

    // 생성자
    IntQueue(int capacity){
        max = capacity;
        num = front = rear = 0;
        que = new int[max];
    }

    // enqueue
    int enque(int x) throws OverflowIntQueueException {
        if (num >= max) throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if (rear == max) rear = 0;
        return x;
    }

    // dequeue
    int deque() throws EmptyIntQueueException{
        if (num <= 0) throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if (front == max) front = 0;
        return x;
    }

    // peek
    int peek() throws EmptyIntQueueException{
        if (num <= 0) throw new EmptyIntQueueException();
        return que[front];
    }

    // indexOf
    int indexOf(int x){
        for (int i=0;i < num;i++) {
            i = (i + front) % max;
            if (que[i] == x) return i;
        }
        return -1;
    }

    // clear
    void clear(){
        num = front = rear = 0;
    }

    // capacity
    int capacity(){
        return max;
    }

    // size
    int size(){
        return num;
    }

    // isEmpty
    boolean isEmpty(){
        return num <= 0;
    }

    // isFull
    boolean isFull(){
        return num >= max;
    }

    // dump
    void dump(){
        if (num <= 0) System.out.println("큐가 비어있습니다.");
        else{
            for (int i=0;i < num;i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }
}
