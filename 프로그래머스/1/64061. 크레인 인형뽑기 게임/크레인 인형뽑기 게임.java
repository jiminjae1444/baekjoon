class Solution {
    public int solution(int[][] board, int[] moves) {
		int [] dolls= new int[moves.length];
		int count=0;
        int answer=0;
//		show(board);
		for (int i = 0; i <moves.length; i++) { //moves에 담긴 순서대로 board에 접근
            int slot = moves[i]-1;  // 무브는 1이지만 배열에서 0인덱스여야함 즉 -1씩 작아야함
            for (int j = 0; j < board.length; j++) { 	//slot은 칸수 줄수는 board.length 줄 칸 순서대로 접근
            	int value = board[j][slot];
            	if (board[j][slot] !=0) {   			  //0이 아닌곳을 찾으면
                    board[j][slot] =0;  // 값을 넣었기때문에 0으로 바꿔줌
                    for (int k = 0; k < dolls.length; k++) {
						if(dolls[k]==0) {
							dolls[k]= value;
							if(k!=0 && dolls[k]==dolls[k-1]) {
								dolls[k]=0;
								dolls[k-1]=0;
								count+=2;
							}
							break;
						}
					}
                    break;				//중단
                }
            }
        }
        answer = count;
        return answer;
	}
}