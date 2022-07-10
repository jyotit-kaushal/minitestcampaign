## Getting Started

Welcome to this Mini Testing Software Campaign! Starting off with week 8, we have the implementation of a program that does the following:

Consider a CSV file that stores a list of records (e.g., records of bank accounts). You are required to write a software program that reads two such CSV files, compares records stored in these CSV files row by row against a unique combination and records all mismatches as exceptions. Finally, the software program generates another csv file listing the exception

We have implemented this using Java personally on VSC Code and following is all you need to know get started.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure and you're using vscode, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view on VSCode allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Main Project Structure

Moving on to the main project structure, we are using a simple class named CSVs withing the App.java (which also contains the main function) that encapsulate the following 3 methods that do the 3 main functionalities required for this project:

1. readcsv(filename): that reads the csv located in whatever path you specify as its argument in String format
2. comparecsvs(csv1, csv2): that compares the 2 read csv files and creates a new arraylist termed exceptions that we'll then write to our main output return csv file
3. writecsv(al): that takes into its argument the generated arraylist and writes the csv file containing the exceptions

## To run it for yourselves

The given implementation using AppCSV makes running the project for your own self extremely simple. Having a look at the main function:

```
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> file1 = CSVs.readcsv("./sample_file_1.csv");
        ArrayList<String> file2 = CSVs.readcsv("./sample_file_3.csv");

        ArrayList<String> exceptions = CSVs.comparecsvs(file1, file2);
        File output = CSVs.writecsv(exceptions);
        System.out.println(exceptions);
    }
}
```

All you need to do is specify your own paths (i.e. csvs) in the readcsv function. Rest all of it is handled by the project itself so no worries.

## Contact Me

Email me at jyotit_kaushal@mymail.sutd.edu.sg for any further clarificaitons or in case you having problems :p

PS there's also the corresponding Use Case Diagram you can have a look at