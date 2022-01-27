class LRUCache {
public:
    map<int,int> m;
    map<int,list<int>::iterator> address;
    list<int> l;
    int cap,size;
    LRUCache(int capacity) {
        cap = capacity;
        size = 0;
    }
    
    int get(int key) {
        if(m.find(key) == m.end())  
            return -1;
        list<int>::iterator it = address[key];
        l.erase(it);
        address.erase(key);
        l.push_front(key);
        address[key]=l.begin();
        return m[key];
    }
    
    void put(int key, int value) {
        if(m.find(key) != m.end()){
            l.erase(address[key]);
            address.erase(key);
            m.erase(key);
            size--;
        }
        if(size == cap){
            int k = l.back();
            l.pop_back();
            address.erase(k);
            m.erase(k);
            size--;
        }
        size++;
        l.push_front(key);
        address[key] = l.begin();
        m[key] = value;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */