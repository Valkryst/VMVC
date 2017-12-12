package com.valkryst.VMVC.view;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import lombok.Getter;

import java.util.Objects;

public class View {
    /** The pane of the view. */
    @Getter protected Pane pane;

    /**
     * Sets the tooltip of a JavaFX control.
     *
     * @param control
     *          The control.
     *
     * @param message
     *          The message.
     *
     * @throws java.lang.NullPointerException
     *           If the control or message is null.
     *
     * @throws java.lang.IllegalArgumentException
     *           If the message is empty.
     */
    protected static void setTooltip(final Control control, final String message) {
        Objects.requireNonNull(control);
        Objects.requireNonNull(message);

        if (message.isEmpty()) {
            throw new IllegalArgumentException("The message cannot be empty.");
        }

        control.setTooltip(new Tooltip(message));
    }

    /**
     * Creates a button control with an icon on it.
     *
     * @param iconPath
     *          The path to the icon.
     *
     * @param width
     *          The width to resize the icon to.
     *
     * @param height
     *          The height to resize the icon to.
     *
     * @throws java.lang.NullPointerException
     *           If the iconPath is null.
     *
     * @throws java.lang.IllegalArgumentException
     *           If the iconPath is empty.
     */
    protected static Button createIconButton(final String iconPath, final int width, final int height) {
        Objects.requireNonNull(iconPath);

        if (iconPath.isEmpty()) {
            throw new IllegalArgumentException("The icon path cannot be empty.");
        }

        final Button button = new Button();
        final Image image = new Image(iconPath, (double) width, (double) height, true, true);
        button.setGraphic(new ImageView(image));
        return button;
    }

    /**
     * Creates a GridPane with only one row, but where there are as many
     * equal sized columns as there are controls passed to the function.
     *
     * Ex:
     *      If you pass in two controls, then there will be one row with
     *      two columns where each column uses 50% of the width.
     *
     * Ex:
     *      If you pass in four controls, then there will be one row with
     *      four columns where each column uses 25% of the width.
     *
     * @param controls
     *          The controls.
     *
     * @return
     *          The pane.
     */
    protected static GridPane createHorizontalGridPane(final Control... controls) {
        if (controls.length == 0) {
            return new GridPane();
        }

        final GridPane pane = new GridPane();
        final double sectionWidth = 100 / controls.length;

        for (final Control ignored : controls) {
            final ColumnConstraints constraints = new ColumnConstraints();
            constraints.setPercentWidth(sectionWidth);

            pane.getColumnConstraints().add(constraints);
        }

        for (int i = 0 ; i < controls.length ; i++) {
            pane.add(controls[i], i, 0);
        }

        return pane;
    }

    /**
     * Creates a GridPane with only one column, but where there are as
     * many rows as there are controls passe to the function.
     *
     * Ex:
     *      If you pass in two controls, then there will be one column with
     *      two rows where each row uses 50% of the height.
     *
     * Ex:
     *      If you pass in four controls, then there will be one column with
     *      four rows where each row uses 25% of the height.
     *
     * @param controls
     *          The controls.
     *
     * @return
     *          The pane.
     */
    protected static GridPane createVerticalGridPane(final Control... controls) {
        if (controls.length == 0) {
            return new GridPane();
        }

        final GridPane pane = new GridPane();
        final double sectionHeight = 100 / controls.length;

        for (final Control ignored : controls) {
            final RowConstraints constraints = new RowConstraints();
            constraints.setPercentHeight(sectionHeight);

            pane.getRowConstraints().add(constraints);
        }

        for (int i = 0 ; i < controls.length ; i++) {
            pane.add(controls[i], 0, i);
        }

        return pane;
    }
}

