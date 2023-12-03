/* Student Name:Zhicheng He
 * Student Number:041086226
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Provides the graphical user interface (GUI) for Shannon's Theorem application.
 * This class, extending GridPane, arranges UI elements for user interaction.
 *
 * The interface includes labels and text fields for entering bandwidth, signal power,
 * and noise power. It features a 'Calculate' button to initiate the calculation
 * and a non-editable text field to display the maximum data rate.
 *
 * The design emphasizes usability and clarity with a visually distinct field
 * for displaying results and a well-structured layout for easy interaction.
 * 
 * @version 1.0
 * @author Zhicheng He
 */
public class ShannonsView extends GridPane {
    
    // Labels
    Label bwLabel = new Label("Bandwidth (in Hertz or Hz):");
    Label spLabel = new Label("Signal Power (in watts):");
    Label npLabel = new Label("Noise Power (in watts):");
    Label maxDataRateLabel = new Label("Max Data Rate");
    
    // TextFields
    TextField bwFld = new TextField();
    TextField spFld = new TextField();
    TextField npFld = new TextField();
    TextField maxDataRateFld = new TextField();

    // Calculate button
    Button calButton = new Button("Calculate");
    
    /**
     * Constructs a new instance of ShannonsView and sets up the user interface.
     */
    public ShannonsView() {
        layoutForm();
    }
    
    /**
     * Sets up the layout of the user interface components.
     * Configures styles, backgrounds, and alignments for a cohesive design.
     */
    private void layoutForm() {
        // Set Max Data Rate field as non-editable with a light gray background
        maxDataRateFld.setEditable(false);
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        maxDataRateFld.setBackground(background);
        
        // Set grid properties
        this.setHgap(5);
        this.setVgap(5);
        
        // Add labels to the grid
        this.add(bwLabel, 1, 2);
        this.add(spLabel, 1, 3);
        this.add(npLabel, 1, 4);
        this.add(maxDataRateLabel, 1, 5);
        
        // Add text fields to the grid
        this.add(bwFld, 2, 2);
        this.add(spFld, 2, 3);
        this.add(npFld, 2, 4);
        this.add(maxDataRateFld, 2, 5);
        
        // Create a VBox for the Calculate button, center it vertically
        VBox buttonBox = new VBox(calButton);
        buttonBox.setAlignment(Pos.CENTER);
        calButton.setMaxWidth(Double.MAX_VALUE);
        
        // Add the VBox with the button to the grid
        this.add(buttonBox, 3, 1, 1, 5);
    }
}
