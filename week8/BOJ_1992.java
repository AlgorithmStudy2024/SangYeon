import java.io.*;

public class BOJ_1992 {

    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();

            for(int j = 0 ; j < N ; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        QuadTree(0, 0, N);

        System.out.println(sb.toString());


    }

    public static void QuadTree(int x, int y, int size){
        if(isPossible(x,y,size)){
            sb.append(map[x][y]);
            return;
        }

        int newSize = size/2;
        sb.append('(');

        QuadTree(x, y, newSize);    // 좌상
        QuadTree(x, y+newSize, newSize);    // 우상
        QuadTree(x+newSize, y, newSize);    // 좌하
        QuadTree(x+newSize, y+newSize, newSize);    // 우하

        sb.append(')');
    }

    public static boolean isPossible(int x, int y, int size){
        int curr = map[x][y];

        for(int i = x ; i < x+size ; i++){
            for(int j = y ; j < y+size ; j++){
                if(curr != map[i][j])
                    return false;
            }
        }

        return true;
    }
}
