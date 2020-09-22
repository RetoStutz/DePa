package sample;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;

public class ColorMixerUI extends GridPane {

	private Slider redSlider;
	private Slider greenSlider;
	private Slider blueSlider;

	private Label redLabel;
	private Label greenLabel;
	private Label blueLabel;

	private Label hexRedLabel;
	private Label hexGreenLabel;
	private Label hexBlueLabel;

	private RadioButton setRed;
	private RadioButton setGreen;
	private RadioButton setBlue;
	private RadioButton setYellow;
	private RadioButton setPurple;

	private Rectangle display;

	private Button exit;

	private ColorMixerPM pm;

	public ColorMixerUI(ColorMixerPM pm) {
		this.pm = pm;
        initializeSelf();
        initializeControls();
		layoutControls();
		setupEventHandlers();
		setupValueChangedListeners();
		setupBindings();
	}

	private void initializeSelf(){
        String stylesheet = getClass().getResource("style.css").toExternalForm();
 		getStylesheets().add(stylesheet);
    }

	private void initializeControls() {
        redSlider   = new Slider(0.0, 255, 0);
        greenSlider = new Slider(0.0, 255, 0);
        blueSlider  = new Slider(0.0, 255, 0);

		redLabel   = new Label();
		greenLabel = new Label();
		blueLabel  = new Label();

		hexRedLabel = new Label();
		hexGreenLabel = new Label();
		hexBlueLabel = new Label();

		setRed = new RadioButton("Red");
		setBlue = new RadioButton("Blue");
		setGreen = new RadioButton("Green");
		setYellow = new RadioButton("Yellow");
		setPurple = new RadioButton("Purple");

		display = new Rectangle();
		display.setHeight(150);
		display.setWidth(150);

		exit = new Button("Exit");
		exit.setMaxWidth(Double.MAX_VALUE);
	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setHgap(10);
		setVgap(10);

		ColumnConstraints sliderColumn = new ColumnConstraints();
		sliderColumn.setHgrow(Priority.ALWAYS);

		ColumnConstraints valueColumn = new ColumnConstraints();
		valueColumn.setMinWidth(30);

		getColumnConstraints().addAll(sliderColumn, valueColumn, valueColumn);

		RowConstraints rc = new RowConstraints();
		rc.setVgrow(Priority.ALWAYS);
		getRowConstraints().addAll(rc, rc, rc,rc,rc, rc, rc, rc, rc);

		add(redSlider,0,0);
		add(redLabel,1,0);
		add(hexRedLabel,2,0);

		add(greenSlider,0,1);
		add(greenLabel,1,1);
		add(hexGreenLabel,2,1);

		add(blueSlider,0,2);
		add(blueLabel,1,2);
		add(hexBlueLabel,2,2);

		add(setRed,1,3);
		add(setBlue,1,4);
		add(setGreen,1,5);
		add(setYellow,1,6);
		add(setPurple,1,7);
		add(display, 0, 3,1,5);

		add(exit,0,8,3,1);

		setPrefHeight(getPrefHeight() +200);
	}

	private void setupEventHandlers() {
		setRed.setOnAction(event -> {
			pm.setRed(255);
			pm.setGreen(0);
			pm.setBlue(0);
			setRed.setSelected(false);
		});
		setBlue.setOnAction(event -> {
			pm.setRed(0);
			pm.setGreen(0);
			pm.setBlue(255);
			setBlue.setSelected(false);
		});
		setGreen.setOnAction(event -> {
			pm.setRed(0);
			pm.setGreen(255);
			pm.setBlue(0);
			setGreen.setSelected(false);
		});
		setYellow.setOnAction(event -> {
			pm.setRed(217);
			pm.setGreen(192);
			pm.setBlue(34);
			setYellow.setSelected(false);
		});
		setPurple.setOnAction(event -> {
			pm.setRed(128);
			pm.setGreen(0);
			pm.setBlue(128);
			setPurple.setSelected(false);
		});
		exit.setOnAction(event -> {
			Platform.exit();
		});
	}

	private void setupValueChangedListeners() {
	}

	private void setupBindings() {
		redSlider.valueProperty().bindBidirectional(pm.redProperty());
		redLabel.textProperty().bind(pm.redProperty().asString());
		hexRedLabel.textProperty().bind(pm.hexRedProperty());

		greenSlider.valueProperty().bindBidirectional((pm.greenProperty()));
		greenLabel.textProperty().bind(pm.greenProperty().asString());
		hexGreenLabel.textProperty().bind(pm.hexGreenProperty());

		blueSlider.valueProperty().bindBidirectional(pm.blueProperty());
		blueLabel.textProperty().bind(pm.blueProperty().asString());
		hexBlueLabel.textProperty().bind(pm.hexBlueProperty());

		display.fillProperty().bind(pm.colorProperty());

	}
}
