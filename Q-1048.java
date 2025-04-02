class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int maxLen = 1;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        Map<String, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++){
            String word = words[i];
            mpp.put(word, 1);
            for (int j = 0; j < word.length(); j++){
                String subWord = word.substring(0, j) + word.substring(j + 1, word.length());
                if (mpp.containsKey(subWord)){
                    mpp.put(word, 1 + mpp.get(subWord));
                    maxLen = Math.max(maxLen, mpp.get(word));
                }
            }
        }

        return maxLen;
    }
    // private int helper(String[] words, int idx, int prev){
    //     if (idx == words.length) return 0;

    //     int skip = helper(words, idx + 1, prev);
    //     int take = 0;

    //     if (prev == -1 || isValid(words[prev], words[idx])){
    //         take = 1 + helper(words, idx + 1, idx);
    //     }

    //     return Math.max(skip, take);
    // }
    // private boolean isValid(String s1, String s2){
    //     if (s2.length() != s1.length() + 1) return false;

    //     int i = 0;
    //     int j = 0;
    //     int count = 0;

    //     while (i < s1.length()){
    //         if (s1.charAt(i) != s2.charAt(j)){
    //             count++;
    //             j++;

    //             if (count == 2) return false;
    //             continue;
    //         }
    //         i++;
    //         j++;
    //     }

    //     return true;
    // }
}
