public class Edges extends Vertices{
Vertices start;
Vertices end;
int weight=0;

Edges(Vertices start, Vertices end ){
    super();
    this.start = start;
    this.end = end;
    this.weight = 0;
}

public Vertices  getNodefromID(int id) {
    if(start.nodeID == id){
      return start;
    }else{
        return end;
    }
    
}

public void  createEdge(){
  
   this.weight=1;
}

}