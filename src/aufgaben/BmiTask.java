package aufgaben;


import engine.Task;
import io.Input;

import java.io.IOException;

public class BmiTask extends Task {

    double bodyWeight;
    double bodyHeight;
    int age;
    boolean sex;
    int step = 4;
    double targetBmi;
    int weightType = 0;

    public BmiTask() {
        setTitle("BMI Rechner");
        setDescription(
                "Die Anwendung gibt aus, in welchem Bereich sich der eigene BMI befindet.\n\b" +
                "Dazu werden verschiedene Werte abgefragt."
        );
    }

    public void init () throws IOException {
        printInfo();
        getInput();
    }

    public void getInput () throws IOException {

        while (true) {
            try {
                String input;
                switch (step) {
                    case 4:
                        System.out.println();
                        System.out.print("Wieviel kg wiegst du? ");
                        input = Input.console.readLine();
                        if(input.equals("exit")) exit();
                        bodyWeight = Integer.parseInt(input);
                        step--;
                        break;
                    case 3:
                        System.out.println();
                        System.out.print("Wieviel groß bist du in cm? ");
                        input = Input.console.readLine();
                        if(input.equals("exit")) exit();
                        bodyHeight = Integer.parseInt(input);
                        step--;
                        break;
                    case 2:
                        System.out.println();
                        System.out.print("Bist du eine Frau? (ja/nein): ");
                        input = Input.console.readLine();
                        if(input.equals("exit")) exit();
                        if(input.equals("ja")) sex = true;
                        step--;
                        break;
                    case 1:
                        System.out.println();
                        System.out.print("Wie alt bist du? ");
                        input = Input.console.readLine();
                        if(input.equals("exit")) exit();
                        age = Integer.parseInt(input);
                        step--;
                        break;
                    case 0:
                        System.out.println();
                        printBmi();
                        System.out.println();
                        System.out.print("nochmal? (ja/nein) ");
                        input = Input.console.readLine();
                        if(input.equals("nein")) {
                            exit();
                        } else {
                            step = 4;
                        }
                        break;
                }

            } catch (NumberFormatException exception) {
                System.out.println("Gewünschten Wert oder 'exit' eingeben.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void printBmi () {
        targetBmi = bodyWeight / Math.pow(bodyHeight/100,2);

        if(sex) targetBmi++;

        int lowerEnd = 19;
        int upperEnd = lowerEnd+5;
        int startAge = 25;
        boolean done = false;

        for(int i = startAge;i <65;i=i+10) {
            if(!done) {
                if (age < i) {
                    System.out.printf("Du bist jünger als %s.%n",i);
                    if (targetBmi < lowerEnd) weightType--;
                    if (targetBmi > upperEnd) weightType++;
                    done = true;
                }
                lowerEnd++;
                upperEnd++;
            }
        }

        System.out.printf("Dein BMI ist %s.%n",Math.round(targetBmi));
        String typ = "";
        switch (weightType) {
            case -1:
                typ = "untergewichtig";
                break;
            case 1:
                typ = "übergewichtig";
                break;
            default:
                typ = "im grünen Bereich";
                break;
        }
        System.out.printf("Du bist %s.%n",typ);
    }

}
