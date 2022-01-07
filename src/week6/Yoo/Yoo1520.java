package week6.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//38620KB 316ms
public class Yoo1520 {

    static private int m, n;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m+1][n+1];
        dp = new int[m+1][n+1];

        for(int i = 1; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j]= -1;
            }
        }

        System.out.println(dfs(1,1));

    }

    private static int dfs(int x, int y) {

        if( x== m && y == n){ // 도착지
            return 1;
        }

        if(dp[x][y] != -1){ // 방문
            return dp[x][y];
        }else{
            dp[x][y] = 0;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx < 1 || ny < 1 || nx > m || ny > n){
                    continue;
                }
                if(map[x][y] > map[nx][ny]){
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];
    }
}
