#include<bits/stdc++.h>
using namespace std;

void combinations(vector<int> &boxes, int currItem, int totalItems, int lastIndex){
    if(currItem == totalItems){
        for(auto box : boxes)
            if(box == 1)    cout<<"i";
            else            cout<<"-";
        cout<<endl;
        return;
    }
    
    for(int i=lastIndex; i < boxes.size(); i++){
        boxes[i] = 1;
        combinations(boxes, currItem + 1, totalItems, i + 1);
        boxes[i] = 0;
    }
}

int main(){
    int n, k;
    cin>>n>>k;
    
    vector<int> boxes(n, 0);
    combinations(boxes, 0, k, 0);
}