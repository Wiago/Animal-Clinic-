package br.ufrpe.animal_clinic.gui;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static ArrayList<Scene> cenas = new ArrayList<Scene>();
    private static Stage stage;
	
	public void criaCena(String doc) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(doc));
        Scene scene = new Scene(root);
        cenas.add(scene);
    }

    public static void trocaCena(int i) {
        stage.setScene(cenas.get(i));
    }

    public static Stage getStage() {
        return stage;
    }
    

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		criaCena("TelaLogin.fxml");       //0
		criaCena("TelaCadastro.fxml");    //1
		criaCena("TelaUsuario.fxml");     //2
		
		stage.setScene(cenas.get(0));
        stage.setTitle("ANIMAL CLINIC");
        stage.show();
        setStage(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
