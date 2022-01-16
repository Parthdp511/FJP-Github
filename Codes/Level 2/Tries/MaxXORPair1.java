class Solution {

    public static class Node{
        Node left, right;
    }

    public void insert(Node root, int val){
        for(int i=31; i>=0; i--){
            int bit = val & (1 << i);

            if(bit == 0){
                if(root.left == null)
                    root.left = new Node();
                root = root.left;
            }else{
                if(root.right == null)
                    root.right = new Node();
                root = root.right;
            }
        }
    }

    public int search(Node root, int val){
        int maxXor = 0;
        for(int i=31; i>=0; i--){
            int bit = val &(1 << i);

            if(bit == 0){
                // does pair exists with ith bit is 1 -> XOR = 1
                if(root.right != null){
                    root = root.right;
                    maxXor = maxXor | (1 << i);
                }else{
                    root = root.left;
                }
            }else{
                // does pair exists with ith bit is 1 -> XOR = 1
                if(root.left != null){
                    root = root.left;
                    maxXor = maxXor | (1 << i);
                }else{
                    root = root.right;
                }
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();

        int ans = 0;

        for(int val : nums){
            insert(root, val);
            ans = Math.max(ans, search(root, val));
        }

        return ans;
    }
}