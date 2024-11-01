import java.util.Scanner;

/**
 * Created by abbyr on 10/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
/**
 * This class converts infix expressions to postfix (Reverse Polish Notation)
 * and evaluates the resulting postfix expression.
 */
public class Infix2Postfix
{
       /**
     * Returns the precedence of the given operator.
     * @param c The operator character.
     * @return The precedence level of the operator.
     */
   public static int prec(char c){
      if(c == '^')
         return 3;// Highest precedence for exponentiation
      else if(c == '*' || c == '/')
         return 2;// Higher precedence for multiplication and division
      else if(c == '+' || c == '-')
         return 1; // Lowest precedence for addition and subtraction
      else
         return -1;// Return -1 for non-operators
   }
    /**
     * Converts an infix expression to a postfix expression.
     * @param s The infix expression as a string.
     * @return A StringBuilder containing the postfix expression.
     */



   public static StringBuilder infix2Postfix(String s){
      StringBuilder result = new StringBuilder();// StringBuilder to hold the postfix expression
      Stack<Character> stack = new Stack<>();// Stack to hold operators and parentheses



      for(int i = 0; i < s.length(); i++){
         char c = s.charAt(i);// Get the current character

         if(Character.isDigit(c)){
            result.append(c);// Append digit to result
         }
         else if(c == '^' || c == '*' || c == '/'
                 ||c == '+' || c == '-' ){
            // Process operators
            while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
               result.append(stack.pop());// Pop operators from stack to result
            }
            stack.push(c); // Push current operator onto stack
         }
         else if(c == '('){
            stack.push(c);// Push '(' onto stack
         }
         else if(c == ')'){
              // Pop from stack to result until '(' is found
            while(!stack.isEmpty() && stack.peek() != '('){
               result.append(stack.pop());
            }
             stack.pop();// Remove '(' from stack
         }



      }
      // Pop remaining operators from stack
      while(!stack.isEmpty()){
         result.append(stack.pop());
      }

      return result; // Return the complete postfix expression
   }
// Method to evaluate a postfix expression
   public static int evaluatePostfix(String exp){
      Stack<Integer> stack = new Stack<>();// Stack to hold operand values

      for(int i = 0; i < exp.length(); i++){
         char c = exp.charAt(i);// Get current character

         if(Character.isDigit(c))
            stack.push(c - '0');// Push the integer value of the digit onto the stack
         else{
            // Pop two operands from stack
            int val1 = stack.pop();
            int val2 = stack.pop();
            // Perform operation based on the operator
            switch(c) {
               case'+': stack.push(val2 + val1);
                   break;
               case'-': stack.push(val2 - val1);
                   break;
               case'/': stack.push(val2 / val1);
                  break;
               case'*': stack.push(val2 * val1);
                  break;
            }
            }
         }
      return stack.pop();// Return final result from stack
      }
      
   // Main method to execute the program
      public static void main(String[] args){
      Stack<Character> stack = new Stack<Character>();// Stack not used here, can be removed

      Scanner input = new Scanner(System.in);// Scanner for user input

      System.out.println("Enter an infix expression (no spaces) >");
      String infix = input.nextLine();// Read infix expression from user
      System.out.println("Postfix is: " + infix2Postfix(infix));// Output the postfix expression
      System.out.println("Result is " + evaluatePostfix(infix2Postfix(infix).toString()));// Evaluate and output the result

      }
   }//class




