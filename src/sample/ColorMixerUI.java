package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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

	private Rectangle display;

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

		display = new Rectangle();
	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setHgap(10);
		setVgap(10);

		ColumnConstraints sliderColumn = new ColumnConstraints();
		sliderColumn.setHgrow(Priority.ALWAYS);

		ColumnConstraints valueColumn = new ColumnConstraints(30);
		valueColumn.setHalignment(HPos.RIGHT);

		ColumnConstraints valueHex = new ColumnConstraints(30);
		valueColumn.setHalignment(HPos.RIGHT);

		getColumnConstraints().addAll(sliderColumn, valueColumn, valueHex);

		addRow(0, redSlider  , redLabel, hexRedLabel);
		addRow(1, greenSlider, greenLabel, hexGreenLabel);
		addRow(2, blueSlider , blueLabel, hexBlueLabel);

		add(display, 0, 3, 3, 1);

		setPrefHeight(getPrefHeight() + 200);
	}

	private void setupEventHandlers() {
	}

	private void setupValueChangedListeners() {
	}

	private void setupBindings() {
		redSlider.valueProperty().bindBidirectional(pm.redProperty());
		redLabel.textProperty().bind(pm.redProperty().asString()); //unidirektional da Label vom Benutzer nicht editiert werden kann
		hexRedLabel.textProperty().bind(pm.hexRedProperty());

		greenSlider.valueProperty().bindBidirectional((pm.greenProperty()));
		greenLabel.textProperty().bind(pm.greenProperty().asString());
		hexGreenLabel.textProperty().bind(pm.hexGreenProperty());

		blueSlider.valueProperty().bindBidirectional(pm.blueProperty());
		blueLabel.textProperty().bind(pm.blueProperty().asString());
		hexBlueLabel.textProperty().bind(pm.hexBlueProperty());

		display.fillProperty().bind(pm.colorProperty());

		display.widthProperty().bind(widthProperty()
                                             .subtract(20));
		display.heightProperty().bind(heightProperty()
                                              .subtract(redSlider.heightProperty())
                                              .subtract(greenSlider.heightProperty())
                                              .subtract(blueSlider.heightProperty())
                                              .subtract(50));
	}
}
