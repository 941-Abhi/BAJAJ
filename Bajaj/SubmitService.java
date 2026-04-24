import java.net.URI;
import java.net.http.*;
import java.util.*;
import com.google.gson.Gson;

public class SubmitService {

    static HttpClient client = HttpClient.newHttpClient();
    static Gson gson = new Gson();

    public static void submit(String regNo,
            List<Map.Entry<String, Integer>> leaderboard) throws Exception {

        // Step 1: Prepare leaderboard list
        List<Map<String, Object>> list = new ArrayList<>();

        for (Map.Entry<String, Integer> e : leaderboard) {
            Map<String, Object> obj = new HashMap<>();
            obj.put("participant", e.getKey());
            obj.put("totalScore", e.getValue());
            list.add(obj);
        }

        // Step 2: Prepare request body
        Map<String, Object> body = new HashMap<>();
        body.put("regNo", regNo);
        body.put("leaderboard", list);

        // Step 3: Convert to JSON
        String json = gson.toJson(body);

        // Step 4: Create POST request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://devapigw.vidalhealthtpa.com/srm-quiz-task/quiz/submit"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Step 5: Send request
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        // Step 6: Print response
        System.out.println("Submission Response: " + response.body());
    }
}