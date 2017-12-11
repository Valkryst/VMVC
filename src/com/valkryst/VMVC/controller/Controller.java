package com.valkryst.VMVC.controller;

import com.valkryst.VMVC.model.Model;
import com.valkryst.VMVC.view.View;
import lombok.Getter;

import java.sql.Driver;
import java.util.Objects;

public class Controller<M extends Model, V extends View> {
    /** The driver. */
    @Getter private final Driver driver;

    /** The model. */
    final M model;
    /** The view. */
    @Getter protected final V view;

    /**
     * Constructs a new Controller.
     *
     * @param driver
     *          The driver.
     *
     * @param model
     *          The model.
     *
     * @param view
     *          The view.
     *
     * @throws java.lang.NullPointerException
     *          If the driver, model, or view are null.
     */
    public Controller(final Driver driver, final M model, final V view) {
        Objects.requireNonNull(driver);
        Objects.requireNonNull(model);
        Objects.requireNonNull(view);

        this.driver = driver;
        this.model = model;
        this.view = view;
    }
}

