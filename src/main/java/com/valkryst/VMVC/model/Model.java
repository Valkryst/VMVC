package com.valkryst.VMVC.model;

import com.valkryst.VMVC.controller.Controller;
import com.valkryst.VMVC.view.View;
import com.valkryst.VMVC.view.ViewInterface;

/**
 * A set of data that can be displayed by a {@link View}.
 *
 * @param <C> The type of {@link Controller} associated with this {@code Model}.
 * @param <V> The type of {@link View} associated with this {@code Model}.
 */
public abstract class Model<C extends Controller<?>, V extends ViewInterface> {
    /**
     * Constructs a {@link Controller} for the {@link View}.
     *
     * @return The {@link Controller}.
     */
    protected abstract C createController();

    /**
     * Constructs a {@link View} of this {@code Model}.
     *
     * @return The {@link View}.
     */
    public V createView() {
        return createView(createController());
    }

    /**
     * Constructs a {@link View} of this {@code Model}.
     *
     * @param controller A {@link Controller} for the {@link View}.
     * @return The {@link View}.
     */
    protected abstract V createView(final C controller);
}