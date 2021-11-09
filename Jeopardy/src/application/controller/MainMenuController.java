package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private AnchorPane mainPane;
    
    @FXML
    void handlePlay(ActionEvent event) {
		try {
			//System.out.println(userName);
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("./application/view/JeopardyGame.fxml"));
			mainPane = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }

    @FXML
    void handleQuit(ActionEvent event) {

    }

    @FXML
    void handleScores(ActionEvent event) {

    }

}
