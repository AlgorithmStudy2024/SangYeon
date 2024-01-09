import java.util.*;
import java.io.*;

public class BOJ_16173 {
    static boolean flag = false;
    static int N;
    static int[][] map;
    static boolean[][] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if(flag){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }

    }
    public static void dfs(int x, int y){
        if(map[x][y] == -1){
            flag = true;
            return;
        }
        if(!flag && !check[x][y]){
            check[x][y] = true;
            if(x+map[x][y] < N){
                dfs(x+map[x][y], y);
            }
            if(y+map[x][y] < N){
                dfs(x, y+map[x][y]);
            }
            check[x][y] = false;
        }
    }
}
