/**This file is performing All Pairs Shortest Paths for the graph based on FloydWarshal Algorithm.
 * Assumptions:: for the pair of Vertices which do not have path are represented by number 999999.
 * It return the 2-D matrix where each pair corrsponds to the sum of the shortest paths weights.
 */
package oopd;

import java.io.*;
public class APSP {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int V = Graphs.unique_vertices.size();
    final static int INF = 999999;
    int[][] floydWarshall(Edges Adjmatrix[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                if (Adjmatrix[i][j] != null) {
                    dist[i][j] = Adjmatrix[i][j].weight; //copy edge weights to distance array which is 2D
                    } else
                    dist[i][j] = INF;
            }
        }
        for (int a = 0; a < V; a++)
            dist[a][a] = 0;

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) //for every vertex we are trying to include it in our shortest path
                        dist[i][j] = dist[i][k] + dist[k][j]; //the shortest path costs are stored in the distance array.
                }
            } //d[i][j] contains shortest path cost between nodes i and j
        }
        return (dist);
    }
}