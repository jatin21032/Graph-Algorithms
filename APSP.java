import java.util.*;
import java.io.*;
public class APSP {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int V = Graphs.unique_vertices.size();
    final static int INF = 999999;
    int[][] floydWarshall(Edges Adjmatrix[][])
    {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++){
            for (j = 0; j < V; j++){
                //int s = Graphs.unique_vertices.get(i);
                //int e = Graphs.unique_vertices.get(j);
                if(Adjmatrix[i][j]!=null){
                    dist[i][j] = Adjmatrix[i][j].weight;
                    //System.out.print(dist[i][j]);
                }
                else    
                    dist[i][j] = INF;    
            }
        }
        for(int a=0;a<V;a++)
            dist[a][a]=0;

        /*for (int a=0;a<V;a++){
            for(int b=0;b<V;b++){
                if(dist[a][b]!=INF)
                    System.out.print(dist[a][b]);
            }

        }*/    
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
        //  for (int a=0;a<V;a++){
        //     for(int b=0;b<V;b++)
        //         System.out.println(dist[a][b]);
        
        return (dist);
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
                    //System.out.print("i"+i+"and"+"j"+j);
                }
            }
            System.out.println();
        }
    }
    void print_dist(int dist[][])throws IOException{
        int t=1;
        while(t==1){
            System.out.println();
            int v1,v2;
            System.out.println("Enter vertex 1");
            v1 = Integer.parseInt(br.readLine());
            System.out.println("Enter vertex 2");
            v2 = Integer.parseInt(br.readLine());
            System.out.println("Distances between "+v1+" and "+v2+" : "+dist[v1][v2]);
            System.out.println("Enter 1 to continue or 0 to exit");
            t = Integer.parseInt(br.readLine());
        }
    }
}
