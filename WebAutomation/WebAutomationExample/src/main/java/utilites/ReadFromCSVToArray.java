package utilites;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFromCSVToArray {

    public List<String> readCSVtoArray(String filePath) throws FileNotFoundException {
        List<String> records = new ArrayList<>();

        Scanner scanner = new Scanner(new File(filePath));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            //System.out.print(scanner.next()+"|");
            records.add(scanner.next());
        }
        scanner.close();
        return records;
    }



}


