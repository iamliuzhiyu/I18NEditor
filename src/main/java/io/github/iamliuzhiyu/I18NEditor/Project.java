package io.github.iamliuzhiyu.I18NEditor;

import java.io.File;

public class Project {
    String name;
    File path;
    String id;

    public Project(String name, File path, String id) {
        this.name = name;
        this.path = path;
        this.id = id;
    }

    public Project(String name, File path) {
        this(name, path, name.toLowerCase());
    }

    public Project(String name, String path, String id) {
        this(name, new File(path), id);
    }

    public Project(String name, String path) {
        this(name, new File(path), name.toLowerCase());
    }
}
