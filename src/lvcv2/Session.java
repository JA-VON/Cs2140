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
public class Session {
    
    private static Employee employee;
    
    public static void setEmployee(Employee e)
    {
        employee = e;
    }
    
    public static Employee getEmployee()
    {
        return employee;
    }
    
    
}
