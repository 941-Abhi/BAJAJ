# 🏆 Quiz Leaderboard System

## 📌 Project Overview

This project implements a backend application that interacts with an external API to process quiz data and generate a leaderboard. The system handles duplicate API responses, aggregates scores correctly, and submits the final leaderboard.

---

## 🎯 Objective

* Poll API data 10 times
* Handle duplicate entries using `(roundId + participant)`
* Calculate total scores for each participant
* Generate a leaderboard sorted by total score
* Compute total score across all participants
* Submit the final leaderboard

---

## 🧠 Approach

### 1. API Polling

The application calls the API endpoint `/quiz/messages` 10 times using different poll values (0–9) with a delay of 5 seconds between each request.

---

### 2. Handling Duplicates

Duplicate entries are identified using:

```
roundId + participant
```

If a duplicate is found, it is ignored to ensure accurate scoring.

---

### 3. Score Aggregation

* Scores are aggregated per participant
* A HashMap is used to store total scores

---

### 4. Leaderboard Generation

* Participants are sorted in descending order of total score
* Leaderboard is created using a sorted list

---

### 5. Submission

The final leaderboard is sent to the API endpoint `/quiz/submit` in the required JSON format.

---

## 🏗️ Project Structure

```
QuizLeaderboard/
 ├── Main.java
 ├── ApiService.java
 ├── Processor.java
 ├── SubmitService.java
 ├── Model.java
 └── lib/
      └── gson-2.10.1.jar
```

---

## ⚙️ Technologies Used

* Java (JDK 11+)
* HTTP Client (java.net.http)
* Gson (for JSON parsing)

---

## 🚀 How to Run

### 1. Compile

```
javac -cp ".;lib/gson-2.10.1.jar" *.java
```

### 2. Run

```
java -cp ".;lib/gson-2.10.1.jar" Main
```

---

## ⚠️ Important Notes

* Ensure a **5-second delay** between API calls
* Execute exactly **10 polls**
* Remove duplicates correctly
* Submit the leaderboard **only once**
* Use a fresh `regNo` for final submission

---

## ✅ Expected Output

* Correct leaderboard displayed in console
* Total score printed
* API response:

```
{
  "isCorrect": true,
  "message": "Correct!"
}
```

---

## 🧩 Key Learning Outcomes

* Handling duplicate data in distributed systems
* API integration and data processing
* Data aggregation and sorting
* Backend problem-solving

---

## 📌 Conclusion

This project demonstrates how to build a reliable system that processes repeated API data efficiently, ensuring accurate results through proper deduplication and aggregation techniques.

---
