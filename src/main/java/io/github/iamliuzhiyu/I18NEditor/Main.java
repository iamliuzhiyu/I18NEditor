package io.github.iamliuzhiyu.I18NEditor;

import io.github.iamliuzhiyu.I18NEditor.parster.Property;

import javax.swing.*;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        Property property = new Property("settings.properties");
        ResourceBundle langBundle = ResourceBundle.getBundle("lang", Locale.getDefault());
        try {
            if (!property.get("language").equals(Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry().toLowerCase())) {
                String[] split = property.get("language").split("_");
                langBundle = ResourceBundle.getBundle("lang", new Locale(split[0], split[1]));
            }
            frame.setLayout(null);

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(frame, e.getStackTrace(), langBundle.getString("JOptionPane.Error.ErrorHappened"), JOptionPane.ERROR_MESSAGE);
        }
    }
}
