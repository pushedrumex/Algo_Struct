package stringSearch;

public class BFmatch {
    static int bfMatch(String txt, String pat) {
        int pt = 0; // txt커서
        int pp = 0; // pat커서

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length()) { // 검색 성공
            return pt - pp;
        }
        return -1; // 검색 실패
    }

}

