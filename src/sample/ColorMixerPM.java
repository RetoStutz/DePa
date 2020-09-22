package sample;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.scene.paint.Color;

public class ColorMixerPM {

    private final IntegerProperty red = new SimpleIntegerProperty();
    private final IntegerProperty green = new SimpleIntegerProperty();
    private final IntegerProperty blue = new SimpleIntegerProperty();

    private final StringProperty hexRed = new SimpleStringProperty();
    private final StringProperty hexGreen = new SimpleStringProperty();
    private final StringProperty hexBlue = new SimpleStringProperty();

    private final ObjectProperty<Color> color = new SimpleObjectProperty<>();

    public ColorMixerPM (){
        final ChangeListener<Number> l = (observable, oldValue, newValue) -> updateColor();
        redProperty().addListener(l);
        blueProperty().addListener(l);
        greenProperty().addListener(l);
        updateColor();
    }

    public String getHexRed() {
        return hexRed.get();
    }

    public StringProperty hexRedProperty() {
        return hexRed;
    }

    public void setHexRed(String hexRed) {
        this.hexRed.set(hexRed);
    }

    public String getHexGreen() {
        return hexGreen.get();
    }

    public StringProperty hexGreenProperty() {
        return hexGreen;
    }

    public void setHexGreen(String hexGreen) {
        this.hexGreen.set(hexGreen);
    }

    public String getHexBlue() {
        return hexBlue.get();
    }

    public StringProperty hexBlueProperty() {
        return hexBlue;
    }

    public void setHexBlue(String hexBlue) {
        this.hexBlue.set(hexBlue);
    }

    private void updateHex(){
        setHexRed(Integer.toHexString(getRed()));
        setHexBlue(Integer.toHexString(getBlue()));
        setHexGreen(Integer.toHexString(getGreen()));

    }

    private void updateColor() {
        setColor(Color.rgb(getRed(), getGreen(),getBlue()));
        updateHex();
    }

    public int getRed() { return red.get();
    }

    public IntegerProperty redProperty() {
        return red;
    }

    public void setRed(int red) {
        this.red.set(red);
    }

    public int getGreen() {return green.get();}

    public IntegerProperty greenProperty() {
        return green;
    }

    public void setGreen(int green) {
        this.green.set(green);
    }

    public int getBlue() {
        return blue.get();
    }

    public IntegerProperty blueProperty() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue.set(blue);
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }
}
