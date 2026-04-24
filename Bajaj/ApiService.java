import java.net.URI;
import java.net.http.*;
import com.google.gson.Gson;

public class ApiService {

    static HttpClient client = HttpClient.newHttpClient();
    static Gson gson = new Gson();

    public static ApiResponse fetchData(String regNo, int poll) throws Exception {

        String url = "https://devapigw.vidalhealthtpa.com/srm-quiz-task/quiz/messages"
                + "?regNo=" + regNo + "&poll=" + poll;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), ApiResponse.class);
    }
}