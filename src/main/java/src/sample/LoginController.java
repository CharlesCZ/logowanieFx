package src.sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.model.DatabaseVoip;
import src.model.User;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


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
    private Text textUsername;

    @FXML
    private  Text passwordMisMatch;

    @FXML
    private Text passwordMisMatch2;

    @FXML
    private Text statusRegisterId;

    @FXML
    private Text loginText;

    @FXML
    private void onLoginAction() throws IOException {
        loginText.setText("");
        DatabaseVoip d=new DatabaseVoip();

        User user=d.selectUser(loginUserFieldId.getText(),GFG.encryptThisString(loginPasswordFieldId.getText()));
if(user==null){
    loginText.setText("Wrong login or password");
    return;
}
       // d.insertHistoryConnection(user.getId(),"sip sendera","sip invitera",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));

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
        textUsername.setText("");
        passwordMisMatch.setText("");
        passwordMisMatch2.setText("");
        statusRegisterId.setText("");

        DatabaseVoip d=new DatabaseVoip();
        List<User> users=d.selectUsers();
       if( users.stream().anyMatch(user -> user.getLogin().equals(registerUserFieldId.getText()))) {
           textUsername.setText("Login already exists");
            return;
       }

        if( !registerPasswordFieldId.getText().equals(registerConfPasswordFieldId.getText())) {
            passwordMisMatch.setText("Password mismatch");
            passwordMisMatch2.setText("Password mismatch");
            return;
        }

        d.insertUser(registerUserFieldId.getText(),GFG.encryptThisString(registerPasswordFieldId.getText()));
        d.closeConnection();
        statusRegisterId.setText("Account created!");

    }
}
