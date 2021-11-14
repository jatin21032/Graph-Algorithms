import java.io.*;
import java.util.*;
public class Graphs {
    static ArrayList<int[]> raw_graph = new ArrayList<int[]>();
    static Set<Integer> unique_vertices = new HashSet<Integer> (); 
     public static  void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\HP\\Dropbox\\PC\\Documents\\IIITD\\FIRST_SEM\\OOPD\\Project\\data\\facebook_combined.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        
        
        while ((str = br.readLine()) != null){
            int[]  row = new int[2];
            row[0] = Integer.parseInt(str.split(" ")[0]);
            row[1] = Integer.parseInt(str.split(" ")[1]);
            raw_graph.add(row);
            unique_vertices.add(row[0]);
            unique_vertices.add(row[1]);
        }
        Graphs gr = new Graphs();
        gr.matrixGraph();
    }

    public int[][] matrixGraph(){
      int noOfVertices = unique_vertices.size();
      System.out.println("no of vertices : "+ noOfVertices);
      System.out.println("no of edges : "+ raw_graph.size());
      int[][] graph = new int[noOfVertices][noOfVertices];
      int k=0;
      while(k<raw_graph.size()){
          int[] r = raw_graph.get(k);
          //System.out.println("adding at row "+r[0]+"and column "+r[1]);
          graph[r[0]][r[1]] = 1;
          k++;
      }
    for(int i=0;i<noOfVertices;i++){
        for(int j=0;j<noOfVertices;j++){
          System.out.print(graph[i][j]+" ");
        }
          System.out.print("\n");
    }
      return graph;
    }
}
