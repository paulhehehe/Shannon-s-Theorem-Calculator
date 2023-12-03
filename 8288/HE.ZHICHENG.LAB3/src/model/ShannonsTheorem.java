/* Student Name:Zhicheng He
 * Student Number:041086226
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Represents the mathematical model for calculating the maximum data rate
 * according to Shannon's Theorem. This model utilizes JavaFX properties to
 * enable automatic updates in the UI whenever the property values change.
 *
 * @version 2.0
 * @author Zhicheng He
 */

public class ShannonsTheorem {

    /**
     * The bandwidth property for Shannon's Theorem.
     */
    private final DoubleProperty bandWidth = new SimpleDoubleProperty(this, "bandWidth", 0.0);
    /**
     * The signal power property for Shannon's Theorem.
     */
    private final DoubleProperty signalPower = new SimpleDoubleProperty(this, "signalPower", 0.0);
    /**
     * The noise power property for Shannon's Theorem.
     */
    private final DoubleProperty noisePower = new SimpleDoubleProperty(this, "noisePower", 0.0);

     /**
     * Parameterized constructor that initializes the properties with provided values.
     *
     * @param bandWidth   The bandwidth in hertz (Hz).
     * @param signalPower The signal power in watts (W).
     * @param noisePower  The noise power in watts (W).
     */
    public ShannonsTheorem(double bandWidth, double signalPower, double noisePower) {
        this.bandWidth.set(bandWidth);
        this.signalPower.set(signalPower);
        this.noisePower.set(noisePower);
    }

    /**
     * Constructs a new instance of ShannonsTheorem with default values (0.0
     * bandwidth, 0.0 signal power, 0.0 noise power). Binds the max data rate
     * property to ensure automatic updates.
     */
    public ShannonsTheorem() {
        this(0.0, 0.0, 0.0);
    }

    /**
     * Gets the bandwidth property value.
     *
     * @return The bandwidth property value.
     */
    public final double getBandWidth() {
        return bandWidth.get();
    }

    /**
     * Sets the bandwidth property value.
     *
     * @param bandWidth The new bandwidth value.
     */
    public final void setBandWidth(double bandWidth) {
        bandWidthProperty().set(bandWidth);
    }

    /**
     * Gets the bandwidth property.
     *
     * @return The bandwidth property.
     */
    public final DoubleProperty bandWidthProperty() {
        return bandWidth;
    }

    /**
     * Gets the signal power property value.
     *
     * @return The signal power property value.
     */
    public final double getSignalPower() {
        return signalPower.get();
    }

    /**
     * Sets the signal power property value.
     *
     * @param signalPower The new signal power value.
     */
    public final void setSignalPower(double signalPower) {
        signalPowerProperty().set(signalPower);
    }

    /**
     * Gets the signal power property.
     *
     * @return The signal power property.
     */
    public final DoubleProperty signalPowerProperty() {
        return signalPower;
    }

    /**
     * Gets the noise power property value.
     *
     * @return The noise power property value.
     */
    public final double getNoisePower() {
        return noisePower.get();
    }

    /**
     * Sets the noise power property value.
     *
     * @param noisePower The new noise power value.
     */
    public final void setNoisePower(double noisePower) {
        noisePowerProperty().set(noisePower);
    }

    /**
     * Gets the noise power property.
     *
     * @return The noise power property.
     */
    public final DoubleProperty noisePowerProperty() {
        return noisePower;
    }

    /**
     * Private helper method to calculate the base-2 logarithm.
     *
     * @param x The input value.
     * @return The base-2 logarithm of the input value.
     */
    private double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    /**
     * Calculates the maximum data rate using Shannon's Theorem formula.
     *
     * @param bw The bandwidth value.
     * @param sp The signal power value.
     * @param np The noise power value.
     * @return The calculated maximum data rate.
     */
    public double maxDataRate(double bw, double sp, double np) {
        return bw * log2(1 + sp / np);
    }

    /**
     * Call and send arguments to the real method which does the calculation.
     *
     * @return The calculated result.
     */
    public double maxDataRate() {
        return maxDataRate(bandWidth.get(), signalPower.get(), noisePower.get());
    }

    /**
     * Returns a string representation of the Shannon's Theorem object.
     *
     * @return A string containing information about the bandwidth, signal
     * power, and noise power.
     */
    @Override
    public String toString() {
        return "ShannonsTheory [bandWidth=" + bandWidth.get() + ", signalPower=" + signalPower.get()
                + ", noisePower=" + noisePower.get() + "]";
    }
}
