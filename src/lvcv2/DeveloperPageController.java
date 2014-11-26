/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvcv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Javon-Personal
 */
public class DeveloperPageController implements Initializable {
    
    @FXML private ListView<Project> list;
    @FXML private Label manager,deadline,description;
    @FXML private Button viewButton,addCodeButton;
    
    private final ObservableList<Project> currentList = FXCollections.observableArrayList();
    
    @FXML
    public void handleAddCode(ActionEvent event)
    {
        
    }
    
    @FXML
    public void handleViewAll(ActionEvent event)
    {
        
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
    
}
