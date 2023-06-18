import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OptionsUnSorted {

    public static Tovar[] readingFIle() throws IOException {
        Tovar[] tovars = new Tovar[50];


        try {
            FileReader fileReader = new FileReader("C:\\Users\\КОКСИК\\IdeaProjects\\lab1asdc\\src\\fileUnsorted.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(int i = 0; i < tovars.length; i++) {
                tovars[i] = new Tovar();
                tovars[i].readingFile(bufferedReader);
            }

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

        return tovars;
    }

    public static String sequentialSearch(Tovar[] tovars, int target) {
        long startTime = System.nanoTime();
        long endTime;
        for (int i = 0; i < tovars.length; i++) {
            if (tovars[i] != null && tovars[i].getID() == target) {
                endTime = System.nanoTime();
                System.out.println("Time of execution: " + (endTime - startTime)+ " Nano Seconds");
                return tovars[i].toString();
            }
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime)+ " Nano Seconds");
        return "Error"; // если элемент не найден
    }
}