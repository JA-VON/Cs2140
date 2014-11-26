package lvcv2;


/**
 * Write a description of class Project here.
 * 
 * @author Javon Davis
 * @author Kerine Wint
 * @version v1.0
 */
public class Project
{
    
    private String title,deadline,description;
    private Manager manager;
    
    public Project(String title,Manager manager,String description,String deadline)
    {
        this.title = title;
        this.manager = manager;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public Manager getManager()
    {
        return manager;
    }
    
    public void setTitle(Manager manager)
    {
        this.manager = manager;
    }
    
    public void setDeadline(String deadline)
    {
        this.deadline = deadline;
    }
    
    public String getDeadline()
    {
        return this.deadline;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    @Override
    public String toString()
    {
        return getTitle();
    }
}
