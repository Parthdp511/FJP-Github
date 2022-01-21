#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void permute(vector<char> &v, vector<bool> &visited, string s, string ans){
	if(ans.size() == s.size()){
		if(ans < s)
			cout<<ans<<endl;
		return;
	}

	for(int i=0; i<v.size(); i++){
		if(visited[i] == false){
			visited[i] = true;
			permute(v, visited, s, ans + v[i]);
			visited[i] = false;
		}
	}
}

int main() {
	string s;
	cin>>s;
	vector<char> v;
	for(auto c:s)	v.push_back(c);
	sort(v.begin(), v.end());
	vector<bool> visited(s.size(), false);
	permute(v, visited, s, "");
	return 0;
}