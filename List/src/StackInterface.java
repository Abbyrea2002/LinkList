/**
 * Created by abbyr on 09/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public interface StackInterface <T>
{
   public void push(T newEntry);
   /* add a new entry to the top of the stack
    @param (T) newEntry - entry to be added
   */

   public T pop();
   /* remove an element from the top of the stack
   throw EmptyStackException if called on an empty stack
   @return (T) - the value that was on the top of the stack
    */

   public T peek();
   /* returns but dont remove the entry on the top of the stack
   throw EmptyStackException if called on an empty stack
   @retunr (T) - the value at the stop of the stack
    */

   public boolean isEmpty();
   /*return true if the stack if the stack contains no elements, false otherwise

    */

   public void clear();
   /* removes all elements from the stack
    */

}
