package aufgaben;


import engine.Task;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DiceTask extends Task {

    int tipp;
    int startGuthaben = 5;
    int aktuellesGuthaben = -1;

    public DiceTask() {
        setTitle("Würfelspiel");
        setDescription(
                "Du hast ein Guthaben von "+startGuthaben+"€. Tippe eine Zahl. Der Computer würfelt dreimal.\n\b" +
                "1 Treffer: 1€, 2 Treffer: 2€, 3 Treffer: 5€. Andernfalls verlierst du 1€!"
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
                System.out.print("Dein Tipp: ");
                String input = scanner.next();
                if(input.equals("exit")) {
                    break;
                } else if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 6){
                    tipp = Integer.parseInt(input);
                    rollDice();
                } else {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException exception) {
                System.out.println("Zahl zwischen 1 und 6 oder 'exit' eingeben.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        exit();
    }

    protected void rollDice () throws IOException {

        int treffer = 0;
        if(aktuellesGuthaben == -1) { // Beim ersten Start ist das Guthaben auf -1 gesetzt.
            aktuellesGuthaben = startGuthaben; // Startguthaben ist 5€.
        } else if(aktuellesGuthaben == 0) {
            System.out.println("Du hast kein Guthaben mehr. Bis zum nächsten Mal!");
            exit();
        }

        for (int i = 1; i <= 3; i++) {
            int currentDiceRoll = ThreadLocalRandom.current().nextInt(1,6 + 1);

            String augenZahl = "Augen";
            if(currentDiceRoll == 1)augenZahl = "Auge";

            if(tipp == currentDiceRoll) {
                treffer++;

                System.out.printf("Wurf %s ergibt: %s %s. Du triffst!%n",i,currentDiceRoll,augenZahl);
            } else {
                System.out.printf("Wurf %s ergibt: %s %s. Leider daneben!%n",i,currentDiceRoll,augenZahl);
            }
        }

        switch (treffer) {
            case 1:
                aktuellesGuthaben = aktuellesGuthaben + 1;
                System.out.printf("Gut gemacht! Du gewinnst 1€. Du hast nun: %s€.%n",aktuellesGuthaben);
                break;
            case 2:
                aktuellesGuthaben = aktuellesGuthaben + 2;
                System.out.printf("Gut gemacht! Du gewinnst 2€. Du hast nun: %s€.%n",aktuellesGuthaben);
                break;
            case 3:
                aktuellesGuthaben = aktuellesGuthaben + 5;
                System.out.printf("Gut gemacht! Du gewinnst 5€. Du hast nun: %s€.%n",aktuellesGuthaben);
                break;
            default:
                aktuellesGuthaben--;
                System.out.printf("Oh nein! Du verlierst 1€. Du hast nun: %s€.%n",aktuellesGuthaben);
                break;
        }

    }

}
