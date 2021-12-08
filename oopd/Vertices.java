/**This file represents the Vertices Class where we are taking NodeID to represent unique vertices. 
 * This class features ENCAPSULATION where we have taken private data members and public getter and setters */
package oopd;
public class Vertices {
    private int nodeID;

    //To set nodeid to vertex
    public void setNodeID(int n) {
        this.nodeID = n;
    }

    //To get nodeID from vertex
    public int getNodeID() {
        return this.nodeID;
    }
    //Return vertex of id specified
    public int getNodefromID(int n){
        return this.nodeID;
    }
}