#include<iostream>
 #include<vector>
 using namespace std;
 
 // -----------------------------------------------------
 // This is a functional problem. Only this function has to be written
 // This function takes as input an integer
 // It should return the required output
 
 void factors(int n, vector<vector<int>> &ans, vector<int> currAns, int permn, int idx){
     if(n == 1){
         ans.push_back(currAns);
         return;
     }
     
     for(int i=idx; i<=n && i<permn; i++){
         if( n % i == 0 ){
             currAns.push_back(i);
             factors(n/i, ans, currAns, permn, i);
             currAns.pop_back();
         }
     }
 }
 
 vector<vector<int>> getFactors(int n) {
     //Write your code here
    vector<vector<int>> ans;
    vector<int> currAns;
     
    if(n == 1)  return ans;
    
    factors(n, ans, currAns, n, 2);
    
    return ans;
 }
 
 void display(vector<int>& res){
     cout<<"[";
     for(int i=0;i<res.size();i++){
         cout<<res[i];
         if(i!=res.size()-1){
             cout<<", ";
         }
     }
     cout<<"]"<<endl;
 }
 int main(int argc,char** argv){
     int n;
     cin>>n;
 
     vector<vector<int>> res=getFactors(n);
     for(vector<int> v:res){
         display(v);
     }
     
 }