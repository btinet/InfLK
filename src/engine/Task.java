package engine;

import aufgaben.MainTask;
import java.io.IOException;
import java.util.Scanner;

public abstract class Task implements TaskInterface{

    protected String title;
    protected String description;
    protected Scanner scanner = new Scanner(System.in);

    public Task () {
    }

    public void printInfo () {
        System.out.println();
        System.out.printf("%S%n",getTitle());
        System.out.println(getDescription());
    }

    public String getTitle() {
        if(title == null) {
            title = "n/a";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        if(description == null) {
             description = "n/a";
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void exit() throws IOException {
        new MainTask();
    }
}
