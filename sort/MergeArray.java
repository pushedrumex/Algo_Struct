package sort;

import java.util.Scanner;

// 정렬을 마친 배열의 병합
public class MergeArray {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 11, 13};
        int[] b = {1, 2, 3, 4, 9, 16, 21};
        int[] c = new int[13];

        System.out.println("두 배열의 병합");
        merge(a, a.length, b, b.length, c);

        System.out.println("배열a와 배열b를 병합하여 c에 저장");

        System.out.println("< 배열a >");
        for (int n : a) {
            System.out.printf("%d ",n);
        }
        System.out.println();
        System.out.println("< 배열b >");
        for (int n : b) {
            System.out.printf("%d ",n);
        }
        System.out.println();
        System.out.println("< 배열c >");
        for (int n : c) {
            System.out.printf("%d ",n);
        }
    }

    static void merge(int[] a, int na, int[] b, int nb, int[] c) {
        int pa = 0;
        int pb = 0;
        int pc = 0;

        // 작은 값들을 c에 저장
        while (pa < na && pb < nb)
            c[pc++] = a[pa] <= b[pb] ? a[pa++] : b[pb++];

        // a에 남아있는 요소를 복사
        while (pa < na)
            c[pc++] = a[pa++];
        while (pb < nb)
            c[pc++] = b[pb++];
    }
}
