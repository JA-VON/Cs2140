/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvcv2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javon-Personal
 */
public class ManagerPageController implements Initializable {

    @FXML Parent root;
    
    @FXML private ListView list;
    
    @FXML private Label title,deadline,description;
    
    @FXML private TableView developer_table;

    private ObservableList<Project> currentList = FXCollections.observableArrayList();
    
    @FXML
    public void handleCloseOption(ActionEvent event)
    {
        System.exit(0);
    }
    
    @FXML
    public void handleNewProject(ActionEvent event) throws IOException
    {    
        
        Stage pane = (Stage) root.getScene().getWindow();
        
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(pane.getScene().getWindow());
        
        Parent content = (Parent) FXMLLoader.load(LVCv2.class.getResource("NewProjectForm.fxml"), null, new JavaFXBuilderFactory());
        
        stage.setScene(new Scene(content));
        stage.show();
       
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        developer_table.setPlaceholder(new Label("You have added no developers to this project as yet."));
        
        list.setItems(currentList);
        
        getProjects();
        
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Project>() {

            @Override
            public void changed(ObservableValue<? extends Project> ov, Project t, Project t1) {
                title.setVisible(true);
                deadline.setVisible(true);
                description.setVisible(true);
                
                title.setText(t1.getTitle());
                deadline.setText(t1.getDeadline());
                description.setText(t1.getDescription());
            }
        });
    }    
    
    @FXML
    public void handleRefresh(ActionEvent event)
    {
        list.getSelectionModel().clearSelection();
        getProjects();
    }

    public void getProjects() {
        
        if(currentList==null)
            currentList = FXCollections.observableArrayList();
        
        currentList.clear();
      
        currentList.addAll(Server.getProjects(Session.getEmployee()));

    }
    
}
