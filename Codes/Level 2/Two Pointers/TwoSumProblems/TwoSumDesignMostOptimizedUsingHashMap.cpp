class TwoSum {
public:
    /**
     * @param number: An integer
     * @return: nothing
     */

    map<int, int> m;

    void add(int number) {
        // write your code here
        m[number]++;
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    bool find(int value) {
        // write your code here
        for(auto i : m){
            if(m.find(value-i.first) != m.end() && (value-i.first != i.first || m[value - i.first] != 1))
                return true;
        }
        return false;
    }
};