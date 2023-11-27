package bstmap;
import java.util.*;
public class BSTMap<K extends Comparable<K>,V> implements Map61B<K, V>{
    private class Node{
        private K key;//sorted by key
        private V value;
        private Node left, right;//left and right subtrees
        private int size;//number of nodes in subtree

        public Node(K key, V value){
            this.key=key;
            this.value=value;
        }
    }
    private Node root;
    private int size;

    /*Creat an empty BSTmap*/
    public BSTMap(){
        this.root=null;
        this.size=0;
    }
    @Override
    public void clear(){
        this.root=null;
        this.size=0;
    }

    @Override
    public void put(K key, V value) {

    }

    private Node put(K key,V value,Node node){
        if(node==null){
            this.size++;
            return new Node(key,value);
        }
        int cmp=key.compareTo(node.key);
        if (cmp>0){
            node.right=put(key,value,node.right);
        } else if (cmp<0) {
            node.left=put(key,value,node.left);

        }
    }

    public boolean containskey(K searchkey){

    }


}
