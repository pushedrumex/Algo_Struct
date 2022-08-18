package basicDataStructures;

import java.util.Arrays;

// 1000이하의 소수를 열거
public class PrimeNumber {
    public static void main(String[] args) {
        boolean[] isPrime = new boolean[1000+1];
        int root = (int)Math.sqrt(1000);
        int count = 0;

        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i=2;i<root+1;i++)
            if (isPrime[i]) {
                for (int j = i * 2; j < 1000 + 1; j += i){
                    isPrime[j] = false;
                    count++;
                }
            }
        for (int i=2;i<1001;i++)
            if (isPrime[i]) System.out.println(i);
        System.out.println("연산 횟수 : " + count);
    }
}