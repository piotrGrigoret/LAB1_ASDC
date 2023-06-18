import java.io.IOException;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Tovar[] tovarsSorted;
        Tovar[] tovarsUnSorted;

        tovarsSorted = OptionsSorted.readingFIle();
        tovarsUnSorted = OptionsUnSorted.readingFIle();

        System.out.println("\nSequential Search (UN_SORTED): ");
        System.out.println(OptionsUnSorted.sequentialSearch(tovarsUnSorted, 3471));

        System.out.println("\nBinary Search (SORTED): ");
        System.out.println(OptionsSorted.binarySearch(tovarsSorted, 3471));
        System.out.println("\nInterpolation Search (SORTED): ");
        System.out.println(OptionsSorted.interpolationSearch(tovarsSorted, 3471));
        System.out.println("\nFibonacci Search (SORTED): ");
        System.out.println(OptionsSorted.fibonacciSearch(tovarsSorted, 3471));

        Tree tree = new Tree();
        for (Tovar stud: tovarsSorted) {
            tree.insertNode(stud);
        }
        System.out.println("\nBinary tree search:");
        System.out.println(tree.findNodeByID(3471));
    }
}