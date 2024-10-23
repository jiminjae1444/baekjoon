class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int [] answer100 =new int[2];
        int denom3 = denom(denom1,denom2);
        numer1 = denom3/denom1 * numer1;
        numer2 = denom3/denom2 * numer2;
        int numer3 = numer1 + numer2;
        // System.out.println(numer3);
        // System.out.println(denom3);
        int gcd = gcd(numer3,denom3);
        // System.out.println(gcd);
        answer100[0] = numer3/gcd;
        answer100[1] = denom3/gcd;
        return answer100;
    }

    private static int gcd(int numer3, int denom3) {
        if (numer3 % denom3 == 0) {
            return denom3;
        }
        return gcd(denom3, numer3 % denom3);
    }

    private static int denom(int num1,int num2){
        if (num1 >= num2 && num1 % num2 == 0){
            return num1;
        }else if(num2>=num1 && num2 % num1 == 0){
            return num2;
        }else{
            return num1 * num2;
        }
    }
}