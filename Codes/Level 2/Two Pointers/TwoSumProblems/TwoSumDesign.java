public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */

    ArrayList<Integer> stream;

    public void add(int number) {
        // write your code here
        if(stream == null)  stream = new ArrayList<>();
        stream.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        Collections.sort(stream);
        int left = 0, right = stream.size() - 1;
        while(left < right){
            int currSum = stream.get(left) + stream.get(right);
            if(currSum == value)
                return true;
            else if(currSum < value)
                left++;
            else
                right--;
        }
        return false;
    }
}