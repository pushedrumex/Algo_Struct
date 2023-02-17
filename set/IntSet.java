package set;

public class IntSet {
    private int max; // 집합의 최대 개수
    private int num; // 집합의 요소 개수
    private int[] set; // 집합 본체

    // 생성자
    public IntSet(int capacity) {
        num = 0;
        max = capacity;
        set = new int[max];
    }

    // 집합의 최대 개수
    public int capacity() {
        return max;
    }

    // 집합의 요소 개수
    public int size() {
        return num;
    }

    // 집합에서 n 검색
    public int indexOf(int n) {
        for (int i = 0; i < num; i++) {
            if (set[i] == n) {
                return i; // 검색 성공
            }
        }
        return -1; // 검색 실패
    }

    // 집합에 n이 있는지 없는지 확인
    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    // 집합에 n을 추가
    public boolean add(int n) {
        if (num >= max || contains(n) == true) {
            return false;
        } else {
            set[num++] = n; // 가장 마지막 자리에 추가
            return true;
        }
    }

    // 집합에서 n을 삭제
    public boolean remove(int n) {
        int idx = indexOf(n);

        if (num <= 0 || idx == -1) {
            return false;
        }
        set[idx] = set[--num]; // 마지막 요소를 삭제한 곳으로 옮김
        return true;
    }

    // 집합 s에 복사
    public void copyTo(IntSet s) {
        int n = s.max < num ? s.max : num; // 복사할 요소 개수
        for (int i = 0; i < n; i++) {
            s.set[i] = set[i];
        }
        s.num = n;
    }

    // 집합 s를 복사
    public void copyFrom(IntSet s) {
        int n = max < s.num ? max : s.num; // 복사할 요소 개수
        for (int i = 0; i < n; i++) {
            set[i] = s.set[i];
        }
        num = n;
    }

    // 집합 s와 같은지 확인
    public boolean equalTo(IntSet s) {
        if (num != s.num) {
            return false;
        }
        for (int i = 0; i < num; i++) {
            int j = 0;
            for (; j < s.num; j++) {
                if (set[i] == s.set[j]) { // 존재
                    break;
                }
            }
            if (j == s.num) { // 존재하지 않음
                return false;
            }
        }
        return true;
    }

    // 집합 s1과 s2의 합집합을 복사
    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for (int i = 0; i < s2.num; i++) {
            add(s2.set[i]);
        }
    }

    // 문자열로 표현
    public String toString() {
        StringBuffer temp = new StringBuffer("{");
        for (int i = 0; i < num; i++) {
            temp.append(set[i] + " ");
        }
        temp.append("}");
        return temp.toString();
    }
}
