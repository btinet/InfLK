package aufgaben;


import engine.Task;
import io.Input;

import java.io.IOException;
import java.util.ArrayList;

public class SummenTask extends Task {

    ArrayList<Integer> intervallGrenzen;
    ArrayList<String> bezeichner = new ArrayList<>();

    public SummenTask() {
        setTitle("Summenformel-Rechner");
        setDescription(
                "Berechne die Summe im Intervall I [a,b]."
        );
    }

    public void init () throws IOException {
        bezeichner.add(0,"a: ");
        bezeichner.add(1,"b: ");
        printInfo();
        getInput();
    }

    public void getInput () throws IOException {

        while (true) {
            try {
                System.out.println();
                intervallGrenzen = new ArrayList<>();
                for (int i = 0; i <2 ; i++) {
                    System.out.print(bezeichner.get(i));
                    String input = scanner.next();
                    if(input.equals("exit")) {
                        exit();
                    } else {
                        intervallGrenzen.add(i,Integer.parseInt(input));
                    }
                }
                calculateSum(intervallGrenzen.get(0),intervallGrenzen.get(1));
            } catch (NumberFormatException exception) {
                System.out.println("Intervallgrenze oder 'exit' eingeben.");
            }
        }
    }

    protected void calculateSum (int lowLimit, int highLimit) {
        int sum = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            sum = sum+i;
        }
        System.out.printf("Die Summe im Intervall I[%s,%s] beträgt %s. %n",lowLimit,highLimit,sum);
    }

}
