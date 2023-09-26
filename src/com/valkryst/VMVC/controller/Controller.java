package com.valkryst.VMVC.controller;

import com.valkryst.VMVC.model.Model;

import java.util.Objects;

/**
 * A {@code Controller} for a {@link Model}.
 *
 * @param <M> The type of {@link Model} associated with the {@code Controller}.
 */
public abstract class Controller<M extends Model<?, ?>> {
    /** The {@link Model} associated with this {@code Controller}. */
    final M model;

    /**
     * Constructs a new {@code Controller}.
     *
     * @param model The {@link Model} associated with this {@code Controller}.
     * @throws NullPointerException If the {@link Model} is {@code null}.
     */
    public Controller(final M model) {
        Objects.requireNonNull(model);
        this.model = model;
    }
}