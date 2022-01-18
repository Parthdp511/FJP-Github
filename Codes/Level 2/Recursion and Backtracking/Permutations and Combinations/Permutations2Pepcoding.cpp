#include<bits/stdc++.h>
using namespace std;

void permutations(int currBox, int currItem, string currAns, vector<bool> &visited, int n, int k){
    if(currBox == n){
        if(currItem == k)
            cout<<currAns<<endl;
        return;
    }
    
    for(int i=0; i<k; i++){
        if(!visited[i]){
            visited[i] = true;
            permutations(currBox + 1, currItem + 1, currAns + (char)('0' + i + 1), visited, n, k);
            visited[i] = false;
        }
    }
    
    permutations(currBox + 1, currItem, currAns + "0", visited, n, k);
}

int main(){
    int n, k;
    cin>>n>>k;
    
    string currAns = "";
    vector<bool> visited(k, false);
    
    permutations(0, 0, currAns, visited, n, k);
}