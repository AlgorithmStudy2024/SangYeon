import java.util.*;
import java.io.*;

public class BOJ_17141 {

    static int N, M;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Node> virus =  new ArrayList<>();
    static boolean[][] visited;
    static int[][] copyMap;
    static boolean[] virusCheck;
    static int[] virusArr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        copyMap = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new Node(i, j, 0));
                }
            }
        }

        virusCheck = new boolean[virus.size()];
        virusArr = new int[M];

        dfs(0, 0);

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }


    }
    public static void dfs (int level, int start){
        if(level == M ){
            bfs();
            return;
        }
        for(int i = start ; i < virus.size(); i++){
            if(!virusCheck[i]){
                virusArr[level] = i;
                virusCheck[i] = true;
                dfs(level+1, i+1);
                virusCheck[i] = false;
            }
        }
    }
    public static void copy() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==2) {
                    copyMap[i][j]=0;
                }
                else {
                    copyMap[i][j]= map[i][j];
                }
            }
        }
    }
    public static boolean isPossible() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(copyMap[i][j]==0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void bfs() {
        max = -1;
        copy();
        visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        for(int i = 0 ; i < M ; i++){
            q.add(virus.get(virusArr[i]));
            int x = virus.get(virusArr[i]).x;
            int y = virus.get(virusArr[i]).y;
            copyMap[x][y] = 2;
        }

        while(!q.isEmpty()){
            Node a = q.poll();
            max = Math.max(max, a.time);
            for(int i = 0 ; i < 4 ; i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(!visited[nx][ny] && copyMap[nx][ny] == 0){
                        visited[nx][ny] = true;
                        copyMap[nx][ny] = 2;
                        q.add(new Node(nx, ny, a.time+1));
                    }
                }
            }
        }
        if(isPossible()){
            min = Math.min(min, max);
        }
    }

}
class Node {
    int x, y, time;

    Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}