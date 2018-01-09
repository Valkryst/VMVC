package com.valkryst.VMVC;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lombok.NonNull;

public class AlertManager {
    /**
     * Creates and shows an information alert, then waits for the user
     * response.
     *
     * @param message
     *          The alert message.
     *
     * @throws NullPointerException
     *          If the message is null.
     */
    public static void showInformationAndWait(final @NonNull String message) {
        showAlert(Alert.AlertType.INFORMATION, message);
    }

    /**
     * Creates and shows a warning alert, then waits for the user response.
     *
     * @param message
     *          The alert message.
     *
     * @throws NullPointerException
     *          If the message is null.
     */
    public static void showWarningAndWait(final @NonNull String message) {
        showAlert(Alert.AlertType.WARNING, message);
    }

    /**
     * Creates and shows a error alert, then waits for the user response.
     *
     * @param message
     *          The alert message.
     *
     * @throws NullPointerException
     *          If the message is null.
     */
    public static void showErrorAndWait(final @NonNull String message) {
        showAlert(Alert.AlertType.ERROR, message);
    }

    /**
     * Creates and shows the dialog and waits for the user response (in
     * other words, brings up a blocking dialog, with the returned value
     * the users input).
     *
     * @param type
     *          The alert type.
     *
     * @param message
     *          The alert message.
     *
     * @throws NullPointerException
     *          If the type or message is null.
     */
    private static void showAlert(final @NonNull Alert.AlertType type, final @NonNull String message) {
        final Alert alert = new Alert(type, message, ButtonType.OK);
        alert.showAndWait();
    }
}
