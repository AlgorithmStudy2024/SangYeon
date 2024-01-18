import java.util.*;
import java.io.*;

public class BOJ_5639 {
    static int[] arr = new int[10001];  // 입력의 최대 개수가 10000개
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        
        String input;
        while ((input = br.readLine()) != null && input.length() > 0){
            arr[idx++] = Integer.parseInt(input);
        }
        postOrder(0, idx - 1);

    }

    public static void postOrder(int curr, int end){
        if(curr > end)
            return;

        int mid = curr + 1;
        while(mid <= end && arr[mid] < arr[curr])
            mid++;

        postOrder(curr + 1, mid - 1);   //왼쪽 서브 트리 탐색
        postOrder(mid, end);        // 오른쪽 서브 트리 탐색
        System.out.println(arr[curr]);  // 현재 노드 출력
    }
}
