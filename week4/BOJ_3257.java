import java.io.*;

public class BOJ_3257 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int al = A.length();
        int bl = B.length();
        int cl = C.length();

        int[][] dp = new int[al+1][bl+1];

        // 첫번째 열 초기화
        for(int i = 1 ; i <= al ; i++){
            if(A.charAt(i-1)  == C.charAt(i-1))
                dp[i][0] = 1;
        }

        // 첫번째 행 초기화
        for(int j = 1 ; j <= bl ; j++){
            if(B.charAt(j-1) == C.charAt(j-1)){
                dp[0][j] = 2;
            }
        }

        for(int i = 1 ; i <= al ; i++){
            for(int j = 1 ; j <= bl ; j++){
                if((A.charAt(i-1) == C.charAt(i+j-1)) && dp[i-1][j] != 0)
                    dp[i][j] = 1;
                else if(B.charAt(j-1) == C.charAt(i+j-1) && dp[i][j-1] != 0)
                    dp[i][j] = 2;
            }
        }

        int a = al;
        int b = bl;
        StringBuilder sb = new StringBuilder();
        while(a>0 || b > 0){
            if(dp[a][b] == 1){
                sb.append(1);
                a--;
            }else if(dp[a][b] == 2){
                sb.append(2);
                b--;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
