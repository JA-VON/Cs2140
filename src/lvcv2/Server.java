package lvcv2;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Write a description of interface Server here.
 * 
 * @author Kerine Wint and Javon Davis 
 * @version Nov 9. 2014
 */
public class Server
{
    /*
   private static HashMap<String,String> managers = new HashMap<>();
   private static HashMap<String,String> developers = new HashMap<>();
   private static HashMap<String,String> names = new HashMap<>();
   
  static
  {
      managers.put("M1231", "cat");
      managers.put("M1232", "cat");
      managers.put("M1233", "cat");
      managers.put("M1234", "cat");
      managers.put("M1235", "cat");
      
      developers.put("D1231", "dog");
      developers.put("D1232", "dog");
      developers.put("D1233", "dog");
      developers.put("D1234", "dog");
      developers.put("D1235", "dog");   
      
      names.put("M1231", "Mark");
      names.put("M1232", "Kerine");
      names.put("M1233", "Javon");
      names.put("M1234", "David");
      names.put("M1235", "Tiffany");
      names.put("D1231", "Kartel");
      names.put("D1232", "Demarco");
      names.put("D1233", "Carlton");
      names.put("D1234", "Will");
      names.put("D1235", "Uncle Phil");
  }*/
    
    public static void addProject(Project project)
    {
        
    }
  
    public static void viewProjects(Employee employee)
    {
    }
    
    public void addCode(Project project, String location, Developer developer)
    {
        
    }
    
    public static Employee validEmployee(String _id,String pw)
    {
          Connection c;
          Statement stmt;
          Employee employee;
          try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lvc.db");// open test database
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM employee where id like '"+_id+"' and password like "
                    + "'"+pw+"';" );
            while ( rs.next() ) {
                String name = rs.getString("name");

                if(rs.getString("identifier").equals("M"))
                {
                    employee = new Manager(name);
                    return employee;
                }

            }
            rs.close();
            stmt.close();
            c.close();
          } catch ( ClassNotFoundException | SQLException e ) {
            Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
          }
          return null;
    }
  
}
