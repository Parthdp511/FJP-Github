import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void helper(TreeNode root, int[] a, int val){
        if(root == null)    return;
        a[0] = Math.min(val, a[0]);
        a[1] = Math.max(val, a[1]);
        if(root.left != null)   helper(root.left, a, val - 1);
        if(root.right != null)  helper(root.right, a, val + 1);
    }

    public static int width(TreeNode root) {
        int[] a = new int[2];
        helper(root, a, 0);
        int ans = a[1] - a[0] + 1;
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}