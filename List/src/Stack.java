import java.util.EmptyStackException;

/**
 * Created by abbyr on 09/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Stack <T> implements StackInterface <T>
{
   private MyNode<T> topNode;

   public Stack(){
      topNode = null;
   }
   public void push(T newEntry)
   {/* add a new entry to the top of the stack
    @param (T) newEntry - entry to be added
   */
      MyNode<T> newNode = new MyNode<T>(newEntry);
      newNode.setNext(topNode);
      topNode = newNode;
   }

   public T pop()
   {
   /* remove an element from the top of the stack
   throw EmptyStackException if called on an empty stack
   @return (T) - the value that was on the top of the stack
    */

      T dataToReturn = peek();
      topNode = topNode.getNext();
      return dataToReturn;
   }

   public T peek()
   {
   /* returns but dont remove the entry on the top of the stack
   throw EmptyStackException if called on an empty stack
   @retunr (T) - the value at the stop of the stack
    */
      if(topNode == null ) throw new EmptyStackException();
      else return topNode.getData();
   }
   public boolean isEmpty()
   {
      /*return true if the stack if the stack contains no elements, false otherwise

       */
      return(topNode == null);
   }
   public void clear()
   {
      /* removes all elements from the stack
       */
      topNode = null;
   }

   public static void main(String[] args){
      Stack<Integer> stack = new Stack<Integer>();
      stack.push(1);
      stack.push(2);
      stack.push(3);

      for(int i = 1; i<=4; i ++  ){
         try{
               System.out.println("Peek = " + stack.peek());
               System.out.println("Pop = " + stack.pop());
         }catch(EmptyStackException e){
            System.out.println("Exception!");
         }
      }

      stack.push(4);
      stack.push(5);
      stack.push(6);

      System.out.println("Stack empty is " + stack.isEmpty());
      stack.clear();
      System.out.println("Stack empty is " + stack.isEmpty());



   }


}//class
