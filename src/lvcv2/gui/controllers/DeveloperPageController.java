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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lvcv2.LVCv2;
import javafx.stage.Stage;
import lvcv2.LVCv2;
import lvcv2.classes.Project;
import lvcv2.classes.datalayer.Server;
import lvcv2.classes.datalayer.Session;

/**
 * FXML Controller class
 *
 * @author Javon-Personal
 */
public class DeveloperPageController implements Initializable {
    
    @FXML private ListView<Project> list;
    @FXML private Label manager,deadline,description;
    @FXML private Button viewButton,addCodeButton;
    @FXML Parent root;
    
    private final ObservableList<Project> currentList = FXCollections.observableArrayList();
    
    private Stage stage;
    
    @FXML
    public void handleAddCode(ActionEvent event)
    {
        
    }
    
    @FXML
    public void handleViewAll(ActionEvent event)
    {
        
    }
    
    @FXML
    public void handleLogout(ActionEvent event)
    {
        Session.setEmployee(null);
        
        stage = (Stage) (root).getScene().getWindow();
            try
            {
                replaceSceneContent("LoginPage.fxml");
            }
            catch(Exception e)
            {
                Logger.getLogger(LVCv2.class.getName()).log(Level.SEVERE, null, e);
            }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //viewButton.setDisable(false);
        //addCodeButton.setDisable(false);
        
        list.setItems(currentList);
        
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Project>() {

            @Override
            public void changed(ObservableValue<? extends Project> ov, Project t, Project t1) {
                
                manager.setText(t1.getManager().toString());
                deadline.setText(t1.getDeadline());
                description.setText(t1.getDescription());
                
                if(viewButton.isDisabled()&&addCodeButton.isDisabled())
                {
                    viewButton.setDisable(false);
                    addCodeButton.setDisable(false);
                }
                    
            }
        });
        
        getProjects();

    }
    
    public void getProjects() {
        
        currentList.clear();
      
        currentList.addAll(Server.getProjects(Session.getEmployee()));

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
