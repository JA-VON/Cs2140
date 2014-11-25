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
    
    private String title;
    private Manager manager;
    
    public Project(String title,Manager manager)
    {
        this.title = title;
        this.manager = manager;
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
    
    
}
