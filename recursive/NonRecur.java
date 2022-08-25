package recursive;

import stackAndQueue.IntStack;

import java.util.Scanner;

public class NonRecur {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");int n = scan.nextInt();
        IntStack stack = new IntStack(n);

        // stack이 비었고, n이 0 이하라면 종료
        while (true) {

            if (n > 0){
                stack.push(n);
                n -= 1; // recur(n-1)
                continue;
            }

            // n이 0 이하가 되면 출력 시작
            if (!stack.isEmpty()){
                n = stack.pop();
                System.out.println(n);
                n -= 2; // recur(n-2)
                continue;
            }

            break;
        }
    }
}
