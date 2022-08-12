import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CSVsTest {



    @Test
    public void testcsvfileformat(String filename1, String filename2){
        Throwable e= null;

        try{
            CSVs.readcsv(filename1);
            CSVs.readcsv(filename2);
        } catch(Throwable exception){
            e=exception;
        }

        assertTrue(e instanceof IOException);
    }

    @Test
    public void testemptyfile(String filename1, String filename2) throws IOException{
        Throwable e= null;
        ArrayList<String> file1= null;
        ArrayList<String> file2= null;
        ArrayList<String> emptyal= new ArrayList<>();

        try{
            file1= CSVs.readcsv(filename1);
            file2= CSVs.readcsv(filename2);
        } catch(Throwable exception){
            e=exception;
        }

        assertTrue(e instanceof Exception);

        assertNotEquals(emptyal, file1);
        assertNotEquals(emptyal, file2);
    }
    @Test
    public void testcomparecsvs() throws IOException {
        ArrayList<String> file1 = CSVs.readcsv("./sample_file_1.csv");
        ArrayList<String> file2 = CSVs.readcsv("./sample_file_3.csv");

        ArrayList<String> exceptions = CSVs.comparecsvs(file1, file2);

        ArrayList<String> checkexc= CSVs.readcsv("./iyt,csv");

        assertEquals(checkexc, exceptions);
    }

   public void testlengths(String filename1, String filename2) throws IOException {
       ArrayList<String> file1 = CSVs.readcsv(filename1);
       ArrayList<String> file2 = CSVs.readcsv(filename2);

       assertEquals(file1.size(), file2.size());
   }

}

class Fuzzer {

    @Test
    public static String generateString(int len){
        byte[] array = new byte[len];
        new Random().nextBytes(array);
        String ourstring = new String(array, StandardCharsets.UTF_8);
        return ourstring;
    }

    public static int mutateCsv(File file, int errno) throws IOException {

        File fileInput = new File ("./input.csv");
        FileWriter fileWriter = new FileWriter(fileInput);
        fileWriter.append("Customer ID#,Account No.,Currency,Type,Balance\n");

        Scanner sc = new Scanner(file);
        int mutations = 0;
        int counter = 0;
        boolean [] fallacy = {false, true};
        while (sc.hasNext()){
            /*
            Here we are basically adding a random line that we genrate using generate string somewhere within the input file in the function
             */
            if (counter<3){
                counter++;
                sc.next();
            }
            else{
                boolean falseLine = fallacy[new Random().nextInt(2)];
                if (falseLine == true && errno > 0){
                    String lineRandom = generateString(10);
                    String line = sc.next().split(",")[0];
                    String mutation = line+","+lineRandom;

                    fileWriter.append(mutation);
                    fileWriter.append("\n");

                    errno--;
                    mutations++;
                }
                else { // otherwise
                    String line = sc.next();
                    fileWriter.append(line);
                    fileWriter.append("\n");
                }
            }
        }
        sc.close();
        fileWriter.flush();
        fileWriter.close();

        return mutations;


    }

    @Test
    public static void mainFuzzer() throws Exception{

        String path1= "./sample_file_1.csv";
        String path2= "./sample_file_3.csv";
        File file1_asis = new File(path1);
        File file2_asis = new File(path2);

        ArrayList<String> file1 = CSVs.readcsv(path1);
        ArrayList<String> file2 = CSVs.readcsv(path2);
        File mutatedInput = new File("./input.csv");
//        ArrayList<String> mutatedInput= CSVs.readcsv("./input.csv");


        int flag = 0;

        int numFuzzers = 1000;
        int [] mutationsArray = new int[numFuzzers];
        int [] mismatchArray = new int[numFuzzers];
        for (int i= 0 ; i< numFuzzers; i++){
            System.out.println("\n\nIteration "+ i);
            int mutations = mutateCsv(file1_asis, i);
            ArrayList<String> mutatee= CSVs.readcsv("./input.csv");
            int matches = CSVs.countexceptions(mutatee, file2);
            if (mutations!=matches){
                flag=1;
            }
            System.out.println("\nNumber of mismatches: "+ matches + "\nNumber of mutations : "+ matches);
        }
        if (flag == 0){
            System.out.println("\n\n\n\nAll good");
        }
        else{
            System.out.println("\n\n\n\nFuzzer predicts error!");
        }

    }

    public static void main(String[] args) throws Exception{

        mainFuzzer();
    }
}