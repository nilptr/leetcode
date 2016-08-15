public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomChars = new HashMap<>();
        Map<Character, Integer> magazineChars = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            if (ransomChars.containsKey(c)) ransomChars.put(c, ransomChars.get(c) + 1);
            else ransomChars.put(c, 1);
        }
        for (char c : magazine.toCharArray()) {
            if (magazineChars.containsKey(c)) magazineChars.put(c, magazineChars.get(c) + 1);
            else magazineChars.put(c, 1);
        }

        for (char c : ransomChars.keySet()) {
            if (ransomChars.get(c) > magazineChars.getOrDefault(c, 0))
                return false;
        }
        return true;
    }
}
