/* Student Name:Zhicheng He
 * Student Number:041086226
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import model.ShannonsTheorem;

/**
 * Manages the interaction between the user interface (view) and the data model
 * (model) for Shannon's Theorem. This class binds model properties to view
 * components, handles user events, and manages data flow and validation.
 *
 * It listens for user inputs in the view, validates and processes these inputs,
 * and updates the model. Also, it reacts to model changes and updates the view
 * accordingly.
 *
 * @version 2.0
 * @author Zhicheng He
 */
public class ShannonsPresenter {

    /**
     * The associated view for Shannon's Theorem.
     */
    private final ShannonsView view;

    /**
     * The model for Shannon's Theorem.
     */
    private final ShannonsTheorem model;

    /**
     * Internal properties for bidirectional binding with the model. These
     * properties represent the bandwidth, signal power, noise power, and max
     * data rate.
     */
    private final SimpleDoubleProperty bwInternal = new SimpleDoubleProperty();
    /**
     * Internal properties for bidirectional binding with the model. These
     * properties represent the bandwidth, signal power, noise power, and max
     * data rate.
     */
    private final SimpleDoubleProperty spInternal = new SimpleDoubleProperty();
    /**
     * Internal properties for bidirectional binding with the model. These
     * properties represent the bandwidth, signal power, noise power, and max
     * data rate.
     */
    private final SimpleDoubleProperty npInternal = new SimpleDoubleProperty();

    /**
     * Constructs a new instance of the ShannonsPresenter.
     *
     * @param view The associated view for Shannon's Theorem.
     * @param model The model for Shannon's Theorem.
     */
    public ShannonsPresenter(ShannonsView view, ShannonsTheorem model) {
        this.view = view;
        this.model = model;
        bindToModel();
        attachViewEvents();
    }

    /**
     * Binds internal properties to model properties for bidirectional
     * communication.
     */
    private void bindToModel() {
        bwInternal.bindBidirectional(model.bandWidthProperty());
        spInternal.bindBidirectional(model.signalPowerProperty());
        npInternal.bindBidirectional(model.noisePowerProperty());
    }

    /**
     * Sets up event handlers for the view components.
     * Try parsing double type input
     */
    private void attachViewEvents() {
        view.bwFld.textProperty().bindBidirectional(bwInternal, new NumberStringConverter());
        view.spFld.textProperty().bindBidirectional(spInternal, new NumberStringConverter());
        view.npFld.textProperty().bindBidirectional(npInternal, new NumberStringConverter());

        // Event handler for the Calculate button
        view.calButton.setOnAction((ActionEvent clk) -> {
            try {
                // Parse input values from the view
                double bw = Double.parseDouble(view.bwFld.getText());
                double sp = Double.parseDouble(view.spFld.getText());
                double np = Double.parseDouble(view.npFld.getText());

                // Set the maxDataRateFld text with the calculated result
                view.maxDataRateFld.setText(String.valueOf(maxDataRate()));
            } catch (NumberFormatException e) {
                // Display an error alert for invalid input
                showError("Please enter valid numbers and not:");
            }
        });
    }

    /**
     * Retrieve the maximum data rate from the model.
     *
     * @return The maximum data rate.
     */
    private double maxDataRate() {
        return model.maxDataRate();
    }

    /**
     * Displays an error alert with the specified message.
     *
     * @param message The error message to be displayed.
     */
    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(message);

        // Create a VBox with labels displaying the invalid input values
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
                new Label(view.bwFld.getText()),
                new Label(view.spFld.getText()),
                new Label(view.npFld.getText())
        );

        // Set the VBox as the content of the alert
        alert.getDialogPane().setContent(vbox);
        alert.showAndWait();
    }
}
