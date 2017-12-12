package com.valkryst.VMVC;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.*;
import java.util.HashMap;

public class Settings implements Serializable {
    private static final long serialVersionUID = 0;

    /** The file path to the settings file. */
    @Getter @Setter private String filePath;

    /** The settings. */
    private HashMap<String, String> settings;

    /**
     * Constructs a new Settings.
     *
     * @param defaultSettings
     *          The default settings.
     *
     * @throws java.lang.NullPointerException
     *          If the defaultSettings is null.
     *
     * @throws java.io.IOException
     *          If an I/O error occurs.
     */
    public Settings(final @NonNull HashMap<String, String> defaultSettings) throws IOException {
        filePath = System.getProperty("user.dir") + "/Settings.ser";
        settings = defaultSettings;

        loadSettings();
        saveSettings();
    }

    /** Deserializes the settings, if the file exists. */
    private void loadSettings() {
        try (
            final FileInputStream fis = new FileInputStream(filePath);
            final ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            final Object object = ois.readObject();
            settings = (HashMap<String, String>) object;
        } catch (final IOException | ClassNotFoundException e) {
            // Delete the file:
            final File file = new File(filePath);

            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * Serializes the settings to a file.
     *
     * @throws java.io.IOException
     *          If an I/O error occurs.
     */
    public void saveSettings() throws IOException {
        if (settings.size() == 0) {
            // Delete the file:
            final File file = new File(filePath);

            if (file.exists()) {
                file.delete();
            }

            return;
        }


        final FileOutputStream fos = new FileOutputStream(filePath, false);
        final ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(settings);

        oos.close();
        fos.close();
    }

    /**
     * Retrieves a setting as a boolean.
     *
     * @param setting
     *         The setting.
     *
     * @return
     *         The value.
     *
     * @throws NumberFormatException
     *          If the setting string doesn't contain a parsable boolean.
     */
    public boolean getBooleanSetting(final @NonNull String setting) {
        return Boolean.valueOf(settings.get(setting));
    }

    /**
     * Retrieves a setting as a byte.
     *
     * @param setting
     *         The setting.
     *
     * @return
     *         The value.
     *
     * @throws NumberFormatException
     *          If the setting string doesn't contain a parsable byte.
     */
    public byte getByteSetting(final @NonNull String setting) {
        return Byte.valueOf(settings.get(setting));
    }

    /**
     * Retrieves a setting as a short.
     *
     * @param setting
     *         The setting.
     *
     * @return
     *         The value.
     *
     * @throws NumberFormatException
     *          If the setting string doesn't contain a parsable short.
     */
    public short getShortSetting(final @NonNull String setting) {
        return Short.valueOf(settings.get(setting));
    }

    /**
     * Retrieves a setting as a integer.
     *
     * @param setting
     *         The setting.
     *
     * @return
     *         The value.
     *
     * @throws NumberFormatException
     *          If the setting string doesn't contain a parsable integer.
     */
    public int getIntegerSetting(final @NonNull String setting) {
        return Integer.valueOf(settings.get(setting));
    }

    /**
     * Retrieves a setting as a long.
     *
     * @param setting
     *         The setting.
     *
     * @return
     *         The value.
     *
     * @throws NumberFormatException
     *          If the setting string doesn't contain a parsable long.
     */
    public long getLongSetting(final @NonNull String setting) {
        return Long.valueOf(settings.get(setting));
    }
    /**
     * Retrieves a setting as a float.
     *
     * @param setting
     *         The setting.
     *
     * @return
     *         The value.
     *
     * @throws NumberFormatException
     *          If the setting string doesn't contain a parsable float.
     */
    public float getFloatSetting(final @NonNull String setting) {
        return Float.valueOf(settings.get(setting));
    }
    /**
     * Retrieves a setting as a double.
     *
     * @param setting
     *         The setting.
     *
     * @return
     *         The value.
     *
     * @throws NumberFormatException
     *          If the setting string doesn't contain a parsable double.
     */
    public double getDoubleSetting(final @NonNull String setting) {
        return Double.valueOf(settings.get(setting));
    }

    /**
     * Retrieves a setting as a string.
     *
     * @param setting
     *         The setting.
     *
     * @return
     *         The value.
     */
    public String getStringSetting(final @NonNull String setting) {
        return settings.get(setting);
    }

    /**
     * Sets the value of a setting.
     *
     * @param setting
     *         The setting.
     *
     * @param value
     *         The value.
     */
    public void setSetting(final @NonNull String setting, final @NonNull Object value) {
        settings.put(setting, String.valueOf(value));
    }
}