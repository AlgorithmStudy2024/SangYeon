import java.io.*;
import java.util.*;

public class BOJ_2533 {
    static int N;
    static boolean[] visited;
    static List<Integer>[] tree;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static public void dfs(int num){
        visited[num] = true;
        dp[num][0] = 0; //해당 num이 얼리어답터가 아닌 경우
        dp[num][1] = 1; //해당 num이 얼리어답터인 경우

        for(int child : tree[num]) {
            if(!visited[child]){
                dfs(child);
                dp[num][0] += dp[child][1];
                dp[num][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
