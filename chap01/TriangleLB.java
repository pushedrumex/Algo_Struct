package chap01;

import java.util.Scanner;

// 직각 이등변 삼각형 출력
public class TriangleLB {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("몇 단 삼각형 입니까?");
        int n = scan.nextInt();

        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
