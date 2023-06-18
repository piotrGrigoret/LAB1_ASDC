import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OptionsSorted {

    public static Tovar[] readingFIle() throws IOException {
        Tovar[] tovars = new Tovar[50];


        try {
            FileReader fileReader = new FileReader("C:\\Users\\КОКСИК\\IdeaProjects\\lab1asdc\\src\\fileSorted");
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

    public static String binarySearch(Tovar[] tovars, int target) {
        long startTime = System.nanoTime();
        long endTime;

        int left = 0;
        int right = tovars.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (tovars[mid].getID() == target) {
                endTime = System.nanoTime();
                System.out.println("Time of execution: " + (endTime - startTime)+ " Nano Seconds");
                return tovars[mid].toString();
            } else if (tovars[mid].getID() < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime)+ " Nano Seconds");
        return "Error";
    }

    public static String interpolationSearch(Tovar[] tovars, int target) {
        long startTime = System.nanoTime();
        long endTime;

        int left = 0;
        int right = tovars.length - 1;
        while (left <= right && target >= tovars[left].getID() && target <= tovars[right].getID()) {
            int pos = left + ((target - tovars[left].getID()) * (right - left)) / (tovars[right].getID() - tovars[left].getID());
            if (tovars[pos].getID() == target) {
                endTime = System.nanoTime();
                System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
                return tovars[pos].toString();
            } else if (tovars[pos].getID() < target) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
        return "Error";
    }

    public static String fibonacciSearch(Tovar[] tovars, int target) {
        long startTime = System.nanoTime();
        long endTime;

        int n = tovars.length;
        int fib2 = 0;
        int fib1 = 1;
        int fib = fib2 + fib1;
        while (fib < n) {
            fib2 = fib1;
            fib1 = fib;
            fib = fib2 + fib1;
        }
        int offset = -1;
        while (fib > 1) {
            int i = Math.min(offset + fib2, n - 1);
            if (tovars[i].getID() < target) {
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            } else if (tovars[i].getID() > target) {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            } else {
                endTime = System.nanoTime();
                System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
                return tovars[i].toString();
            }
        }
        if (fib1 == 1 && tovars[offset + 1].getID() == target) {
            endTime = System.nanoTime();
            System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
            return tovars[offset + 1].getName() + " " + tovars[offset + 1].getDescription();
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
        return "Error";
    }
}