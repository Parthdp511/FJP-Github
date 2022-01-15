// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function template for C++

class Solution
{
    public:
    //Function to find most frequent word in an array of strings.
    string mostFrequentWord(string arr[], int n) 
    {
        // code here
        unordered_map<string,int> m;
        for(int i=0;i<n;i++)
        {
            m[arr[i]]++;
        }
        int Max=INT_MIN;
        string s="";
        for(int i=0;i<n;i++)
        {
         	if(m[arr[i]]>=Max)
            {
                Max=m[arr[i]];
                s=arr[i];
                m[arr[i]]=0;   
            }
        }
        return s;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;

        string arr[n];
        for (int i = 0; i < n; i++) cin >> arr[i];
        Solution obj;
        cout << obj.mostFrequentWord(arr, n) << endl;
    }
    return 0;
}
  // } Driver Code Ends