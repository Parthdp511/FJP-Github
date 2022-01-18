class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        int steps = 0;
        while(maxDoubles > 0 && target > 1){
            if(target%2 == 0){
                target = target / 2;
                maxDoubles--;
            }else{
                target = target - 1;
            }
            steps++;
        }
        steps += (target - 1);
        return steps;
    }
};