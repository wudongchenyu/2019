package org.openjfx;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) {
		myScence(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void myScence(Stage stage) {
		Parent root;
		try {
			URL resource = getClass().getResource("/org/openjfx/fxml/MyScence.fxml");
			root = FXMLLoader.load(resource);
			//设置Scene的大小(SceneBuilder中点击AnchorPane右边Layout中会显示大小,不一样的可以) 
			Scene scene = new Scene(root,500,522);
			scene.getStylesheets().add(getClass().getResource("/org/openjfx/css/application.css").toExternalForm()); 
			stage.setScene(scene); 
			stage.setResizable(false);
			//设置不能窗口改变大小 
			stage.setTitle("简单的基于JavaFX的数据库连接工具");
			//设置标题 
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void version(Stage stage) {
		String version = System.getProperty("java.version");
		Label l = new Label("Hello, JavaFX 11,  running on " + version);
		Scene scene = new Scene(new StackPane(l), 300, 200);
		stage.setScene(scene);
		stage.show();
	}

}