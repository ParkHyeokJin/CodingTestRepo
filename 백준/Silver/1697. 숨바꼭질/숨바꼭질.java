import java.util.*;
import java.io.*;

public class Main {
    private static int maxNum = 100_000;
    private static int N, K;
    private static boolean[] visited = new boolean[maxNum+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        if(N == K) {
            System.out.println(0);   
        }else{
            System.out.println(solution(N, K));
        }
    }
    private static int solution(int N, int K) {
        int answer = 0;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(N, 0));
        while (!queue.isEmpty()) {
            Position position = queue.remove();
            visited[position.n] = true;
            if(position.n == K) {
                answer = position.sec;
                break;
            }

            if(check(position.n + 1)){
                queue.add(new Position(position.n + 1, position.sec + 1));
                visited[position.n + 1] = true;
            }
            if(check(position.n - 1)){
                queue.add(new Position(position.n - 1, position.sec + 1));
                visited[position.n - 1] = true;
            }
            if(check(position.n * 2)){
                queue.add(new Position(position.n * 2, position.sec + 1));
                visited[position.n * 2] = true;
            }
        }
        return answer;
    }

    private static boolean check(int n){
        return n >= 0 && n <= 100000 && !visited[n];
    }

    private static class Position{
        int n;
        int sec;

        public Position(int n, int sec) {
            this.n = n;
            this.sec = sec;
        }
    }
}