import java.util.Arrays;
import java.util.Random;

public class PQueue <T extends Comparable<T>> implements PQueueInterface<T> {

    private MyNode<T> front;

    public PQueue(){
        front = null;
    }

    public void enqueue(T newEntry) {
        /* adds new entry to the linked queue in its priority position
         */
        MyNode<T> newNode = new MyNode<T>(newEntry);
        if(front == null){
            front = newNode;
        }
        else if (front.getData().compareTo(newEntry) > 0) {
            newNode.setNext(front);
            front = newNode;
        }
        else{
            MyNode<T> currentNode = front;
            while (currentNode.getNext() != null &&
                    currentNode.getNext().getData().compareTo(newEntry) <= 0) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }



    }
    public T dequeue() {
        /* removes entry from the queue
         */
        if (front == null) {
            return null; // Queue is empty
        }
        T data = front.getData(); // Get data from the front node
        front = front.getNext();   // Move front to the next node
        return data;


    }

    public T getFront() {
        /*gets item from the front of the queue
         */
        if(front == null) return null;
        else return front.getData();
    }


    public boolean isEmpty() {
        /* returns a boolean value which determines if the queue is empty of not
         */
        return (front == null);
    }

    public void clear() {
        /* clears all items from the queue
         */
        front = null;
    }

    public static void main(String[] args){
        PQueue<Integer> PQueue =  new PQueue<Integer>();
        Random random = new Random();
        Integer[] randomValues = new Integer[10];

        for(int i = 0; i < randomValues.length; i++){
             randomValues[i] = random.nextInt(1000);
             PQueue.enqueue(randomValues[i]);
        }

        System.out.println("Random array is " + Arrays.toString(randomValues));

        while(!PQueue.isEmpty()){
            System.out.println("Removing value " + PQueue.dequeue());
        }
    }
}
