import java.io.*;
import java.util.*;

public class BOJ_2644 {
    static int N;
    static boolean[][] family;
    static boolean[] visited;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        family = new boolean[N+1][N+1];
        visited = new boolean[N+1];


        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            family[x][y] = family[y][x] = true;

        }
        dfs(a, 0, b);

        System.out.println(result);
    }

    public static void dfs(int p, int d, int end){
        visited[p] = true;
        if(p == end){
            result = d;
            return;
        }

        for(int i = 1 ; i <= N ; i++){
            if(family[p][i] && !visited[i])
                dfs(i, d+1, end);
        }
    }
}
