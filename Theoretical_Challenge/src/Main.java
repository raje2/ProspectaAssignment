/**
 * Author: Rajesh Pradhan
 * Main class to run CSV parsing and formula evaluation.
 */
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "input.csv"; // Ensure this file exists in the root folder of the project
        String outputFilePath = "output.csv";

        try {
            // Step 1: Read CSV file
            String[][] data = CSVParser.readCSV(inputFilePath);

            // Step 2: Evaluate formulas
            FormulaEvaluator evaluator = new FormulaEvaluator(data);
            evaluator.evaluateAll();

            // Step 3: Write updated data to output CSV
            CSVParser.writeCSV(data, outputFilePath);

            System.out.println("CSV processing completed. Output saved to " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
