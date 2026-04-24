import java.util.*;

public class Processor {

    public static void process(List<Event> events, String regNo) throws Exception {

        // Step 1: Remove duplicates + calculate scores together
        Set<String> seen = new HashSet<>();
        Map<String, Integer> scores = new HashMap<>();

        for (Event e : events) {

            // Unique key for duplicate detection
            String key = e.roundId + "|" + e.participant;

            // Process only if not duplicate
            if (!seen.contains(key)) {
                seen.add(key);

                // Add score
                scores.put(e.participant,
                        scores.getOrDefault(e.participant, 0) + e.score);
            }
        }

        // Step 2: Sort leaderboard (descending order)
        List<Map.Entry<String, Integer>> leaderboard =
                new ArrayList<>(scores.entrySet());

        leaderboard.sort((a, b) -> b.getValue() - a.getValue());

        // Step 3: Print leaderboard and total score
        int total = 0;

        System.out.println("\nLeaderboard:");
        for (Map.Entry<String, Integer> entry : leaderboard) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            total += entry.getValue();
        }

        System.out.println("Total Score: " + total);

        // Step 4: Submit result
        SubmitService.submit(regNo, leaderboard);
    }
}