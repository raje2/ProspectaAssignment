/**
 * Author: Rajesh Pradhan
 * This class handles evaluating formulas inside the CSV data.
 */
public class FormulaEvaluator {
    private String[][] data;

    public FormulaEvaluator(String[][] data) {
        this.data = data;
    }

    public void evaluateAll() {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                String cell = data[row][col].trim();
                if (cell.startsWith("=")) {
                    // Remove the '=' sign before evaluating
                    data[row][col] = evaluateFormula(cell.substring(1), row, col);
                }
            }
        }
    }

    private String evaluateFormula(String formula, int currentRow, int currentCol) {
        try {
            if (formula.contains("+")) {
                String[] parts = formula.split("\\+");
                int value1 = getValue(parts[0].trim());
                int value2 = getValue(parts[1].trim());
                return String.valueOf(value1 + value2);
            }
            // Add other operators (e.g., -, *, /) here if needed
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formula;  // Return original formula if unable to evaluate
    }

    private int getValue(String ref) {
        // Check if the ref is a direct number
        if (ref.matches("\\d+")) {
            return Integer.parseInt(ref);  // It's a number
        } else if (ref.matches("[A-C][1-3]")) {
            // It's a cell reference like A1, B2, etc.
            int row = Integer.parseInt(ref.substring(1)) - 1;  // Convert "1", "2", etc. to row index
            int col = ref.charAt(0) - 'A';  // Convert "A", "B", "C" to column index (0, 1, 2)

            String value = data[row][col].trim();

            // If the cell contains a number, return it.
            if (value.matches("\\d+")) {
                return Integer.parseInt(value);  // It's already a number
            } else if (value.startsWith("=")) {
                // If the cell contains a formula, evaluate it recursively
                return Integer.parseInt(evaluateFormula(value.substring(1), row, col));
            }
        }
        throw new NumberFormatException("Invalid reference or number: " + ref);
    }
}
