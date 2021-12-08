/**This file is the main file of our project. This file helps in constructing the graph in the form of adjacency matrix. 
 * Also this file taken input from file and write into the file at the specified location.
 * This file features the concept of RUN-TIME POLYMORPHISM by calling child's methods on parent object.
 */
package oopd;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Graphs {
    //static data members which updates globally for all objects.
    static ArrayList < int[] > raw_graph = new ArrayList < int[] > ();
    static HashMap < Integer, Integer > unique_vertices = new HashMap < Integer, Integer > ();
    static int startVertex;

    //This function reads file and call functions and write outputs of those functions in the file.
    public static void main(String[] args) throws Exception {

        //Make object of class DBconnection and fetching the values returned by db
        DBConnection db = new DBConnection();
        String filenames = db.connectDB();

        //splitting the data for all rows of db i.e. number of input file we have
        String[] filename = filenames.split("   ");
       
        //for each file
        for (int i = 0; i < filename.length ; i++) {

            //Reading from file and storing into data structure for further ease of processing
            String inputPath = "C:/Users/HP/Dropbox/PC/Documents/IIITD/FIRST_SEM/OOPD/Project/data/";
            File file = new File(filename[i] + ".txt");
            String infilename = inputPath + file;
            BufferedReader br = new BufferedReader(new FileReader(infilename));
            String str;
            int r = 0;
            try {
                while ((str = br.readLine()) != null) {
                    int[] row = new int[2];
                    row[0] = Integer.parseInt(str.split(" ")[0]);
                    row[1] = Integer.parseInt(str.split(" ")[1]);
                    raw_graph.add(row);
                    if (!unique_vertices.containsValue(row[0])) {
                        unique_vertices.put(r, row[0]);
                        r++;
                    }
                    if (!unique_vertices.containsValue(row[1])) {
                        unique_vertices.put(r, row[1]);
                        r++;
                    }


                }
            } catch (Exception e) {
                System.out.println("There is something wrong with file format!!" + e);
            }


            BufferedWriter writer = null;
            try {
                //Printing configurations of graph
                Graphs gr = new Graphs();
                int noOfVertices = unique_vertices.size();
                System.out.println("no of vertices in graph  " + filename[i] + " : " + noOfVertices);
                System.out.println("no of edges in graph  " + filename[i] + ": " + raw_graph.size());

                //Creating objects of various classes and fetching corresponding outputs by calling the child child function using parent class object
                //implementing run-time PLOYMORPHISM here.
                Traversal trv = new BFSTraversal();
                Traversal trvs = new DFSTraversal();
                APSP apsp = new APSP();
                ArrayList < Integer > bfsOutput = trv.GraphTraversal(gr.matrixGraph(noOfVertices));
                ArrayList < Integer > dfsOutput = trvs.GraphTraversal(gr.matrixGraph(noOfVertices));
                int apspOutput[][] = apsp.floydWarshall(gr.matrixGraph(noOfVertices));



                //This code creating and writing the output files using BufferedWriter.
                String outputPath = "C:/Users/HP/Dropbox/PC/Documents/IIITD/FIRST_SEM/OOPD/Project/output/" + filename[i];
                File f1 = new File(outputPath);
                //Creating a folder using mkdirs() method of filename 
                boolean iffold = f1.mkdirs();
                if (iffold) {
                    //update output file path into db
                    db.insertToDB(outputPath, filename[i]);
                    //Write BFS file  
                    String outfileNameBFS = "/BFS_Output.txt";
                    outfileNameBFS = outputPath + outfileNameBFS;
                    writer = new BufferedWriter(new FileWriter(outfileNameBFS));
                    writer.write(bfsOutput.toString());

                    //Write DFS file
                    String outfileNameDFS = "/DFS_Output.txt";
                    outfileNameDFS = outputPath + outfileNameDFS;
                    writer = new BufferedWriter(new FileWriter(outfileNameDFS));
                    writer.write(dfsOutput.toString());

                    //Write APSP file
                    String outfileNameAPSP = "/APSP_Output.txt";
                    outfileNameAPSP = outputPath + outfileNameAPSP;
                    StringBuilder builder = new StringBuilder();
                    for (int a=0;a<noOfVertices;a++){
                        for(int b=0;b<noOfVertices;b++){
                            if(apspOutput[a][b]!=999999)
                                builder.append(apspOutput[a][b]+" ");
                            else
                                builder.append("INF"+" ");
                        }
                        builder.append("\n");
                    }
                    BufferedWriter writer2 = new BufferedWriter(new FileWriter(outfileNameAPSP));
                    writer2.write(builder.toString());
                    writer2.close();

                } else {
                    System.out.println("Folder Already Exists!!");
                }
            } catch (Exception e) {
                System.out.println("Error while writing file!!" + e);
            } finally {
                br.close();
                
            }

        }

    }

    //This function creates the graph in the form of adjacency matrix where each element of the matrix will be object of class Edge
    public Edges[][] matrixGraph(int noOfVertices) {

        Edges[][] graph = new Edges[noOfVertices][noOfVertices];
        int k = 0;
        try {
            while (k < raw_graph.size()) {
                int[] r = raw_graph.get(k);
                //Creating two vertices
                Vertices v1 = new Vertices();
                Vertices v2 = new Vertices();
                v1.setNodeID(r[0]);
                v2.setNodeID(r[1]);
                Edges e = new Edges(v1, v2);
                //Creating edge
                e.createEdge();
                if (k == 0) {
                    startVertex = 0;
                }
                int x = 0, y = 0;
                //Finding the key value for corresponding NodeIDs
                for (Entry < Integer, Integer > entry: unique_vertices.entrySet()) {
                    if (entry.getValue() == r[0]) {
                        x = entry.getKey();
                        break;
                    }
                }
                for (Entry < Integer, Integer > entry: unique_vertices.entrySet()) {
                    if (entry.getValue() == r[1]) {
                        y = entry.getKey();
                        break;
                    }
                }

                graph[x][y] = e;
                k++;
            }
        } catch (Exception e) {
            System.out.println("Error while constructing graph" + e);
        }
        return graph;
    }
}