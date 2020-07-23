
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql:///loginform","root","root");
        s = c.createStatement();
    }catch(Exception ex){
        ex.printStackTrace();
            }
}
}