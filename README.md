Live Football World Cup Scoreboard
Welcome to the Live Football World Cup Scoreboard! This is a simple library that keeps track of ongoing football matches, updates scores, and gives you a neat summary of the current scores.

What It Does:
Start a match: Add a new match to the scoreboard, starting with a score of 0 - 0.
Update scores: Change the score of a match as it progresses.
Finish a match: Remove a match from the scoreboard once it's over.
Get match summary: See a sorted list of ongoing matches, ordered by total score (highest score first) and by the most recent matches.


Features:
The matches are displayed with their scores.
If two matches have the same total score, the one started more recently will show up first.
It’s all stored in memory, so it's fast and easy to use.


How It Works:
Starting a match: You can start a match by providing the names of the home team and the away team. The score will start at 0 - 0.
Updating the score: As the game progresses, you can update the score for both teams.
Finishing the match: Once the match is over, you can finish it, and it will be removed from the scoreboard.
Getting the scoreboard summary: You can request a sorted list of matches. The matches are sorted by the total score (home + away) first. If two matches have the same total score, the most recently started match will be shown first.


How to Use It:
Clone this repo to your local machine.
Build the project using Maven.
Run the tests to make sure everything works.


Example Use Case:
You can easily track live football matches, update the scores as the game progresses, and get an ordered list of matches based on their scores and recency.
For example, you could have matches like:
Spain 10 - 2 Brazil
Mexico 0 - 5 Canada
Germany 2 - 2 France

And if you asked for the scoreboard summary, you'd get:
Spain 10 - 2 Brazil
Mexico 0 - 5 Canada
Germany 2 - 2 France

Testing:
We’ve also got tests in place to make sure everything works as expected. They check if the matches are added, scores are updated correctly, and the summary is sorted properly.
To run the tests, you can use Maven and run mvn clean test.
Assumptions:
A match is identified by the home team and away team.
If the match is finished, it’s removed from the scoreboard.
The scoreboard always shows the most recent matches first if the scores are the same.
