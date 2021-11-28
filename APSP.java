import java.util.*;
public class APSP {
    int V = Graphs.unique_vertices.size();
    final static int INF = 0;
    void floydWarshall(Edges Adjmatrix[][])
    {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++){
            for (j = 0; j < V; j++){
                //int s = Graphs.unique_vertices.get(i);
                //int e = Graphs.unique_vertices.get(j);
                dist[i][j] = Adjmatrix[i][j].weight;
            }
        }
        for (k = 0; k < V; k++)
        {
            for (i = 0; i < V; i++)
            {
                for (j = 0; j < V; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist);
    }
    void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else{
                    System.out.print(dist[i][j]+"   ");
                }
            }
            System.out.println();
        }
    }
}
