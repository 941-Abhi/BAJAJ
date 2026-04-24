class Event {
    String roundId;
    String participant;
    int score;
}

class ApiResponse {
    String regNo;
    String setId;
    int pollIndex;
    java.util.List<Event> events;
}