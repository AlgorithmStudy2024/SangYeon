import java.util.*;
import java.io.*;

public class BOJ_8972 {
    static class location {
        int x, y;
        location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int R, C;
    static char[][] map;

    static Queue<location> jq = new LinkedList<>();
    static Queue<location> mad = new LinkedList<>();
    static int[] dx = {0,1,1,1,0,0,0,-1,-1,-1};
    static int[] dy = {0,-1,0,1,-1,0,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i = 0 ; i < R ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < C ; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'I')
                    jq.add(new location(i,j));
                if(map[i][j] == 'R')
                    mad.add(new location(i,j));
            }
        }

        int count = 1;

        boolean flag = true;
        String action = br.readLine();
        for(int i = 0 ; i < action.length() ; i++){
            if(!jongsuMove(action.charAt(i)-48)){
                flag = false;
                break;
            }
            if(!madMove()){
                flag = false;
                break;
            }
            map();
            count++;
        }

        if(!flag){
            System.out.println("kraj "+count);
        }else{
            for(int i = 0 ; i < R ; i++){
                for(int j = 0 ; j < C ; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }




    }

    public static boolean jongsuMove(int dir){
        location curr = jq.poll();
        int nx = curr.x + dx[dir];
        int ny = curr.y + dy[dir];

        if(map[nx][ny] == 'R')
            return false;
        else{
            jq.add(new location(nx,ny));
            if(dir != 5){
                map[curr.x][curr.y] = '.';
                map[nx][ny] = 'I';
            }
            return true;
        }
    }
    public static boolean madMove(){
        location jongsu = jq.peek();
        int jx = jongsu.x;
        int jy = jongsu.y;

        int[][] cnt = new int[R][C];

        while(!mad.isEmpty()){
            location curr = mad.poll();
            int distance = Integer.MAX_VALUE;
            int dir = 0;

            for(int i = 1 ; i < 10 ; i++){
                if(i==5) continue;
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                int gap = Math.abs(jx-nx) + Math.abs(jy-ny);
                if(gap < distance){
                    distance = gap;
                    dir = i;
                }
            }
            int nextX = curr.x + dx[dir];
            int nextY = curr.y + dy[dir];

            if(map[nextX][nextY] == 'I')
                return false;
            cnt[nextX][nextY] += 1;
        }

        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(cnt[i][j] == 1){
                    mad.add(new location(i,j));
                }
            }
        }
        return true;
    }
    public static void map(){
        for(int i = 0 ; i < R ; i++)
            Arrays.fill(map[i], '.');

        location jongsu = jq.peek();
        map[jongsu.x][jongsu.y] = 'I';

        for(int i = 0 ; i < mad.size() ; i++){
            location crazy = mad.poll();
            map[crazy.x][crazy.y] = 'R';
            mad.add(new location(crazy.x, crazy.y));
        }


    }
}
