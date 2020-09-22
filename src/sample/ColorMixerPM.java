package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.paint.Color;

public class ColorMixerPM {

    private final IntegerProperty red = new SimpleIntegerProperty();
    private final IntegerProperty green = new SimpleIntegerProperty();
    private final IntegerProperty blue = new SimpleIntegerProperty();

    private final ObjectProperty<Color> color = new SimpleObjectProperty<>();

    public ColorMixerPM (){
        final ChangeListener<Number> l = (observable, oldValue, newValue) -> updateColor();
        redProperty().addListener(l);
        blueProperty().addListener(l);
        greenProperty().addListener(l);
        updateColor();
    }

    private void updateColor() {
        setColor(Color.rgb(getRed(), getGreen(),getBlue()));
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
