package com.valkryst.VMVC.controller;

import com.valkryst.VMVC.SceneManager;
import com.valkryst.VMVC.Settings;
import com.valkryst.VMVC.model.Model;
import com.valkryst.VMVC.view.View;
import lombok.Getter;
import lombok.NonNull;

public class Controller<M extends Model, V extends View> {
    /** The scene manager. */
    protected final SceneManager sceneManager;
    /** The settings. */
    protected final Settings settings;

    /** The model. */
    protected final M model;
    /** The view. */
    @Getter protected final V view;

    /**
     * Constructs a new Controller.
     *
     * @param sceneManager
     *          The scene manager.
     *
     * @param settings
     *          The settings.
     *
     * @param model
     *          The model.
     *
     * @param view
     *          The view.
     *
     * @throws java.lang.NullPointerException
     *          If the any of the params are null.
     */
    public Controller(final @NonNull SceneManager sceneManager, final @NonNull Settings settings, final @NonNull M model, final @NonNull V view) {
        this.sceneManager = sceneManager;
        this.settings = settings;
        this.model = model;
        this.view = view;
    }
}

