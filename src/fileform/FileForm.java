/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileform;

import FileEntity.Entity;
import FileModel.Model;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Le Thanh Tung
 */
public class FileForm extends Application {

    private String name1;
    private String img1;
    private String price1;
    private TextField txtName;
    private TextField txtImage;
    private TextField txtPrice;
    Entity en = new Entity(name1, img1, price1);
    Model model = new Model();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label name = new Label("Name");
        Label image = new Label("Image");
        Label price = new Label("Price");
        Label error = new Label();
        Label errName = new Label();
        Label errImg = new Label();
        Label errPrice = new Label();

        txtName = new TextField();
        txtImage = new TextField();
        txtPrice = new TextField();

        Button submit = new Button("submit");
        Button reset = new Button("Reset");

        GridPane girdPane = new GridPane();
        girdPane.add(name, 0, 0, 1, 1);
        girdPane.add(image, 0, 1, 1, 1);
        girdPane.add(price, 0, 2, 1, 1);
        girdPane.add(txtName, 1, 0, 1, 1);
        girdPane.add(txtImage, 1, 1, 1, 1);
        girdPane.add(txtPrice, 1, 2, 1, 1);
        girdPane.add(errName, 2, 0, 1, 1);
        girdPane.add(errImg, 2, 1, 1, 1);
        girdPane.add(errPrice, 2, 2, 1, 1);
        girdPane.add(error, 1, 3, 1, 1);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(submit, reset);
        girdPane.add(hBox, 1, 4, 1, 1);
        girdPane.setHgap(20);
        girdPane.setVgap(20);
        girdPane.setAlignment(Pos.CENTER);

        submit.setOnAction((event) -> {
            name1 = txtName.getText();
            img1 = txtImage.getText();
            price1 = txtPrice.getText();

            if (name1 == null || name1.isEmpty()) {
                error.setTextFill(Color.web("red"));
                error.setText("Không được bỏ trống trường Name.");
                errName.setText("* ");
                return;
            } else {
                error.setText("");
                errName.setText("");
            }
            if (img1 == null || img1.isEmpty()) {
                error.setTextFill(Color.web("red"));
                error.setText("Không được bỏ trống trường image");
                errImg.setText(" *");
                return;
            } else {
                error.setText("");
                errImg.setText("");
            }
            if (price1 == null || price1.isEmpty()) {
                error.setTextFill(Color.web("red"));
                error.setText("Không được bỏ trống trường Price");
                errPrice.setText("* ");
                return;
            } else {
                error.setText("");
                errPrice.setText("");
            }
            en = new Entity(name1, img1, price1);
            if (model.SaveDB(en)) {
                error.setTextFill(Color.web("red"));
                error.setText("Tạo mới thông tin thành công.");

            } else {
                error.setTextFill(Color.web("red"));
                error.setText("Không thể lưu thông tin, vui lòng thử lại sau.");
            }

        });

        reset.setOnMouseClicked((MouseEvent event) -> {
            txtName.clear();
            txtImage.clear();
            txtPrice.clear();
        });

        Scene scene = new Scene(girdPane, 400, 500);
        stage.setScene(scene);
        stage.show();

    }

}
