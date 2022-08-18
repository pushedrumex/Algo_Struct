package basicAlgorithm;

import java.util.Scanner;

// 입력한 정수가 음수인지 양수인지 0인지 판단
public class JudgeSign {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : "); int n = scan.nextInt();
        String result = "양수";
        if (n == 0) result = "0";
        else if (n < 0) result = "음수";

        System.out.println("이 수는 " + result + "입니다.");
    }
}
