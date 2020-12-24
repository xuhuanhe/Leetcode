/*
187. Repeated DNA Sequences
Medium

1051

323

Add to List

Share
All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

0 <= s.length <= 105
s[i] is 'A', 'C', 'G', or 'T'
*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for(int i = 0 ; i +9 < s.length();i++ ){
            if(!set.contains(s.substring(i,i+10))){
                set.add(s.substring(i,i+10));
            }else{
                seen.add(s.substring(i,i+10));
            }
        }
        return new ArrayList(seen);
    }
}