/*
 * A Simple Color Chooser for JavaFX
 */
package color_chooser_fx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Zunayed Hassan
 */
public class ColorChooserFx_Test extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Building icon for the button
        Color previewColor = Color.GREEN;
        
        Text ButtonTextIcon = new Text("T");
        ButtonTextIcon.setFont(Font.font("Serif", FontWeight.BOLD, 12));

        Rectangle ButtonColorPreview = new Rectangle(20, 5);
        ButtonColorPreview.setStroke(Color.BLACK);
        ButtonColorPreview.setStrokeWidth(1);
        ButtonColorPreview.setFill(previewColor);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(0, 5, 0, 0));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(ButtonTextIcon, ButtonColorPreview);
        
        // Declaring the button
        ColorChooserButton colorButton = new ColorChooserButton(vbox);
        colorButton.SetColor(previewColor);
        colorButton.setTranslateX(50);
        colorButton.setTranslateY(50);
        
        // Adding Events
        colorButton.CustomColorPicker.ColorProperty.addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                // Write your code here if the color chnages...
                ButtonColorPreview.setFill(newValue);
            }
        });

        // Adding contents
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        root.getChildren().add(colorButton);
        
        primaryStage.setTitle("ColorChooserFX Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
