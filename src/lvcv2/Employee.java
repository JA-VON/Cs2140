/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvcv2;

/**
 *
 * @author Javon-Personal
 */
public class Employee {
    
    protected String name,title,id;
    
    public Employee(String id,String name)
    {
        this.name=name;
        this.id=id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public boolean isManager()
    {
        return this.title.equals("Manager");
    }
    
    public boolean isDeveloper()
    {
       return this.title.equals("Developer"); 
    }
    
    public String getId()
    {
        return this.id;
    }
    
    public void setId(String ID)
    {
        this.id=ID;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
}
