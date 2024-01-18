import java.util.*;
import java.io.*;

public class BOJ_18428 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Node> student = new ArrayList<>();
    static int N;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'S'){
                    student.add(new Node(i, j));
                }
            }
        }
        dfs(0);

        System.out.println("NO");

    }

    static void dfs(int obstacle){
        if(obstacle == 3){
            bfs();
            return;
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 'X'){
                    map[i][j] = 'O';
                    dfs(obstacle + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        char[][] copyMap = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            System.arraycopy(map[i], 0, copyMap[i], 0, N);
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(copyMap[i][j] == 'T'){
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            Node curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for(int dir = 0 ; dir < 4 ; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                while (0 <= nx && nx < N && 0 <= ny && ny < N){
                    if(copyMap[nx][ny] != 'O'){
                        visited[nx][ny] = true;
                        nx += dx[dir];
                        ny += dy[dir];
                    }else {
                        break;
                    }
                }
            }
        }
        if(checkingStudent(visited)){
            System.out.println("YES");
            System.exit(0);
        }
    }

    public static boolean checkingStudent(boolean[][] visited){
        for(Node node : student){
            if(visited[node.x][node.y]){
                return false;
            }
        }
        return true;
    }
}
