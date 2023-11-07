package deque;

import java.util.Deque;
import java.util.Iterator;

public class ArrayDeque<Type> implements deque<Type> {
    private int size;
    private Type[] items;
    private int Refractor=4;//need to check later

    private int next_front;
    private int next_back;

    public ArrayDeque(){
        items= (Type[]) new Object[8];
        size=0;
        next_front=7;
        next_back=0;
    }

    @Override
    public int size(){
        return size;
    }

    private int getFirstIndex(){
        return (next_front+1)%items.length;
    }

    private int getLastIndex(){
        return (next_back-1+ items.length)%items.length;
    }


    private void reSize(int capacity){
        int First=getFirstIndex();
        int Last=getLastIndex();
        Type[] new_arr= (Type[]) new Object[capacity];
        if(First<Last){
            System.arraycopy(items,First,new_arr,0,next_back-First);
        }else {
            if(First<=items.length-1){
                System.arraycopy(items,First,new_arr,0,items.length-First);
            }
            if(Last>=0){
                System.arraycopy(items,0,new_arr,items.length-First,Last+1);
            }
        }
        items=new_arr;
        next_front=items.length-1;
        next_back=size;
    }

    private boolean IfResize(){
        return this.size==this.items.length;
    }

    private boolean IfDesize(){
        return ((double) size/items.length)<=0.25;
    }

    @Override
    public void addFirst(Type x){
        if (IfResize()){
            reSize(items.length*Refractor);
        }
        items[next_front]=x;
        next_front=(next_front-1+items.length)%items.length;
        size+=1;
    }

    @Override
    public void addLast(Type x){
        if (IfResize()){
            reSize(items.length*Refractor);
        }
        items[next_back]=x;
        next_back=(next_back+1+ items.length)% items.length;
        size+=1;
    }

    @Override
    public Type removeFirst(){
        if(size==0){
            return null;
        }
        Type removedFirst=items[(next_front+1+ items.length)% items.length];
        next_front=(next_front+1+items.length)% items.length;
        size-=1;
        if (IfDesize()){
            reSize(items.length/4);
        }
        return removedFirst;
    }

    @Override
    public Type removeLast(){
        if (size==0){
            return null;
        }
        Type removedLast=items[(next_back-1+ items.length)% items.length];
        next_back=(next_back-1+items.length)% items.length;
        size-=1;
        if (IfDesize()){
            reSize(items.length/4);
        }
        return removedLast;
    }
    @Override
    public Type get(int index){
        if(index>size){
            return null;
        }
        return items[(next_front+index+ items.length)% items.length];
    }
    @Override
    public void printDeque(){
        if(next_front<next_back){
            for (int i=1;i<size;i++){
                System.out.print(items[next_front+i]);
            }
            }else{
            for(int i=1;i<(items.length-next_front);i++){
                System.out.print(items[next_front+i]);
            }
            for(int i=0;i<next_back;i++){
                System.out.print(items[i]);
            }
        }
        System.out.println();
    }

    private class ArrayDequeIterator<Type> implements Iterator<Type>{
        private int Pos;
        ArrayDequeIterator(){
            Pos=1;
        }

        public boolean hasNext(){
            return Pos<size;
        }
        public Type next(){
            Type returnItem = (Type) get(Pos);
            Pos+=1;
            return returnItem;
        }
    }
    @Override
    public Iterator<Type> iterator(){
        return new ArrayDequeIterator();
    }
    @Override
    public boolean equals(Object o){
        if (this==o){
            return true;
        }
        if (o==null){
            return false;
        }
        if(!(o instanceof deque)){
            return false;
        }
        deque<Type> other= (deque<Type>) o;
        if (size!=other.size()){
            return false;
        }
        for(int i=1;i<size;i++){
            if(get(i)!=other.get(i)){
                return false;
            }
        }
        return true;
    }

    //lengthHelper method help for testing resize
    public int lengthHelper(){
        return items.length;
    }
}
