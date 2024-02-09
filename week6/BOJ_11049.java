import java.io.*;
import java.util.*;

public class BOJ_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2]; //[0]: 행, [1]: 열
        int[][] dp = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < N -1 ; i++){
            dp[i][i+1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];
        }

        for(int d = 2 ; d < N ; d++){
            for(int i = 0 ; i + d < N ; i++){
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = i ; k < j ; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]));
                }
            }
        }

        System.out.println(dp[0][N-1]);

    }
}
