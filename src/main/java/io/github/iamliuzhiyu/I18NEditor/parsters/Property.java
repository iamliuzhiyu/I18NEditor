package io.github.iamliuzhiyu.I18NEditor.parsters;


import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * PropertiesFile
 *
 * @version 1.0-RELEASE
 * @author iamliuzhiyu
 */
public class Property {

    /**
     * Variable to save the Properties tool object.
     * @since 1.0
     */
    private Properties prop;

    /**
     * Target file path.
     * @since 1.0
     */
    private File path;

    /**
     * Target file encoding
     * @see Charset
     * @since 1.0
     */
    private Charset charset;

    private void init(String path, Charset charset) throws IOException {
        this.path = new File(path);
        this.charset = charset;

        this.prop = new java.util.Properties();
        this.prop.load(new FileReader(this.path, this.charset));
    }

    /**
     * Initialization
     * @param path Target file path.
     * @param charset Target file encoding
     *                @see Charset
     * @throws IOException
     */
    public Property(String path, Charset charset) throws IOException {
        init(path, charset);
    }

    /**
     * Initialization
     * @param path Target file path.
     * @throws IOException
     */
    public Property(String path) throws IOException {
        init(path, StandardCharsets.UTF_8);
    }

    /**
     * Value getter.
     *
     * @param key Key of the value.
     * @return The value.
     */
    public String get(String key) {
        return this.prop.getProperty(key);
    }

    /**
     * Value setter
     * @param key Key.
     * @param value Value.
     */
    public void set(String key, String value) {
        this.prop.setProperty(key, value);
    }

    /**
     * Save the file.
     *
     * @param description It will append to the file after saving.
     * @return
     */
    public boolean save(String description) {
        try {
            this.prop.store(new FileWriter(this.path, this.charset), description);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public boolean save() {
        return this.save("");
    }
}

