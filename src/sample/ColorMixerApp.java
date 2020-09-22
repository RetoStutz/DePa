package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorMixerApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ColorMixerPM pm = new ColorMixerPM();
		Parent rootPanel = new ColorMixerUI(pm);

		Scene scene = new Scene(rootPanel);

		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
