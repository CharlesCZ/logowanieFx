package src.sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.model.DatabaseVoip;
import src.model.User;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


public class LoginController {

    @FXML
    private TextField loginUserFieldId;

    @FXML
    private PasswordField loginPasswordFieldId;

    @FXML
    private TextField registerUserFieldId;

    @FXML
    private TextField registerPasswordFieldId;

    @FXML
    private TextField registerConfPasswordFieldId;

    @FXML
    private void onLoginAction() throws IOException {

        DatabaseVoip d=new DatabaseVoip();
        d.insertUser(loginUserFieldId.getText(),loginPasswordFieldId.getText());
        User user=d.selectUser(loginUserFieldId.getText(),loginPasswordFieldId.getText());

        d.insertHistoryConnection(user.getId(),"sip sendera","sip invitera",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));

        System.out.println(loginUserFieldId.getText());

        System.out.println(loginPasswordFieldId.getText());
        Stage primaryStage= new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }


    @FXML
    private void onRegisterAction(){



    }
}
