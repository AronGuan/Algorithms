package pers.aron;

public class BoyerMoore {
	private String pat;
	private int[][] dfa;

	public KMP(String pat){
		this.pat = pat;
		int R = 256;
		int M = pat.length();
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for(int j = 1,X = 0;j < M;j++){
			for (int c = 0;c < R;c++){
				dfa[c][j] = dfa[c][X];
			}
			dfa[pat.charAt(j)][j] = j + 1;
			X = dfa[pat.charAt(j)][X];
		}
	}

	public int search(String txt){
		int N = txt.length();
		int M = pat.length();
		int i,j;
		for (i = 0,j = 0;i < N && j < M;i++){
			j = dfa[txt.charAt(i)][j];
		}
		if(j == M) return i - M;
		else return N;
	}

}
