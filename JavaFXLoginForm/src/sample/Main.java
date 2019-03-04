package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 纯代码实现基础的登录表单并且给Scene添加css样式
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // GridPane Layout 允许行列布局
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Create Title
        Text sceneTitle = new Text("Login");
        sceneTitle.setId("Login-text");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(sceneTitle, 0, 0);

        //  Create Label and TextField for UserName
        Label userName = new Label("UserName:");
        gridPane.add(userName, 0, 1);
        TextField userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);

        //  Create Label and TextField for Password
        Label password = new Label("Password:");
        gridPane.add(password, 0, 2);
        PasswordField pwdTextField = new PasswordField();
        gridPane.add(pwdTextField, 1, 2);

        // Create Submit Btn
        Button btn = new Button("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(btn);// 把Btn加到HBox
        gridPane.add(hBox, 1, 4);

        // 显示提示消息
        final Text actionTarget = new Text();
        gridPane.add(actionTarget, 1, 6);

        // Add Event for Btn
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Sign in btn pressed.");
            }
        });

        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Main.class.getResource("/resources/login.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
