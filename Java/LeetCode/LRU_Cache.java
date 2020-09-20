import java.util.*;
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);


 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 EXAMPLE:
 LRUCache cache = new LRUCache( 2 );  // 2 is the capacity

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */

/*
//one solution

class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

 */



//    LEAST RECENTLY USED CACHE


class Node {
    int value;
    int key;
    Node prev;
    Node next;
    public Node() {}

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;

    public DoublyLinkedList(){
        head = new Node();
        tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = head;
    }

    public void insertHead(Node n){
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
    }

    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public int removeTail(){
        Node n = tail.prev;
        int key = n.key;
        remove(n);

        return key;
    }
}

class LRU_Cache {
    Map<Integer, Node> cache;
    DoublyLinkedList list;
    int capacity;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        update(key, cache.get(key));

        return cache.get(key).value;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);

        if(cache.containsKey(key)){
            list.remove(cache.get(key));
        }
        else if(cache.size() >= capacity){
            int k = list.removeTail();
            cache.remove(k);
        }

        list.insertHead(n);
        cache.put(key, n);
    }

    private void update(int key, Node n){
        list.remove(n);
        list.insertHead(n);
        cache.put(key, n);
    }
}



/*
// another solution

import java.util.Hashtable;
public class LRUCache {

  class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
  }

    private void addNode(DLinkedNode node) {
    //Always add the new node right after head.

    node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
    }

    private void removeNode(DLinkedNode node){
        //Remove an existing node from the linked list.

        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
    }

    private void moveToHead(DLinkedNode node){
        //Move certain node in between to the head.

        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        //Pop the current tail.

        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
        DLinkedNode newNode = new DLinkedNode();
        newNode.key = key;
        newNode.value = value;

        cache.put(key, newNode);
        addNode(newNode);

        ++size;

        if(size > capacity) {
        // pop the tail
        DLinkedNode tail = popTail();
        cache.remove(tail.key);
        --size;
        }
        } else {
        // update the value.
        node.value = value;
        moveToHead(node);
        }
    }
}



 */
