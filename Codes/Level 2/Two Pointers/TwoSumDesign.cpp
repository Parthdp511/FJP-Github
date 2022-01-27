class TwoSum {
public:
    /**
     * @param number: An integer
     * @return: nothing
     */
    vector<int> v;
    void add(int number) {
        // write your code here
        v.push_back(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    bool find(int value) {
        // write your code here
        sort(v.begin(), v.end());
        int start = 0, end = v.size() - 1;
        while(start < end){
            int sum = v[start] + v[end];
            if(sum < value)
                start++;
            else if(sum > value)
                end--;
            else
                return true;
        }
        return false;
    }
};