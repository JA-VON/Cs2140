/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvcv2.classes.datalayer;

import lvcv2.Server;
import java.util.List;
import junit.framework.TestCase;
import lvcv2.Developer;
import lvcv2.Employee;
import lvcv2.Manager;
import lvcv2.Project;

/**
 *
 * @author Javon-Personal
 */
public class ServerTest extends TestCase {
    
    public ServerTest(String testName) {
        super(testName);
    }

    /**
     * Test of setProject method, of class Server.
     */
    public void testSetProject() {
        
        System.out.println("setProject");
        Project project = null;
        Server.setProject(project);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProject method, of class Server.
     */
    public void testGetProject() {
        System.out.println("getProject");
        Project expResult = new Project(16, null, null, null, null);
        
        Server.setProject(expResult);
        
        Project result = Server.getProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addProject method, of class Server.
     */
    public void testAddProject() {
        System.out.println("addProject");
        Project project = null;
        Server.addProject(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDeveloper method, of class Server.
     */
    public void testDeleteDeveloper() {
        System.out.println("deleteDeveloper");
        Developer developer = null;
        Project project = null;
        Server.deleteDeveloper(developer, project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProject method, of class Server.
     */
    public void testDeleteProject() {
        System.out.println("deleteProject");
        Project project = null;
        Server.deleteProject(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDevelopers method, of class Server.
     */
    public void testGetDevelopers() {
        System.out.println("getDevelopers");
        Project project = null;
        List<Developer> expResult = null;
        List<Developer> result = Server.getDevelopers(project);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDeveloper method, of class Server.
     */
    public void testAddDeveloper() {
        System.out.println("addDeveloper");
        Project project = new Project(16,null,null,null,null);
        String developer_id = "D1235";
        Server.addDeveloper(project, developer_id);
    }

    /**
     * Test of getProjects method, of class Server.
     */
    public void testGetProjects() {
        System.out.println("getProjects");
        Employee employee = null;
        List<Project> expResult = null;
        List<Project> result = Server.getProjects(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCode method, of class Server.
     */
    public void testAddCode() {
        System.out.println("addCode");
        Project project = null;
        String location = "";
        Developer developer = null;
        Server instance = new Server();
        instance.addCode(project, location, developer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validEmployee method, of class Server.
     */
    public void testValidEmployee() {
        System.out.println("validEmployee");
        String _id = "M1231";
        String pw = "pw1231";
        Employee expResult = null;
        Employee result = Server.validEmployee(_id, pw);
        assertEquals(expResult, result);
        
    }
    
}
