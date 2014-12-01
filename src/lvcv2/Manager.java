package lvcv2;




/**
* This is the Manager's class that gives all methods that are authorized to Managers.
 * File and specific object related functions have not been placed yet.
 * 
 * @author Kerine Wint and Javon Davis
 * @version Nov 9. 2014
 */
public class Manager extends Employee
{
    
    public Manager(String id,String name){
       super(id,name);
       this.title = "Manager";
    }
    
    /*
    public void Menu(){
        
        System.out.println ("JK Solutions - Local Version Control");
        System.out.println ("A - Add a new project");
        System.out.println (" D - Delete project");
        System.out.println ("U - Update a project");
        System.out.println ("R - Retrieve a project");
        System.out.println ("Select an option -->");
        
        String Option = input.nextLine();
        Option = Option.toUpperCase(); //converts the input to Upper case letters 
        
        // a series of if statements for each option provided in the above list of options
        if (Option.equals("A"))
        {
            Add();
        }
        
        if (Option.equals("D"))
        {
            System.out.println("Enter project code:");
            project_name = input.nextLine();
            Delete(project_name);
        }
        
        if (Option.equals("U"))
        {
            System.out.println("Enter project code:");
            project_name = input.nextLine();
            Retrieve(project_name);
        }
        
        if (Option.equals("R"))
        {
            System.out.println("Enter project code:");
            project_name = input.nextLine();
            Update(project_name);
        } 
    }*/
    /*
    public void Add(){
        
        System.out.println("Project Code:");
        String project_code = input.nextLine();
        System.out.println("Title:");
        String title = input.nextLine();
        System.out.println("List of Developers");
        String code_list = input.nextLine();
        System.out.println("Developer's task:");
        String developer_task = input.nextLine();
        
        Project newproj = new Project(project_code, title, code_list, developer_task, Name);
    }
    */
    public void Delete(Object project_name){
    
       //remove project
    }
    
    public void Update(Object project_name){
    
        //opens file
    }
    
    public void Retrieve(Object project_name){
    
        //get project
    }
}
