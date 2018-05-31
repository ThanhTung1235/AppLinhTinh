/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileform;

import FileEntity.Entity;
import FileModel.Model;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Le Thanh Tung
 */
public class MainView extends Application {

    Entity en = new Entity();

    @Override
    public void start(Stage stage) throws Exception {
        TableView<Entity> tableView = new TableView<>();

        TableColumn<Entity, String> columnName = new TableColumn<>("Tên");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnName.setMinWidth(200);

        TableColumn<Entity, String> columnImage = new TableColumn<>("Ảnh");
        columnImage.setCellValueFactory(new PropertyValueFactory<>("img"));
        columnImage.setMinWidth(200);

        TableColumn<Entity, Integer> columnPrice = new TableColumn<>("Giá (VND)");
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnPrice.setMinWidth(100);
        Model model = new Model();
        ArrayList<Entity> list = model.Query();

        columnImage.setCellFactory(
                new Callback<TableColumn<Entity, String>, TableCell<Entity, String>>() {
                    @Override
                    public TableCell<Entity, String> call(TableColumn<Entity, String> param) {

                        return new TableCell<Entity, String>() {
                            @Override
                            public void updateItem(String item, boolean empty) {
                                if (item != null) {
                                    for (Entity en : list) {
                                        Image img = new Image(en.getImg());
                                        ImageView imgView = new ImageView(img);
                                        imgView.setFitHeight(200);
                                        imgView.setFitWidth(200);
                                        setGraphic(imgView);
                                    }
                                }
                            }
                        };
                    }

                }
        );
        tableView.getColumns().addAll(columnName, columnImage, columnPrice);
        ObservableList<Entity> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(list);
        tableView.getItems().addAll(observableArrayList);

        Scene scene = new Scene(tableView, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Application");
//        stage.getIcons().add(new Image("App-Messages-icon."));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
