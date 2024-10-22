/**
 * Author: Rajesh Pradhan
 * This class handles reading and writing CSV files.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVParser {
    public static String[][] readCSV(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String[][] data = new String[3][3];  // Adjust for exact 3x3 data (A, B, C)
        String line;
        int row = 0;
        br.readLine(); // Skip header line
        while ((line = br.readLine()) != null && row < 3) {
            String[] values = line.split(",", -1);  // Avoid dropping empty values
            System.arraycopy(values, 1, data[row], 0, 3);  // Only copy relevant columns (A, B, C)
            row++;
        }
        br.close();
        return data;
    }

    public static void writeCSV(String[][] data, String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.append(",A,B,C\n");  // Write header
        for (int i = 0; i < data.length; i++) {
            fw.append((i + 1) + ",");  // Write row number
            fw.append(String.join(",", data[i])).append("\n");
        }
        fw.flush();
        fw.close();
    }
}
