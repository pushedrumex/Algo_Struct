package stackAndQueue;

public class IntAryQueue {
    private int max; // 큐 용량
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
    IntAryQueue(int capacity){
        max = capacity;
        num = 0;
        que = new int[max];
    }

    // enqueue
    int enque(int x) throws OverflowIntQueueException {
        if (num >= max) throw new OverflowIntQueueException();
        que[num++] = x;
        return x;
    }

    // dequeue
    int deque() throws EmptyIntQueueException {
        if (num <= 0) throw new EmptyIntQueueException();
        int x = que[0];
        num--;
        for (int i=0;i<num;i++)
            que[i] = que[i+1];
        return x;
    }

    // peek
    int peek() throws EmptyIntQueueException {
        if (num <= 0) throw new EmptyIntQueueException();
        return que[0];
    }

    // indexOf
    int indexOf(int x){
        for (int i=0;i < num;i++)
            if (que[i] == x) return i;
        return -1;
    }

    // clear
    void clear(){
        num = 0;
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
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }
}
