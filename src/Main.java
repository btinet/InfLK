import aufgaben.RabattTask;
import engine.Task;
import io.Input;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    protected Task currentTask;
    int operation;

    ArrayList<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main () throws IOException {
        // Aufgaben hinzufügen
        addTask(new RabattTask());

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
                System.out.printf("%s: %S%n",i,task.getDescription());
            }
            try {
                System.out.println();
                System.out.print("Auswahl: ");
                operation = Integer.parseInt(Input.console.readLine());

            } catch (NumberFormatException exception) {
                System.out.println("Eingabe konnte nicht zugeordnet werden.");
            }

            try {
                currentTask = tasks.get(operation-1);
                break;
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Dieser Eintrag ist nicht vorhanden.");
            }
        }
        currentTask.init();
    }

}