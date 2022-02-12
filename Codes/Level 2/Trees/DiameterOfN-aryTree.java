public class Solution {

    int globalDia = 0;

    public int dfs(ArrayList<Integer>[] adj, int root){

        int h1 = 0, h2 = 0;
        for(Integer child: adj[root]){
            int height = dfs(adj, child);
            if(height > h1){
                h2 = h1;
                h1 = height;
            }else if(height > h2){
                h2 = height;
            }
        }
        globalDia = Math.max(globalDia, h1 + h2 + 1);
        return 1 + h1;
    }

    public int solve(int[] A) {
        ArrayList<Integer>[] adj = new ArrayList[A.length];

        for(int i=0; i<A.length; i++) adj[i] = new ArrayList<>();

        int root = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] == -1)  root = i;
            else adj[A[i]].add(i);
        }

        dfs(adj, root);
        return globalDia - 1;
    }
}
