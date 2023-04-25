package aufgaben;


import engine.Task;
import io.Input;

import java.io.IOException;

public class SummenTask extends Task {

    int kNr;
    double rabattsatz;

    public SummenTask() {
        setTitle("Summenformel-Rechner");
        setDescription(
                "Die Anwendung gibt je nach Kundennummer einen anderen Rabattsatz aus.\n\b" +
                "Versuche es mit Werten > 5000, Werten < 3000 und auch Werten dazwischen."
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
                System.out.print("Kundennummer eingeben: ");
                String input = Input.console.readLine();
                if(input.equals("exit")) {
                    break;
                } else {
                    kNr = Integer.parseInt(input);
                    printRabatt();
                }
            } catch (NumberFormatException exception) {
                System.out.println("Kundennummer oder 'exit' eingeben.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        exit();
    }

    protected void printRabatt () {
        if(kNr > 5000) {
            rabattsatz = 0.1;
        } else if (kNr >= 3000) {
            rabattsatz = 0;
        } else {
            rabattsatz = 0.12;
        }
        System.out.printf("Rabatt beträgt %s Prozent. %n",rabattsatz*100);
    }

}
