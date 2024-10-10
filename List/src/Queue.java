/**
 * Created by abbyr on 10/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Queue <T> implements QueueIntergace<T>
{
   private MyNode<T> front, rear;

   public Queue(){
      front = null;
      rear = null;
   }
   public void enqueue(T newEntry)
   {
      /* add new entry to the back of the queue
       */
      MyNode<T> newNode = new MyNode<T>(newEntry);
      if(front == null){
         front = newNode;
         rear = newNode;
      }
      else{
         rear.setNext(newNode);
         rear = newNode;
      }
   }

   public T dequeue()
   {
      /*remove entry from the front of the queue
       */
      if(front == null) return null;
      else{
         T valueToReturn = front.getData();
         front = front.getNext();
         if(front == null) rear = null;
         return valueToReturn;
      }
   }

   public T getFront()
   {
      /* return, but font remove the entry from the front of the queue
       */
      if(front == null) return null;
      else return front.getData();
   }

   public boolean isEmpty()
   {
      /* returns true if the queue if empty, false otherwise
       */
      return (front == null);
   }
   public void clear()
   {
      /* remove all entries from the queue
       */
      front = null;
      rear = null;
   }

   public static void main(String[] args){
      Queue<String> queue = new Queue<String>();

      queue.enqueue("Milk");
      queue.enqueue("Eggs");
      queue.enqueue("Bread");

      for(int i = 0; i<= 4; i++){
         System.out.println("Get front = " + queue.getFront());
         System.out.println("Dequeue = " + queue.dequeue());
      }

      queue.enqueue("Cheese");
      queue.enqueue("Steak");
      queue.enqueue("Fish");

      System.out.println("Queue empty is " + queue.isEmpty());

      queue.clear();

      System.out.println("Queue empty is " + queue.isEmpty());


   }
}//class
