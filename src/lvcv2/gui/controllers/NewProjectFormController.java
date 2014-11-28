/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvcv2.gui.controllers;

import lvcv2.classes.datalayer.Server;
import lvcv2.classes.datalayer.Session;
import lvcv2.classes.Project;
import lvcv2.classes.Manager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javon-Personal
 */
public class NewProjectFormController implements Initializable  {

    @FXML
    private TextField title,deadline;
    
    @FXML private Label error;

    @FXML
    private TextArea description;
    
    @FXML
    public void handleOkButton(ActionEvent event)
    {
        Manager manager = ((Manager) Session.getEmployee());
        Project project = new Project(0,title.getText(),manager,description.getText(),deadline.getText());
        Server.addProject(project);
        
        ((Stage) ((Node)(event.getSource())).getScene().getWindow()).close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
}
