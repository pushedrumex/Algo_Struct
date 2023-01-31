package basicDataStructures;

import java.util.Scanner;

// 신체검사 데이터용 클래스 배열에서 평균 키와 시력의 분포를 구함
class PhysicalExamination{

    static final int VMAX = 21; // 상수

    static class PhyscData {
        String name;
        int height;
        double vision;

        // 생성자
        PhyscData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    // 키의 평균값을 구함
    static double aveHeight(PhyscData[] dat){
        double sum = 0;

        for (int i = 0; i < dat.length; i++)
            sum += dat[i].height;

        return sum / dat.length;
    }

    // 시력 분포를 구함
    static void distVision(PhyscData[] dat, int[] vdist){
        for(int i = 0; i < dat.length; i++)
            if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
                vdist[(int)(dat[i].vision * 10)]++;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("박현규", 162, 0.3),
                new PhyscData("함진아", 173, 0.7),
        };

        System.out.println("< 신체검사 리스트 >");
        for (int i=0;i<x.length;i++)
            System.out.printf("%-8s%3d%5.1f\n",x[i].name, x[i].height, x[i].vision);
        System.out.printf("평균 키 : %5.1fcm\n", aveHeight(x));

        int[] vdist = new int[VMAX];
        distVision(x,vdist);

        System.out.println("\n\n< 시력 분포 >");

        for (int i = 0; i < VMAX;i++)
            System.out.printf("%3.1f~ : %2d명\n",i / 10.0,vdist[i]);
    }
}