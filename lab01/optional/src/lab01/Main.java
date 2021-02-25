package lab01;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	    if(args.length > 0) {
            int n = Integer.parseInt(args[0]);
            System.out.println(n);

            int[][] graphMatrix = new int[n][n];
            for(int i = 0; i < n; i++) { // Construct the matrix
                for(int j = 0; j < i; j++) {
                    graphMatrix[i][j] = graphMatrix[j][i] = (int)(Math.random() * 2);
                }
            }

            for(int i = 0; i < n; i++) { // Show the matrix
                for(int j = 0; j < n; j++) {
                    System.out.print(graphMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            int[] visited = new int[n];
            for(int i = 0; i < n; i++) visited[i] = 0;

            DFS(0, visited, n, graphMatrix); // Perform DFS

            int connected = 1; // Check if the graph is connected
            for(int i = 0; i < n; i++) {
                if(visited[i] == 0) {
                    System.out.println(i);
                    connected = 0;
                }
            }
            if(connected == 0) { // If it's not connected, show components
                for(int i = 0; i < n; i++) if(visited[i] == 0) {
                    System.out.println();
                    DFS(i, visited, n, graphMatrix);
                }
            } else {
                System.out.println("Connected !");
                BFS(0, n, graphMatrix);
            }
            System.out.println();

        } else {
            System.out.println("You must give an argument !");
        }
    }

    static void DFS(int start, int[] visited, int n, int[][] graphMatrix) {
        visited[start] = 1;
        System.out.print(start + " ");

        for(int i = 0; i < n; i++ ) {
            if(graphMatrix[start][i] == 1 && visited[i] == 0) {
                DFS(i, visited, n, graphMatrix);
            }
        }
    }

    static void BFS(int start, int n, int[][] graphMatrix) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0) {
            start = queue.poll();
            System.out.print(start + " -> ");

            for(int i = 0; i < n; i++) {
                if(graphMatrix[start][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }
    }

}
