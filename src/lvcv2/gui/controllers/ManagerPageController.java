/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvcv2.gui.controllers;

import lvcv2.classes.Developer;
import lvcv2.classes.datalayer.Server;
import lvcv2.classes.datalayer.Session;
import lvcv2.classes.Project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import lvcv2.LVCv2;

/**
 * FXML Controller class
 *
 * @author Javon-Personal
 */
public class ManagerPageController implements Initializable {

    @FXML Parent root;
    
    @FXML private ListView list;
    
    @FXML private Label title,deadline,description;
    
    @FXML private TableView<Developer> developer_table;
    
    private Stage stage;

    private final ObservableList<Project> projectList = FXCollections.observableArrayList();
    private final ObservableList<Developer> developerList = FXCollections.observableArrayList();
    
    @FXML
    private TableColumn<Developer, String> idColumn;
    @FXML
    private TableColumn<Developer, String> nameColumn;
    
    private boolean table_item_selected = false;
    
    @FXML
    public void handleCloseOption(ActionEvent event)
    {
        System.exit(0);
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
    
    @FXML
    public void handleAddDeveloper(ActionEvent event) throws IOException
    {
        Stage pane = (Stage) root.getScene().getWindow();
        
        Project project = (Project) list.getSelectionModel().getSelectedItem();
        
        
        Server.setProject(project);
        
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(pane.getScene().getWindow());
        
        Parent content = (Parent) FXMLLoader.load(LVCv2.class.getResource("EditDeveloper.fxml"), null, new JavaFXBuilderFactory());
        
        stage.setScene(new Scene(content));
        stage.show();
    }
    
    @FXML 
    public void handleDelete(ActionEvent event)
    {
        if(!table_item_selected)
        {
            Project project = (Project) list.getSelectionModel().getSelectedItem();
            if(project!=null)
            {
                Server.deleteProject(project);
                getProjects();
            }
        }
        else
        {
            Developer developer = developer_table.getSelectionModel().getSelectedItem();
            
            Server.deleteDeveloper(developer, (Project) list.getSelectionModel().getSelectedItem());
        }
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
        
        list.setItems(projectList);
        
        getProjects();
        
        developer_table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Developer>() {

            @Override
            public void changed(ObservableValue<? extends Developer> ov, Developer t, Developer t1) {
                table_item_selected = true;
                System.out.println("here");
            }
        });
        
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Project>() {

            @Override
            public void changed(ObservableValue<? extends Project> ov, Project t, Project t1) {
                
                developerList.clear();
                if(t1!=null)
                {
                    developerList.addAll(Server.getDevelopers(t1));
                }
                        
                title.setVisible(true);
                deadline.setVisible(true);
                description.setVisible(true);
                
                title.setText("");
                deadline.setText("");
                description.setText("");
                
                if(t1!=null)
                {
                    title.setText(t1.getTitle());
                    deadline.setText(t1.getDeadline());
                    description.setText(t1.getDescription());
                }
                
                developer_table.getItems().setAll(developerList);
            }
        });
        
        idColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Developer,String>, ObservableValue<String>>() {         
        @Override
        public ObservableValue<String> call(CellDataFeatures<Developer, String> cdf) {     
            return new SimpleStringProperty(cdf.getValue().getId());
        }
    }); 
        
        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Developer,String>, ObservableValue<String>>() {         
        @Override
        public ObservableValue<String> call(CellDataFeatures<Developer, String> cdf) {     
            return new SimpleStringProperty(cdf.getValue().getName());
        }
    }); 
                
        
    }    
    
    @FXML
    public void handleRefresh(ActionEvent event)
    {
        getProjects();
    }

    public void getProjects() {
        
        projectList.clear();
      
        projectList.addAll(Server.getProjects(Session.getEmployee()));

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

    private EditDeveloperController CustomerDialogController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
