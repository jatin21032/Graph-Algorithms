import java.sql.*; 
public class DBConnection {
 
public String connectDB(){ 
    String dboutput="";
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oopd?characterEncoding=latin1","root","jatin");  
//here project is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from Graph");  

while(rs.next()){
    dboutput = (String.valueOf(rs.getInt(1)) +"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  
}  
 
con.close();  
}catch(Exception e){
     System.out.println(e);
    }  
    
    return dboutput;
}
}  
 

