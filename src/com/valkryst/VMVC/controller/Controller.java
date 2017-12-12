package com.valkryst.VMVC.controller;

import com.valkryst.VMVC.Application;
import com.valkryst.VMVC.model.Model;
import com.valkryst.VMVC.view.View;
import lombok.Getter;

import java.util.Objects;

public class Controller<M extends Model, V extends View> {
    /** The driver. */
    @Getter private final Application application;

    /** The model. */
    protected final M model;
    /** The view. */
    @Getter protected final V view;

    /**
     * Constructs a new Controller.
     *
     * @param application
     *          The application.
     *
     * @param model
     *          The model.
     *
     * @param view
     *          The view.
     *
     * @throws java.lang.NullPointerException
     *          If the application, model, or view are null.
     */
    public Controller(final Application application, final M model, final V view) {
        Objects.requireNonNull(application);
        Objects.requireNonNull(model);
        Objects.requireNonNull(view);

        this.application = application;
        this.model = model;
        this.view = view;
    }
}

