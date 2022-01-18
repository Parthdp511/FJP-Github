#include<iostream>
#include<bits/stdc++.h>
using namespace std;

void permute(int n, int k, vector<int> &boxes, vector<bool> &visited, int placed){
    if(placed == k + 1){
        for(int i=0; i<boxes.size(); i++)
            cout<<boxes[i];
        cout<<endl;
        return;
    }
    
    for(int i=0; i<n; i++){
        if(!visited[i]){
            visited[i] = true;
            boxes[i] = placed;
            permute(n, k, boxes, visited, placed + 1);
            boxes[i] = 0;
            visited[i] = false;
        }
    }
}

void permute(int n, int k){
    vector<int> boxes(n, 0);
    vector<bool> visited(n, false);
    permute(n, k, boxes, visited, 1);
}

int main(){
    
    int n, k;
    cin>>n>>k;
    
    permute(n, k);
    
    return 0;
}