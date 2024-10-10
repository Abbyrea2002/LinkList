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

   public static void infixToPostfix(String s){
      StringBuilder result = new StringBuilder();
      Stack<Character> stack = new Stack<>();

      for(int i = 0; i < s.length(); i++){
         char c = s.charAt(i);

         if(c >= 0 && c <= 9){
            result.append(c);
         }

      }


   }

}//class
