import java.io.*;
import java.util.*;

public class BOJ_17144 {

    static class Dust{
        int x;
        int y;
        int w;

        Dust(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    static int R, C, T, result;
    static int[][] map;
    static Queue<Dust> dusts;
    static int[] cleaner = new int[2];

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        dusts = new LinkedList<>();

        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == -1){    // 공기청정기 찾기
                    if(cleaner[0] == 0){
                        cleaner[0] = i;
                    }else {
                        cleaner[1] = i;
                    }
                }
            }
        }

        for(int tc = 0 ; tc < T ; tc++){
            findDusts();
            spread();   // 먼지 확산

            wind(cleaner[0], cleaner[1]);
        }


        // 남은 먼지 카운팅
        dustCounting();



        System.out.println(result);
        br.close();
    }

    public static void spread(){
        while(!dusts.isEmpty()){
            Dust curr = dusts.poll();
            int x = curr.x;
            int y = curr.y;
            int w = curr.w;


            int amount = w / 5;
            int cnt = 0;

            if( w < 5)
                continue;

            for(int dir = 0; dir < 4 ; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1)
                    continue;

                map[nx][ny] += amount;
                cnt++;
            }

            map[x][y] -= amount * cnt;
        }
    }

    public static void wind(int top, int down){
        // 반시계방향
        for(int i = top - 1 ; i > 0 ; i--)  // 아래로 당기기
            map[i][0] = map[i-1][0];
        for(int i = 0 ; i < C-1 ; i++ ) // 왼쪽로 당기기
            map[0][i] = map[0][i+1];
        for(int i = 0 ; i < top ; i++)  // 오른쪽으로 당기기
            map[i][C-1] = map[i+1][C-1];
        for(int i = C - 1 ; i > 0 ; i--)    //위로 당기기
            map[top][i] = map[top][i-1];
        map[top][1] = 0;

        // 시계방향
        for(int i = down + 1 ; i < R - 1 ; i++) // 아래로 당기기
            map[i][0] = map[i+1][0];
        for(int i = 0 ; i < C-1 ; i++)  // 위로 당기기
            map[R-1][i] = map[R-1][i+1];
        for(int i = R-1 ; i > down ; i--)   // 왼쪽으로 당기기
            map[i][C-1] = map[i-1][C-1];
        for(int i = C-1; i > 0 ; i--)   // 아래로 당기기
            map[down][i] = map[down][i-1];
        map[down][1] = 0;


    }

    public static void findDusts(){
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(map[i][j] > 0){
                    dusts.add(new Dust(i,j, map[i][j]));
                }
            }
        }
    }

    public static void dustCounting(){
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(map[i][j] == -1)
                    continue;
                result += map[i][j];
            }
        }

    }




}
