package deque;
import java.util.Iterator;


public class LinkedListDeque<Type> implements deque<Type>{

    /*define staffnode class and its constructor
    * each node contains a previous node, a type value, and a next node
    */
    private class StaffNode{
        public StaffNode Previous;
        public Type item;
        public StaffNode Next;

        public StaffNode(StaffNode prev,Type i, StaffNode next){
            Previous=prev;
            item=i;
            Next=next;
        }
    }

    /*Invariants of LinkedListDeques* */
    private int size;
    private StaffNode Sentinel_node;
    private StaffNode back_node;


    //Constructors
    public LinkedListDeque(){
        Sentinel_node=new StaffNode(null,null,null);
        back_node= new StaffNode(null,null,null);
        size=0;
    }
    public LinkedListDeque(Type x){
        Sentinel_node= new StaffNode(null,null,null);
        Sentinel_node.Next= new StaffNode(null,x,null);
        back_node= new StaffNode(Sentinel_node.Next,null,null);
        size=1;
    }
    //Operations

    //size()
    @Override
    public int size(){
        return size;
    }

    //isEmpty() is inherited implemented

    //add First
    @Override
    public void addFirst(Type x){
        if(this.isEmpty()){
            Sentinel_node.Next=new StaffNode(null,x,null);
            back_node.Previous=Sentinel_node.Next;
        }else{
            Sentinel_node.Next= new StaffNode(null,x,Sentinel_node.Next);
            Sentinel_node.Next.Next.Previous=Sentinel_node.Next;
        }
        size+=1;
    }
    //add Last
    @Override
    public void addLast(Type x){
        if(this.isEmpty()){
            Sentinel_node.Next=new StaffNode(null,x,null);
            back_node.Previous=Sentinel_node.Next;
        }else{
            back_node.Previous.Next=new StaffNode(back_node.Previous,x,null);
            back_node.Previous=back_node.Previous.Next;
        }
        size+=1;
    }

    //get ith item
    @Override
    public Type get(int i){
        if(i>size||i==0){
            return null;
        }else{
            Type seerItem = null;
            LinkedListDequeIterator seer= (LinkedListDequeIterator) iterator();
            while(i!=0){
            seerItem=seer.next();
            i--;
            }
            return seerItem;
        }
    }

    /*
    * get() using recursive method
    * */
    private Type getRecursiveHelper(int index,StaffNode P){
        if (index==0){
            return P.item;
        }
        return getRecursiveHelper(index-1,P.Next);
    }

    public Type getRecursive(int index){
        if(size==0){
            return null;
        }
        return getRecursiveHelper(index,Sentinel_node.Next);
    }

    public Type getFirst(){
        if(size()==0){
            throw new RuntimeException("There no element in deque");
        }else{
            return Sentinel_node.Next.item;
        }
    }

    //remover operations
    @Override
    public Type removeFirst(){
        if(size==0){
            return null;
        }else {
            Type firstItem = Sentinel_node.Next.item;
            Sentinel_node.Next = Sentinel_node.Next.Next;
            Sentinel_node.Next.Previous = null;
            size-=1;
            return firstItem;
        }
    }

    @Override
    public Type removeLast(){
        if(size==0){
            return null;
        }else {
            Type lastItem = back_node.Previous.item;
            back_node.Previous = back_node.Previous.Previous;
            back_node.Previous.Next = null;
            size-=1;
            return lastItem;
        }
    }

    private class LinkedListDequeIterator implements Iterator<Type>{
        private StaffNode iterNode;

        public LinkedListDequeIterator(){
            iterNode=Sentinel_node.Next;
        }

        public boolean hasNext(){
            return iterNode.Next!=null;
        }
        public Type next(){
            Type currentItem= iterNode.item;
            iterNode=iterNode.Next;
            return currentItem;
        }
    }

    public Iterator<Type> iterator(){
        return new LinkedListDequeIterator();
    }

    //print operation
    @Override
    public void printDeque(){
        if(size==0){
            throw new RuntimeException("there's no element in deque");
        }else{
            StaffNode P=Sentinel_node.Next;
            while(P.Next!=null){
                System.out.print(P.item + " ");
                P=P.Next;
            }
            System.out.println();
        }
    }

    //equal operation
    /*Need to review Type inheritance*/
    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if (o==null){
            return false;
        }
        if(!(o instanceof deque)){
            return false;
        }
        deque<Type> other= (deque<Type>) o;
        if (size!= other.size()){
            return false;
        }
        for(int i=0; i<size;i++){
            Type item1=this.get(i);
            Type item2=other.get(i);
            if(item1!=item2){
                return false;
            }
        }
        return true;
    }






}
