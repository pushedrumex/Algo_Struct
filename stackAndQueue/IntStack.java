package stackAndQueue;

public class IntStack {
    private int max; // 스택 용량
    private int ptr; // 스택 포인터
    private int[] stk; // 스택 본체

    // 예외클래스 생성
    class EmptyIntStackException extends RuntimeException{
        @Override
        public String getMessage() {
            return "스택이 비어있습니다.";
        }
    }
    class OverflowStackException extends RuntimeException{
        @Override
        public String getMessage() {
            return "스택이 가득 찼습니다.";
        }
    }

    // 생성자
    public IntStack(int capacity){
        ptr = 0;
        max = capacity;
        stk = new int[max];
    }

    // push
    public int push(int x) throws OverflowStackException{
        // 스택이 가득 찼다면 오류 발생
        if (max <= ptr)
            throw new OverflowStackException();
        return stk[ptr++] = x;
    }

    // pop
    public int pop() throws EmptyIntStackException{
        // 스택이 비어있다면 오류 발생
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // peek, 스택의 꼭대기에 있는 데이터를 반환
    public int peek() throws EmptyIntStackException{
        // 스택이 비어있다면 오류 발생
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // indexOf, 특정 데이터가 포함되어 있는지
    public int indexOf(int x){
        for (int i = ptr - 1; i > -1;i--)
            if (stk[i] == x) return i;
        return  -1;
    }

    // clear, 스택에 쌓여 있는 모든 데이터를 삭제
    public void clear(){
        ptr = 0;
    }

    // capacity, 스택의 용량(max)을 반환
    public int capacity(){
        return max;
    }

    // size, 현재 스택에 쌓여 있는 데이터수를 반환
    public int size(){
        return ptr;
    }

    // isEmpty, 스택에 비어있는지 검사
    public boolean isEmpty(){
        return ptr <= 0;
    }

    // isFull, 스택에 가득 찼는지 검사
    public boolean isFull(){
        return ptr >= max;
    }

    // dump, 스택 안의 모든 데이터를 표시
    public void dump() {
        if (ptr <= 0) System.out.println("스택이 비어있습니다.");
        else {
            for (int i=0; i < ptr;i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
