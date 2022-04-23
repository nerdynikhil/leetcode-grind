class Solution {
public:
    
    unordered_map<string, string> mp;

    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        string key = "http://lc/"+mp.size();
        mp[key]=longUrl;
        return key;
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        return mp[shortUrl];
    }
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));