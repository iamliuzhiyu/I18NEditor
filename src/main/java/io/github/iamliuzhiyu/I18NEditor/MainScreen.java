package io.github.iamliuzhiyu.I18NEditor;

import com.google.gson.reflect.TypeToken;
import com.google.gson.*;
import io.github.iamliuzhiyu.I18NEditor.parsters.Property;

import javax.swing.*;
import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MainScreen extends JFrame {
    public void WinMain() throws IOException, NoClassDefFoundError {
        Gson gson = new Gson();
        Property property = new Property("settings.properties");
        ResourceBundle langBundle = ResourceBundle.getBundle("lang", Locale.getDefault());
        if (!property.get("language").equals(Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry().toLowerCase())) {
            String[] split = property.get("language").split("_");
            langBundle = ResourceBundle.getBundle("lang", new Locale(split[0], split[1]));
        }
        ArrayList<Project> projects = gson.fromJson(new FileReader("projects.json", StandardCharsets.UTF_8), new TypeToken<ArrayList<Project>>() {}.getType());
        Object[] projectsArray = projects.toArray();
        this.setTitle(Utils.TITLE);
        this.setLayout(new GridLayout(1,2));
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        JPanel projectPanel = new JPanel();
        projectPanel.setLayout(new GridLayout(2,1));
        JLabel projectsLabel = new JLabel(langBundle.getString("JLabel.MainScreen.projectsLabel"));
        JList projectsList = new JList(projectsArray);
        projectPanel.add(projectsLabel);
        projectPanel.add(projectsList);
        this.pack();
    }

    public void ErrorProcess() {
        try {
            this.WinMain();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(this, e.getStackTrace(), "An error happened!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        MainScreen self = new MainScreen();
        self.ErrorProcess();
    }
}
