/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvcv2.gui.controllers;

import lvcv2.classes.datalayer.Server;
import lvcv2.classes.Project;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javon-Personal
 */
public class EditDeveloperController implements Initializable {

    @FXML private TextField idField;
    
    @FXML 
    public void handleNewDeveloper(ActionEvent event)
    {
        Project project = Server.getProject();
        String id = idField.getText();
        
        Server.addDeveloper(project, id);
        ((Stage) ((Node)(event.getSource())).getScene().getWindow()).close();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
