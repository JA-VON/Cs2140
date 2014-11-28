/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvcv2.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lvcv2.classes.Employee;
import lvcv2.LVCv2;
import lvcv2.classes.datalayer.Server;
import lvcv2.classes.datalayer.Session;

/**
 * FXML Controller class
 *
 * @author Javon-Personal
 */
public class LoginPageController implements Initializable  {

    private Stage stage;
    
    @FXML
    private TextField userID,password;
    
    @FXML private Label errorLabel;
    
    
    
    @FXML
    public void handleLogin(ActionEvent event)
    {
        String id = userID.getText();
        String pw = password.getText();
        
        Employee employee = Server.validEmployee(id, pw);
        if(employee!=null)
        {
            Session.setEmployee(employee);
            if(employee.isDeveloper())
            {
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                try
                {
                    replaceSceneContent("DeveloperPage.fxml");
                }
                catch(Exception e)
                {
                    Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            else if(employee.isManager())
            {
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                try
                {
                    replaceSceneContent("ManagerPage.fxml");
                }
                catch(Exception e)
                {
                    Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
                }
            } 
        }
        else
        {
            errorLabel.setVisible(true);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private Parent replaceSceneContent(String fxml) throws Exception{
        
        Parent page = (Parent) FXMLLoader.load(LVCv2.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 450);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
    
}
