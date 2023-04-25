package aufgaben;

import engine.Task;
import io.Input;
import javafx.application.Platform;

import java.io.IOException;
import java.util.ArrayList;

public class MainTask extends Task {

    protected Task currentTask;
    int operation;

    ArrayList<Task> tasks = new ArrayList<Task>();

    public MainTask () throws IOException {
        addTask(new RabattTask());
        addTask(new BmiTask());
        addTask(new ParkuhrTask());
        addTask(new DiceTask());
        init();
    }

    @Override
    public void init() throws IOException {
        getInput();
    }

    public void addTask (Task task) {
        tasks.add(task);
    }

    public void getInput() throws IOException {
        while (true) {
            System.out.println("Verfügbare Anwendungen:");
            System.out.println("-----------------------");
            int i = 1;
            for (Task task : tasks) {
                System.out.printf("%s: %S%n",i,task.getTitle());
                i++;
            }
            try {
                System.out.println();
                System.out.print("Auswahl: ");
                String input = Input.console.readLine();
                if(input.equals("exit")) {
                    break;
                } else {
                    operation = Integer.parseInt(input);
                }

            } catch (NumberFormatException exception) {
                System.out.println("Eingabe konnte nicht zugeordnet werden. Bitte Ziffer oder 'exit' eingeben.");
            }

            try {
                currentTask = tasks.get(operation-1);
                currentTask.init();
                break;
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Dieser Eintrag ist nicht vorhanden.");
                System.out.println();
            }
        }
        System.out.println("Tschüss!");
        Platform.exit();
        System.exit(0);
    }

}
