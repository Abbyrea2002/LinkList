import java.util.Scanner;

/**
 * Created by abbyr on 10/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Infix2Postfix
{
   public static int prec(char c){
      if(c == '^')
         return 3;
      else if(c == '*' || c == '/')
         return 2;
      else if(c == '+' || c == '-')
         return 1;
      else
         return -1;
   }

   public static class Result {
      String postfix;
      Stack<Character> stack;

      public Result(String postfix, Stack<Character> stack) {
         this.postfix = postfix;
         this.stack = stack;
      }
   }

   public static Result infix2Postfix(String s){
      StringBuilder result = new StringBuilder();
      Stack<Character> stack = new Stack<>();


      for(int i = 0; i < s.length(); i++){
         char c = s.charAt(i);

         if(Character.isDigit(c)){
            result.append(c);
         }
         else if(c == '^' || c == '*' || c == '/'
                 ||c == '+' || c == '-' ){
            while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
               result.append(stack.pop());
            }
            stack.push(c);
         }
         else if(c == '('){
            stack.push(c);
         }
         else if(c == ')'){
            while(!stack.isEmpty() && stack.peek() != '('){
               result.append(stack.pop());
            }
             stack.pop();
         }



      }
      while(!stack.isEmpty()){
         result.append(stack.pop());
      }

      return new Result(result.toString(), stack);
   }

   public static int evaluatePostfix(String exp){
      Stack<Integer> stack = new Stack<>();

      for(int i = 0; i < exp.length(); i++){
         char c = exp.charAt(i);

         if(Character.isDigit(c))
            stack.push(c - '0');
         else{
            int val1 = stack.pop();
            int val2 = stack.pop();

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
      return stack.pop();
      }

      public static void main(String[] args){
      Stack<Character> stack = new Stack<Character>();
      Scanner input = new Scanner(System.in);

      System.out.println("Enter an infix expression (no spaces) >");
      String infix = input.nextLine();
      System.out.println("Postfix is: " + infix2Postfix(infix));
      System.out.println("");

      }
   }//class




