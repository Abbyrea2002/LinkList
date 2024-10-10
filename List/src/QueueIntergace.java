/**
 * Created by abbyr on 10/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public interface QueueIntergace<T>
{
   public void enqueue(T newEntry);
   /* add new entry to the back of the queue
    */

   public T dequeue();
   /*remove entry from the front of the queue
    */

   public T getFront();
   /* return, but font remove the entry from the front of the queue
    */

   public boolean isEmpty();
   /* returns true if the queue if empty, false otherwise

    */

   public void clear();
   /* remove all entries from the queue

    */
}
