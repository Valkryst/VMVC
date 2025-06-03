package com.valkryst.VMVC.view;

import com.valkryst.VMVC.controller.Controller;
import com.valkryst.VMVC.model.Model;

import javax.swing.*;
import java.util.Objects;

/**
 * A visual representation of a {@link Model}, displayed by a {@link JPanel}.
 *
 * @param <C> The type of {@link Controller} associated with this {@code View}.
 */
public abstract class View<C extends Controller<?>> extends JPanel implements ViewInterface{
    /** The {@link Controller} associated with this {@code View}. */
    protected final C controller;

    /**
     * Constructs a new {@code View}.
     *
     * @param controller The {@link Controller} associated with this view.
     * @throws NullPointerException If the {@link Controller} is {@code null}.
     */
    public View(final C controller) {
        Objects.requireNonNull(controller);
        this.controller = controller;
    }
}