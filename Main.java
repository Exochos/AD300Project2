import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SortedArrayList<String> sortedArrayList = new SortedArrayList<String>();

        sortedArrayList.add("Bob");
        sortedArrayList.add("Charlie");
        sortedArrayList.add("David");
        sortedArrayList.add("Alice");
        sortedArrayList.add("Alice");

        System.out.println(sortedArrayList.contains("Bob"));
        //String[] array = sortedArrayList.toArray();
        //for (String s : sortedArrayList.iterator()) {
        //System.out.println(s);
        //        }
        for (int i = 0; i < sortedArrayList.size(); i++) {
            System.out.println(sortedArrayList.get(i));
        }
        String stringy = sortedArrayList.toString();
        System.out.println(stringy);
        //String[] array = sortedArrayList.toArray();   

        sortedArrayList.clear();

        String input = "";
        try {
            Scanner countScan = new Scanner(new File("names.txt"));
            while (countScan.hasNext()) {
                input = countScan.next();
                sortedArrayList.add(input);
            }
            countScan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < sortedArrayList.size(); i++) {
            System.out.println(sortedArrayList.get(i));
        }
    }
}