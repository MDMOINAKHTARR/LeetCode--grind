class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Convert banned list to a set for fast lookup
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Clean the paragraph: remove punctuation, make lowercase, split by spaces
        String[] words = paragraph.toLowerCase().replaceAll("[!?',;.]"," ").split("\\s+");

        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
        }

        // Find the word with the highest frequency
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommon;
    }
}
