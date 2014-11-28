package lvcv2.classes.datalayer;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lvcv2.LVCv2;
import lvcv2.classes.Developer;
import lvcv2.classes.Employee;
import lvcv2.classes.Manager;
import lvcv2.classes.Project;


/**
 * Write a description of interface Server here.
 * 
 * @author Kerine Wint and Javon Davis 
 * @version Nov 9. 2014
 */
public class Server
{
    //variable used to keep track of a project when adding a developer to a project
    private static Project devProject;
    
    /**
     * sets the project for a developer to be added to.
     * @param project 
     */
    public static void setProject(Project project)
    {
        devProject = project;
    }
    
    /**
     * Gets the project that was recently set for a developer to be added onto.
     * @return 
     */
    public static Project getProject()
    {
        return devProject;
    }
    
    public static void addProject(Project project)
    {
        Connection c;
        Statement stmt;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:lvc.db");
          c.setAutoCommit(false);
          

          stmt = c.createStatement();
         
          String sql = "INSERT INTO projects (title,deadline,manager_id,description) " +
                "VALUES ('"+project.getTitle()+"', '"+project.getDeadline()+"', '"+project.getManager().getId()+"','"+project.getDescription()+"');"; 
          stmt.executeUpdate(sql);


          stmt.close();
          c.commit();
          c.close();
          
        } catch ( ClassNotFoundException | SQLException e ) {
          Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
          
        }
        
    }
    
    public static void deleteDeveloper(Developer developer,Project project)
    {
        Connection c;
        Statement stmt;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:lvc.db");
          c.setAutoCommit(false);
          

          stmt = c.createStatement();
         
          String sql = "delete from projects_developers where project_id="+project.getId()+" and developer_id like '"+developer.getId()+"';"; 
          stmt.executeUpdate(sql);


          stmt.close();
          c.commit();
          c.close();
          
        } catch ( ClassNotFoundException | SQLException e ) {
          Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
          
        }
        
    }
    
    public static void deleteProject(Project project)
    {
        Connection c;
        Statement stmt;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:lvc.db");
          c.setAutoCommit(false);
          

          stmt = c.createStatement();
          
          String sql = "delete from projects where id="+project.getId()+";"; 
          stmt.executeUpdate(sql);
          
          sql = "delete from projects_developers where project_id="+project.getId()+";"; 
          stmt.executeUpdate(sql);
          
          sql = "delete from codebase where project_id="+project.getId()+";"; 
          stmt.executeUpdate(sql);


          stmt.close();
          c.commit();
          c.close();
          
        } catch ( ClassNotFoundException | SQLException e ) {
          Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
          
        }
    }
    
    public static List<Developer> getDevelopers(Project project)
    {
        Connection c;
        Statement stmt;
        ArrayList<Developer> developers = new ArrayList<>();
        try {
              Class.forName("org.sqlite.JDBC");
              c = DriverManager.getConnection("jdbc:sqlite:lvc.db");// open test database
              c.setAutoCommit(false);

              stmt = c.createStatement();

              ResultSet rs = stmt.executeQuery( "SELECT * FROM projects_developers where project_id like '"+project.getId()+"';" );
              while ( rs.next() ) {
                  
                  String devloper_id = rs.getString("developer_id");
                  
                  Developer developer;
                    
                    Statement stmt3 = c.createStatement();
                    
                    ResultSet rs3 = stmt3.executeQuery( "SELECT * FROM employees where id like '"+devloper_id+"';" );
                    while ( rs3.next() ) {
 
                        String id = rs3.getString("id");
                        String name = rs3.getString("name");
                        
                        developer = new Developer(devloper_id,name);
                        developers.add(developer);
                    }
                    rs3.close();
                    stmt3.close();
              }
              rs.close();
              stmt.close();
              c.close();
              return developers;
            } catch ( ClassNotFoundException | SQLException e ) {
              Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
              return null;
            }
    }
    
    public static void addDeveloper(Project project,String developer_id)
    {
        Connection c;
        Statement stmt;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:lvc.db");
          c.setAutoCommit(false);
          

          stmt = c.createStatement();
          
          String sql = "INSERT INTO projects_developers (project_id,developer_id) " +
                "VALUES ("+project.getId()+", '"+developer_id+"');"; 
          stmt.executeUpdate(sql);


          stmt.close();
          c.commit();
          c.close();
          
          devProject = null;
          
        } catch ( ClassNotFoundException | SQLException e ) {
          Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
          
        }
    }
  
    public static List<Project> getProjects(Employee employee)
    {
        Connection c;
        Statement stmt;
          
        ArrayList<Project> projects = new ArrayList<>();
          
          if(employee.isManager())
          {
            try {
              Class.forName("org.sqlite.JDBC");
              c = DriverManager.getConnection("jdbc:sqlite:lvc.db");// open test database
              c.setAutoCommit(false);

              stmt = c.createStatement();

              ResultSet rs = stmt.executeQuery( "SELECT * FROM projects where manager_id like '"+employee.getId()+"';" );
              while ( rs.next() ) {
                  Project project;

                  int id = rs.getInt("id");
                  String title = rs.getString("title");
                  String deadline = rs.getString("deadline");
                  String description = rs.getString("description");

                  project = new Project(id,title, (Manager) employee, description, deadline);

                  projects.add(project);

              }
              rs.close();
              stmt.close();
              c.close();
              return projects;
            } catch ( ClassNotFoundException | SQLException e ) {
              Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
              return null;
            }
        }else if(employee.isDeveloper())
        {
            
            try {
              Class.forName("org.sqlite.JDBC");
              c = DriverManager.getConnection("jdbc:sqlite:lvc.db");// open test database
              c.setAutoCommit(false);

              stmt = c.createStatement();

              ResultSet rs = stmt.executeQuery( "SELECT * FROM projects_developers where developer_id like '"+employee.getId()+"';" );
             
              while ( rs.next() ) {
                  Project project;

                  int id = rs.getInt("project_id");
                  
                  Statement stmt2 = c.createStatement();
                  ResultSet rs2 = stmt2.executeQuery( "SELECT * FROM projects where id = "+id+";" );
                while ( rs2.next() ) {

                    int proj_id = rs2.getInt("id");
                    String title = rs2.getString("title");
                    String deadline = rs2.getString("deadline");
                    String description = rs2.getString("description");
                    String manager_id = rs2.getString("manager_id");
                    
                    
                    Manager manager;
                    
                    Statement stmt3 = c.createStatement();
                    
                    ResultSet rs3 = stmt3.executeQuery( "SELECT * FROM employees where id like '"+manager_id+"';" );
                    while ( rs3.next() ) {
 
                        String name = rs3.getString("name");
                        
                        manager = new Manager(manager_id,name);
                        
                        project = new Project(proj_id,title,manager , description, deadline);

                        projects.add(project);

                    }
                    rs3.close();
                    stmt3.close();
                }
                rs2.close();
                stmt2.close();
              }
              rs.close();
              stmt.close();
              c.close();
              return projects;
            } catch ( ClassNotFoundException | SQLException e ) {
              Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
              return null;
            }
        }
          return null;
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
            ResultSet rs = stmt.executeQuery( "SELECT * FROM employees where id like '"+_id+"' and password like "
                    + "'"+pw+"';" );
            while ( rs.next() ) {
                String name = rs.getString("name");
                String id = rs.getString("id");

                if(rs.getString("identifier").equals("M"))
                {
                    employee = new Manager(id,name);
                    rs.close();
                    stmt.close();
                    c.close();
                    return employee;
                }
                else if(rs.getString("identifier").equals("D"))
                {
                    employee = new Developer(id,name);
                    rs.close();
                    stmt.close();
                    c.close();
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
