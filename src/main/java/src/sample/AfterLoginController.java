package src.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.model.User;

import java.io.IOException;


public class AfterLoginController {

@FXML
private Text userName;

    public void setUser(User user) {
        System.out.println(user.getLogin());
        userName.setText(user.getLogin());
    }

    @FXML
    public void signOutAction(ActionEvent event)  {
        try {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage= new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
