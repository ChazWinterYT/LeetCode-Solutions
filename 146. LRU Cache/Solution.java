class LRUCache {
    private int capacity;
    private Map<Integer, LogItem> map;
    private LogItem head, tail;
    
    /*  Start a new LRU Cache with a dummy head and tail and a capacity
        New LogItems will always be added in between these dummy nodes. */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LogItem(0, 0);
        tail = new LogItem(0, 0);
        head.setNext(tail);
        tail.setPrev(head);
    }
    
    //  If the key is in the map, get its value, and move the item to the front.
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        LogItem itemToMove = map.get(key);
        remove(itemToMove);
        insertAtFront(itemToMove);
        return itemToMove.getValue();
    }
    
    /*  If the key is already in the map, update its value and move it to the front of the cache.
        If it is new, check capacity, and remove the LRU key if the cache is full.
        Then add the new key to the front of the cache and into the map. */
    public void put(int key, int value) {
        LogItem existingItem = map.get(key);
        if (existingItem != null) { // This is an existing item
            existingItem.setValue(value);
            remove(existingItem);
            insertAtFront(existingItem);
        } else {    // This is a new item
            if (map.size() == capacity) {
                LogItem itemToEvict = tail.getPrev();
                map.remove(itemToEvict.getKey());
                remove(itemToEvict);
            }
            LogItem newItem = new LogItem(key, value);
            map.put(key, newItem);
            insertAtFront(newItem);
        }
    }
    
    /*  Remove the item by getting it's prev and next nodes,
        and setting them to be each other's next and prev nodes. */
    private void remove(LogItem item) {
        LogItem newNext = item.getNext();
        LogItem newPrev = item.getPrev();
        item.getPrev().setNext(newNext);
        item.getNext().setPrev(newPrev);
    }
    
    /*  Insert an item at the front by setting the old front node's prev
        to this item, and setting the head's next node to this item. 
        (While also linking this item's prev and next to these nodes) */
    private void insertAtFront(LogItem item) {
        // Link old front and new front to each other
        item.setNext(head.getNext());
        head.getNext().setPrev(item);
        // Link new front and head to each other
        head.setNext(item);
        item.setPrev(head);
    }
}

class LogItem {
    private int key;
    private int value;
    private LogItem prev;
    private LogItem next;
    
    public LogItem(int key, int value) {
        this.key = key;
        this.value = value;
    }
    
    public int getKey() {
        return this.key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    
    public LogItem getPrev() {
        return this.prev;
    }
    public void setPrev(LogItem prev) {
        this.prev = prev;
    }
    
    public LogItem getNext() {
        return this.next;
    }
    public void setNext(LogItem next) {
        this.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */