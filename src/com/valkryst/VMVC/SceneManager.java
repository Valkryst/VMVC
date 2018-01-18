package com.valkryst.VMVC;

import com.valkryst.VMVC.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

public class SceneManager {
    /** The primary stage. */
    @Getter private Stage primaryStage;

    /** The previous scene's controller. */
    @Getter private Controller previousController;
    /** The current scene's controller. */
    @Getter private Controller currentController;

    /** The previous scene. */
    private Scene previousScene;
    /** The current scene. */
    private Scene currentScene;

    /**
     * Constructs a new SceneManager.
     *
     * @param primaryStage
     *          The primary stage.
     */
    public SceneManager(final @NonNull Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Sets the initial pane.
     *
     * @param controller
     *          The controller of the initial pane.
     */
    public void setInitialPane(final @NonNull Controller controller) {
        previousController = controller;
        currentController = controller;

        final Scene scene = new Scene(controller.getView().getPane());
        scene.getStylesheets().add("global.css");
        scene.getRoot().getStyleClass().add("main-root");

        previousScene = scene;
        currentScene = scene;

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Swaps the current scene with a new scene, so that the new scene
     * is displayed.
     *
     * @param controller
     *          The controller of the new scene.
     *
     * @throws java.lang.NullPointerException
     *           If the controller is null/
     */
    public void swapToNewScene(final Controller controller) {
        Objects.requireNonNull(controller);

        previousController = currentController;
        currentController = controller;

        previousScene = currentScene;
        currentScene = new Scene(controller.getView().getPane());

        // Set new scene's pane to be the same size as the previous
        // pane's scene.
        final Pane previousPane = previousController.getView().getPane();
        final Pane currentPane = currentController.getView().getPane();

        currentPane.setPrefSize(previousPane.getWidth(), previousPane.getHeight());

        addStylesheet(currentScene);
        primaryStage.setScene(currentScene);
    }

    /**
     * Swaps the current and previous scenes, so that the previous scene
     * is displayed.
     */
    public void swapToPreviousScene() {
        final Controller tempC = previousController;
        previousController = currentController;
        currentController = tempC;

        final Scene tempS = previousScene;
        previousScene = currentScene;
        currentScene = tempS;

        // Set new scene's pane to be the same size as the previous
        // pane's scene.
        final Pane previousPane = previousController.getView().getPane();
        final Pane currentPane = currentController.getView().getPane();

        currentPane.setPrefSize(previousPane.getWidth(), previousPane.getHeight());

        primaryStage.setScene(currentScene);
    }

    /**
     * Adds the global stylesheet to a scene.
     *
     * @param scene
     *          The scene.
     */
    private void addStylesheet(final Scene scene) {
        if (scene == null) {
            return;
        }

        if (scene.getStylesheets().size() == 0) {
            scene.getStylesheets().add("global.css");
            scene.getRoot().getStyleClass().add("main-root");
        }
    }
}
