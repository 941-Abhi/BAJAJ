import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String regNo = "231199064";  // ⚠️ replace this

        List<Event> allEvents = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            ApiResponse res = ApiService.fetchData(regNo, i);

            allEvents.addAll(res.events);

            System.out.println("Fetched poll " + i);

            Thread.sleep(5000); // VERY IMPORTANT
        }

        Processor.process(allEvents, regNo);
    }
}