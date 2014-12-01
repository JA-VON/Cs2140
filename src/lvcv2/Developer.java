package lvcv2;

/**
 * This is the Developer's class that gives all methods that are authorized to Developers.
 * File and object related functions have not been placed yet.
 * 
 * @author Kerine Wint and Javon Davis
 * @version Nov 9. 2014
 */
public class Developer extends Employee
{
    
    public Developer(String id,String name){
        super(id,name);
        this.title = "Developer";
    }
}
