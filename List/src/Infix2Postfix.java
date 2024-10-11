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

   public infix2Postfix(String s){
      StringBuilder result = new StringBuilder();
      Stack<Character> stack = new Stack<>();


      for(int i = 0; i < s.length(); i++){
         char c = s.charAt(i);

         if(c >= 0 && c <= 9){
            result.append(c);
         }
         else if(c == '^' || c == '*' || c == '/'
                 ||c == '+' || c == '-' ){
            if(!stack.isEmpty() && (prec(s.charAt(i)) < prec(stack.peek())) || c == '('){
               stack.push(c);

            }else {
               result.append(stack.pop());
               stack.push(c);
            }
         }
         else if(c == '('){
            stack.push(c);
         }
         else if(c == ')'){
            while(!stack.isEmpty() && stack.peek() != '('){
               result.append(stack.pop());
            }

         }



      }
      while(!stack.isEmpty()){
         result.append(stack.pop());
      }

   return result.toString();
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
      System.out.println("Postfix is: " + infixToPostfix(infix));
      System.out.println("");

      }
   }//class




