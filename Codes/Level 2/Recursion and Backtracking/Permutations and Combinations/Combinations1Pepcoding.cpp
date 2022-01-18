#include<bits/stdc++.h>
using namespace std;

void combinations(int cb, int tb, int ssf, int ts, string currAns){
    if(cb > tb){
        if(ssf == ts)
            cout<<currAns<<endl;
        return;
    }
    
    if(ssf < ts)    combinations(cb + 1, tb, ssf + 1, ts, currAns + "i");
    combinations(cb + 1, tb, ssf, ts, currAns + "-");
}

int main(){
    int n, k;
    cin>>n>>k;
    
    combinations(1, n, 0, k, "");
}