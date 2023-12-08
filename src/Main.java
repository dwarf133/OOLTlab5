import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static void first() throws IOException {
        ArrayDeque<String> integerQueue = new ArrayDeque<String>();
        ArrayDeque<String> notIntegerQueue = new ArrayDeque<String>();

        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        try {
            String line = br.readLine();

            while (line != null) {
                String[] lines = line.split(" ");
                for (String x: lines){
                    try {
                        double t = Double.parseDouble(x);
                        integerQueue.add(x);
                    }
                    catch (NumberFormatException exception) {
                        notIntegerQueue.add(x);
                    }
                }
                line = br.readLine();
            }
        } finally {
            br.close();
        }

        while (!notIntegerQueue.isEmpty()) {
            System.out.print(notIntegerQueue.pop());
            System.out.print(" ");
        }
        System.out.println();
        while (!integerQueue.isEmpty()) {
            System.out.print(integerQueue.pop());
            System.out.print(" ");
        }
    }

    private static void second(Stack<Integer> stack) {
        ArrayDeque<Integer> pos = new ArrayDeque<Integer>();
        ArrayDeque<Integer> neg = new ArrayDeque<Integer>();
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            if (temp >= 0) {
                pos.add(temp);
            }
            else {
                neg.add(temp);
            }
        }
        while (!pos.isEmpty()) {
            System.out.print(pos.pop());
            System.out.print(" ");
        }
        System.out.println();
        while (!neg.isEmpty()) {
            System.out.print(neg.pop());
            System.out.print(" ");
        }

    }

    private static void third() throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new FileReader("file2.txt"));
        try {
            String line = br.readLine();

            while (line != null) {
                String[] lines = line.split(" ");
                for (String x: lines){
                    if (map.containsKey(x)) {
                        Integer val = map.get(x);
                        map.put(x, val+1);
                    }
                    else {
                        map.put(x, 1);
                    }
                }
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        // magic
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

    private static void fourth(Scanner in) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (in.hasNextInt()) {
            boolean isAdded = set.add(in.nextInt());
            if (isAdded) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }

    private static void runFirst(Scanner in) throws IOException {
        first();
    }

    private static void runSecond(Scanner in) {
        System.out.print("Введите числа: ");
        Stack<Integer> stack = new Stack<Integer>();
        while (in.hasNextInt()) {
            stack.add(in.nextInt());
        }
        second(stack);
    }


    private static void runThird(Scanner in) throws IOException {
        third();
    }

    private static void runFourth(Scanner in) {
        System.out.print("Введите послежовательность чисел, любое не число - конец последовательности: ");
        fourth(in);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int taskNumber = in.nextInt();
        switch (taskNumber) {
            case 1: runFirst(in);
            case 2: runSecond(in);
            case 3: runThird(in);
            case 4: runFourth(in);
        }
    }
}