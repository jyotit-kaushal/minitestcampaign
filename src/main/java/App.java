import java.beans.Transient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> file1 = CSVs.readcsv("./sample_file_1.csv");
        ArrayList<String> file2 = CSVs.readcsv("./sample_file_3.csv");

        ArrayList<String> exceptions = CSVs.comparecsvs(file1, file2);
        CSVs.writecsv(exceptions);
    }
}

class CSVs {

    public static ArrayList<String> readcsv(String filename) throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new FileReader(filename));
        ArrayList<String> data = new ArrayList<String>();
        String line;

        while ((line = bufferedreader.readLine()) != null) {
            data.add(line);
        }
        bufferedreader.close();
        return data;
    }

    public static ArrayList<String> comparecsvs(ArrayList<String> csv1, ArrayList<String> csv2) {
        int length = Math.min(csv1.size(), csv2.size());
        ArrayList<String> exceptions = new ArrayList<String>();

        for (int i = 0; i < length; i++) {
            if (csv1.get(i).equals(csv2.get(i))) {
                ;
            } else {
                exceptions.add(csv1.get(i));
                exceptions.add(csv2.get(i));
            }
        }
        return exceptions;

    }

    public static int countexceptions(ArrayList<String> csv1, ArrayList<String> csv2) {
        int length = Math.min(csv1.size(), csv2.size());
//        ArrayList<String> exceptions = new ArrayList<String>();

        int count_exceptions=0;
        for (Object x: csv1) {
            if (!csv2.contains(x)) {
                count_exceptions+=1;
            }
        }
        return count_exceptions;

    }

    public static void writecsv(ArrayList<String> al) throws IOException {
        File file = new File("./out.csv");
        FileWriter filewriter = new FileWriter(file);
        BufferedWriter bufferedwriter = new BufferedWriter(filewriter);

        for (int i = 0; i < al.size(); i++) {
            bufferedwriter.write(al.get(i) + "\n" + al.get(i++));
            bufferedwriter.newLine();
        }

        bufferedwriter.close();
        filewriter.close();
    }
}


