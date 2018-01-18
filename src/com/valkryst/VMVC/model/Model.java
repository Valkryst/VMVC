package com.valkryst.VMVC.model;

import lombok.NonNull;

import java.io.*;

public class Model {
    /**
     * Deserializes an object from a file, if the file exists.
     *
     * If the file causes an exception, then the file is deleted.
     *
     * @param filePath
     *          The path to the file.
     *
     * @return
     *          The deserialized object.
     *
     * @throws NullPointerException
     *          If the filePath is null.
     *
     * @throws IOException
     *          If an IO error occurs.
     *
     * @throws ClassNotFoundException
     *          If the class of the serialized object cannot be found.
     */
    public static Object deserializeObject(final @NonNull String filePath) throws IOException, ClassNotFoundException {
        final FileInputStream fis = new FileInputStream(filePath);
        final ObjectInputStream ois = new ObjectInputStream(fis);

        final Object object = ois.readObject();

        ois.close();
        fis.close();

        return object;
    }

    /**
     * Serializes an object to a file. Overwrites the file if it already exists.
     *
     * @param filePath
     *          The path to the file.
     *
     * @param object
     *          The object to serialize.
     *
     * @throws NullPointerException
     *          If the filePath is null.
     *
     * @throws IllegalArgumentException
     *          If the object doesn't implement Serializable.
     *
     * @throws IOException
     *          If an IO error occurs.
     */
    public static void serializeObject(final @NonNull String filePath, final @NonNull Object object) throws IOException, IllegalArgumentException {
        if (object instanceof Serializable == false) {
            throw new IllegalArgumentException("The specified object does not implement Serializable.");
        }

        final FileOutputStream fos = new FileOutputStream(filePath, false);
        final ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(object);

        oos.close();
        fos.close();
    }
}
