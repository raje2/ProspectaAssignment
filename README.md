# ProspectaAssignment
This project is a demonstration of how to create APIs using the [Fake Store API](https://fakestoreapi.com/). The challenge involves implementing two main tasks.

## Task 1: List Product Details by Category

In this task, I created an API that retrieves product details based on the category passed as an input parameter. The API uses the following endpoint:

### API Reference
- **Endpoint:** `GET /products/category/{category}`
- **Example:** To retrieve products in the "jewelery" category, the request would look like this:
  
This API returns a list of products, including details such as title, price, description, and image.

## Task 2: Add a New Product

For this task, I developed an API that allows users to add a new product entry with relevant properties. The API uses the following endpoint:

### API Reference
- **Endpoint:** `POST /products`
- **Example:** The request body for adding a new product might look like this:
```json
{
  "title": "Sample Product",
  "price": 19.99,
  "description": "This is a sample product description.",
  "category": "electronics",
  "image": "https://example.com/image.jpg"
}
```
### Question: What are the key things you would consider when creating/consuming an API to ensure that it is secure and reliable?

When creating or consuming an API, I keep several important factors in mind to ensure it is secure and reliable. In this project, authentication is not included because it wasn't specified. However, in other projects, I usually prioritize authentication and authorization. When needed, I would use strong methods like OAuth or JWT to verify user identities, making sure only authorized users can access sensitive data or perform critical actions.

In this project, I focus heavily on input validation. I thoroughly check all input data to prevent attacks like SQL injection and cross-site scripting (XSS). This ensures data integrity and protects my system from harmful inputs that could disrupt its functionality. I once missed a simple input check, which caused a bug and delayed my project, showing me how vital this step is.

I also pay attention to error handling. I provide clear and consistent error messages while avoiding the sharing of sensitive information in error responses. Good error handling is essential because it helps me fix issues without revealing critical details that attackers could misuse. Overall, these practices help me create a strong API that users can trust.

### Theoretical Challenge

Suppose you have a CSV file with the data below.

A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3

This can be represented in an Excel sheet below:

|   | A | B | C         |
|---|---|---|-----------|
| 1 | 5 | 3 | =5+A1    |
| 2 | 7 | 8 | =A2+B2   |
| 3 | 9 | =4+5 | =C2+B3 |

I want a program that will take the CSV input above and produce CSV output with the results. If it is a value, then return a value. If it is a formula then calculate the formula and return the value of that formula.

### Answers to the Challenge

## 1. How will you tackle the challenge above?
To tackle the challenge of reading a CSV file and calculating values from formulas, the following approach is used:
- **Step 1:** Read the CSV file line by line and store the data in a matrix (2D array).
- **Step 2:** Create a method to identify whether a cell contains a formula (e.g., `=5+A1`) or a regular number.
- **Step 3:** If a cell contains a formula, break it down, retrieve the referenced values (e.g., `A1`), compute the result, and replace the formula with the computed value.
- **Step 4:** After all calculations are done, write the updated data back into a new CSV file.

## 2. What type of errors would you check for?
The code checks for the following types of errors:
- **Incorrect cell references:** For example, referencing a non-existent cell like `D4`.
- **Malformed formulas:** Formulas without operators or with invalid characters will be flagged.
- **Empty or missing cells:** Cells with missing values may cause issues during calculations.
- **Number format errors:** If a formula references a string instead of a number, it will trigger a format error.

## 3. How might a user break your code?
A user might break the code by:
- **Entering invalid formulas:** For example, formulas like `=A+1` or using unsupported operators might cause issues.
- **Referencing non-existent cells:** Cells such as `Z10` that don't exist in the CSV would crash the program.
- **Leaving cells empty or using non-numeric values:** If text or empty cells are used in place of numbers, the program might not work as expected.
