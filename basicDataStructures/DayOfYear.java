package basicDataStructures;

import java.util.Scanner;

// 그 해 경과일수
public class DayOfYear {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        System.out.println("그 해 경과일수를 구합니다.");
        System.out.print("년 : "); int year = scan.nextInt();
        System.out.print("월 : "); int month = scan.nextInt();
        System.out.print("일 : "); int day = scan.nextInt();

        int flag = isLeap(year);

        int result = (month > 2) ? day + flag : day;
        for (int i=0;i<month;i++) result += days[i];

        System.out.println("그 해 " + result + "일째 입니다.");
    }
    static int isLeap(int year){
        if (year%400 == 0 || year%4 == 0 && year%100 != 0) return 1; // 윤년
        return 0; // 평년
    }
}
