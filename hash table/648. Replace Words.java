class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(String each: dictionary){
            set.add(each);
        }
        for(String word: sentence.split("\\s+")){
            String sub= "";
            for(int i = 1 ; i <= word.length() ; i++){
                sub = word.substring(0,i);
                if(set.contains(sub))
                    break;
            }
            if(sb.length() > 0) sb.append(" ");
            sb.append(sub);
        }
        return sb.toString();
    }
}