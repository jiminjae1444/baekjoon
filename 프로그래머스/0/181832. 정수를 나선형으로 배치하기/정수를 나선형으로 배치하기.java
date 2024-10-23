class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int x=0,y=-1;
        int sign=1;
        int num=1;
        while (true) 
        {
			for (int i = 0; i < n; i++) {
				y+=sign;					
				answer[x][y]=num++;			
			}
			n--;
			if(n<0) {
				break;	
			}
			for (int i = 0; i < n; i++) {
					x+=sign;					
					answer[x][y] = num++;
			}
			sign*=-1;
		} 
        return answer;
    }
}