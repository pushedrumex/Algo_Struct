package stackAndQueue;

import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args){
        IntQueue que = new IntQueue(64);
        Scanner scan = new Scanner(System.in);
        int choice;
        while(true){
            System.out.printf("\n현재 데이터 수 : %d/%d\n",que.size(),que.capacity());
            System.out.println("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료 : ");
            choice = scan.nextInt();

            if (choice == 0) break;

            switch (choice){
                case 1:
                    System.out.print("데이터 : ");
                    int data = scan.nextInt();
                    try{
                        que.enque(data);
                    } catch (IntQueue.OverflowIntQueueException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        System.out.printf("디큐한 데이터는 %d입니다.\n", que.deque());
                    } catch (IntQueue.EmptyIntQueueException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        System.out.printf("피크한 데이터는 %d입니다.\n",que.peek());
                    } catch (IntQueue.EmptyIntQueueException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    que.dump();
                    break;
            }
        }
    }
}
