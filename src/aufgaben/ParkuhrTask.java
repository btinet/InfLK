package aufgaben;


import engine.DoubleFormatter;
import engine.Task;
import io.Input;

import java.io.IOException;

public class ParkuhrTask extends Task {

    int duration;

    double amount;

    public ParkuhrTask() {
        setTitle("Parkhausautomat");
        setDescription(
                "Die Anwendung berechnet die Parkgebühr in Abhängigkeit der Parkdauer.\n\b" +
                "Die Angaben erfolgen in Minuten."
        );
    }

    public void init () throws IOException {
        printInfo();
        getInput();
    }

    public void getInput () throws IOException {

        while (true) {
            try {
                System.out.println();
                System.out.print("Wie lange haben Sie geparkt (in Minuten): ");
                String input = Input.console.readLine();
                if(input.equals("exit")) {
                    break;
                } else {
                    duration = Integer.parseInt(input);
                    printRabatt();
                }
            } catch (NumberFormatException exception) {
                System.out.println("Ganze Zahl oder 'exit' eingeben.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        exit();
    }

    protected void printRabatt () {
        if(duration <= 90) {
            amount = 3;
        } else if (duration < 60 * 24) {
            amount = 10;
        } else {
            amount = 200;
        }
        System.out.printf("Die Parkgebühr beträgt %s.%n", DoubleFormatter.getFormattedString(amount,"##.00 €"));
    }

}
