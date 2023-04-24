package snippets;

public class ForSnippet {

    public void  calculateBmi () {

        // Persönliche Angaben
        int age = 37; // ALter
        double targetBmi = 25; // errechneter BMI-Wert

        // BMI-Rubriken
        int lowerEnd = 19;  // untere BMI-Grenze
        int upperEnd = lowerEnd+5;  // obere BMI-Grenze
        int startAge = 25;  // startWert der ersten Altersgrenze
        int weightType = 0; // Gewichtskategorie (-1: untergewichtig; 0: normal; 1: übergewichtig)

        // Prozess-Status (fertig: ja/nein)
        boolean done = false;

        // Für unter 65-Jährige
        for(int i = startAge;i < 65;i=i+10) {
            if(!done) {
                if (age < i) {
                    if (targetBmi < lowerEnd) weightType = -1;
                    if (targetBmi > upperEnd) weightType = 1;
                    done = true;
                } else {
                    lowerEnd++;
                    upperEnd++;
                }
            }
        }

        // Für 65-Jährige und ältere
        if(!done && age >= 65) {
            if (targetBmi < lowerEnd++) weightType = -1;
            if (targetBmi > upperEnd++) weightType = 1;
        }

        System.out.printf("BMI: %s und Bewertung: %s",targetBmi,weightType);

        // Im Folgenden kann über switch case der weightType versprachlicht werden.

    }



}
