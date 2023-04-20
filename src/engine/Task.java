package engine;

import aufgaben.MainTask;
import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Task implements TaskInterface{

    protected String description;

    public Task () {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void exit() throws IOException {
        new MainTask();
    }
}
