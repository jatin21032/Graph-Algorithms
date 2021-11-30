import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Graphs {
    static ArrayList<int[]> raw_graph = new ArrayList<int[]>();
    static HashMap<Integer,Integer> unique_vertices = new HashMap<Integer,Integer>(); 
    static int startVertex;
     public static  void main(String[] args) throws Exception {
      DBConnection db = new DBConnection();
      String filepaths= db.connectDB();
      
        File file = new File(filepaths.split("  ")[1]);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        
        
        int r=0;
        try{
        while ((str = br.readLine()) != null){
            int[]  row = new int[2];
            row[0] = Integer.parseInt(str.split(" ")[0]);
            row[1] = Integer.parseInt(str.split(" ")[1]);
            raw_graph.add(row);
            if(!unique_vertices.containsValue(row[0])){
              unique_vertices.put(r,row[0]);
              r++;
            }
            if(!unique_vertices.containsValue(row[1])){
              unique_vertices.put(r,row[1]);
              r++;
            }
           
           
        }
      }catch(Exception e){
        System.out.println("There is something wrong with file format!!"+e);
      }
        
        
        BufferedWriter writer=null;
        try{
          ArrayList<Integer> bfsOutput = new ArrayList<Integer>();
          ArrayList<Integer> outputdfs = new ArrayList<Integer>();
        Graphs gr = new Graphs();
        Traversal trv = new BFSTraversal();
        Traversal trvs = new DFSTraversal();
        bfsOutput = trv.GraphTraversal(gr.matrixGraph());
        

        outputdfs = trvs.GraphTraversal(gr.matrixGraph());
        //System.out.println("DFS Traveral of Graph "+outputdfs);

        APSP apsp = new APSP();
        int dist[][] = apsp.floydWarshall(gr.matrixGraph());
        //apsp.printSolution(dist);
        br.close();

        String fileName = filepaths.split("  ")[2];
         writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(bfsOutput.toString());
        }catch(Exception e){
          System.out.println("Error while writing file!!"+e);
        }finally{
          //writer.close();
        }
        

        
    }

    public Edges[][] matrixGraph(){
      int noOfVertices = unique_vertices.size();
      System.out.println("no of vertices : "+ noOfVertices);
      System.out.println("no of edges : "+ raw_graph.size());
      Edges[][] graph = new Edges[noOfVertices][noOfVertices];
      int k=0;
      try{
      while(k<raw_graph.size()){
          int[] r = raw_graph.get(k);
         
          Vertices v1 = new Vertices();
          Vertices v2 = new Vertices();
          v1.setNodeID(r[0]);
          v2.setNodeID(r[1]);
          Edges e = new Edges(v1,v2);
          
          e.createEdge();
          if(k==0){
            startVertex = 0;
          }
          int x=0,y=0;
         
          for(Entry<Integer, Integer> entry: unique_vertices.entrySet()) {
           if(entry.getValue() == r[0]) {
              x= entry.getKey();
              break;
            }
          }
          for(Entry<Integer, Integer> entry: unique_vertices.entrySet()) {
            if(entry.getValue() == r[1]) {
               y = entry.getKey();
               break;
             }
           }
          
          graph[x][y] = e;
          k++;
      }
    }catch(Exception e){
      System.out.println("Error while constructing graph"+e);
    }
      return graph;
    }
}
