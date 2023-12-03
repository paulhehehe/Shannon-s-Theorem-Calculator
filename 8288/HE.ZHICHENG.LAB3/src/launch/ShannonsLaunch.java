/* Student Name:Zhicheng He
 * Student Number:041086226
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ShannonsTheorem;
import view.ShannonsPresenter;
import view.ShannonsView;

/**
 * Serves as the main class to launch the Shannon's Theorem JavaFX application.
 * This class bootstraps the application by setting up the model, view, and presenter components
 * and prepares the primary stage with the necessary scene.
 * 
 * The application facilitates the calculation of the maximum data rate as per Shannon's Theorem.
 * 
 * @version 1.0
 * @author Zhicheng He
 */
public class ShannonsLaunch extends Application {

    /**
     * Main method that serves as the entry point of the JavaFX application.
     *
     * @param args the command-line arguments passed to the application. Not used in this application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts and initializes the JavaFX application. This method is called after the system is ready
     * for the application to begin running.
     * 
     * Here, it initializes the model, view, and presenter components of the MVC architecture,
     * sets the scene for the primary stage, and shows the primary stage with a title.
     *
     * @param primaryStage The primary stage for this application, onto which the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        ShannonsTheorem model = new ShannonsTheorem(); // Initialize the model
        ShannonsView view = new ShannonsView(); // Initialize the view
        ShannonsPresenter presenter = new ShannonsPresenter(view, model); // Initialize the presenter

        Scene scene = new Scene(view, 500, 200); // Set the scene size

        primaryStage.setTitle("Shannon's Theorem Calculator"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
