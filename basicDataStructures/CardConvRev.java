package basicDataStructures;

import java.util.Scanner;

// 입력받은 10진수를 2~36진수로 변환
public class CardConvRev {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("10진수를 기수변환합니다.");
        int n;
        int baseNum;
        int repeat;
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                n = scan.nextInt();
            } while (n < 0);
            do {
                System.out.print("어떤 진수로 변환할까요?(2~36) ");
                baseNum = scan.nextInt();
            } while (!(baseNum >= 2 && baseNum <= 36));

            System.out.printf("%d진수로는 %s입니다.\n", baseNum, conv(n, baseNum));
            System.out.print("한번 더 할까요?(예 : 1 / 아니오 : 0) "); repeat = scan.nextInt();
        }while (repeat == 1);
    }
    static String conv(int n, int baseNum){
        String result = "";
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (n > 0){
            result += base.charAt(n%baseNum);
            n /= baseNum;
        }

        // 문자열 역순으로 뒤집기
        StringBuffer sb = new StringBuffer(result);
        result = sb.reverse().toString();

        return result;
    }
}
