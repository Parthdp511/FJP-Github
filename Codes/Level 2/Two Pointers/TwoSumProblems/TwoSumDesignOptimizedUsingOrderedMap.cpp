class TwoSum {
public:
    /**
     * @param number: An integer
     * @return: nothing
     */

map<int, int> arr;

    void add(int number) {
        // write your code here
        arr[number]++;
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    bool find(int value) {
        // write your code here
        auto left = arr.begin();
        auto right = arr.end();
        right--;

        while(left != right){
            int sum = left->first + right->first;
            if(sum == value)
                return true;
            if(sum < value) left++;
            else    right--;
        }
        if(left->second > 1 && 2*(left->first) == value)
            return true;
        return false;
    }
};