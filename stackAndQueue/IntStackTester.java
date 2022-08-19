package stackAndQueue;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args){
        IntStack stack = new IntStack(64);
        Scanner scan = new Scanner(System.in);

        int choice;

        while (true){
            System.out.printf("\n현재 데이터 수 : %d/%d\n", stack.size(), stack.capacity());
            System.out.printf("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 : ");
            choice = scan.nextInt();

            if (choice == 0) break;
            switch (choice){
                case 1:
                    System.out.print("데이터 : ");
                    int data = scan.nextInt();
                    try {
                        stack.push(data);
                    } catch(IntStack.OverflowStackException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.printf("팝한 데이터는 %d입니다.\n",stack.pop());
                    } catch(IntStack.EmptyIntStackException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.printf("피크한 데이터는 %d입니다.\n",stack.peek());
                    } catch(IntStack.EmptyIntStackException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    stack.dump();
                    break;
            }
        }
    }
}
