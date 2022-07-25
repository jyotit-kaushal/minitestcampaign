import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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