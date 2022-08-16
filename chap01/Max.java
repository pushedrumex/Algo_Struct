package chap01;

import java.util.ArrayList;
import java.util.Scanner;

// 입력 값 중 가장 큰 수 반환
public class Max{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("세 정수의 최댓값을 구합니다.");

        System.out.print("a : ");
        nums.add(scan.nextInt());
        System.out.print("b : ");
        nums.add(scan.nextInt());
        System.out.print("c : ");
        nums.add(scan.nextInt());
        System.out.print("d : ");
        nums.add(scan.nextInt());

        System.out.printf("최대값은 %d입니다.",maxOf(nums));
        System.out.print(nums);
    }
    static int maxOf(ArrayList<Integer> temp){
        int max = temp.get(0);
        ArrayList<Integer> nums = (ArrayList<Integer>)temp.clone();
        nums.add(9);
        for (int num: nums)
            if (max < num) max = num;
        return max;
    }
}