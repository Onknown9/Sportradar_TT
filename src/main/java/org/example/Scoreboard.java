package org.example;

import java.util.*;

public class Scoreboard {
    private List<Match> ongoingMatches;

    public Scoreboard() {
        this.ongoingMatches = new ArrayList<>();
    }

    // 1. Start a new match
    public void startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        ongoingMatches.add(match);
    }

    // 2. Update score of a match
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (Match match : ongoingMatches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.updateScore(homeScore, awayScore);
                return;
            }
        }
        throw new IllegalArgumentException("Match not found!");
    }

    // 3. Finish match
    public void finishMatch(String homeTeam, String awayTeam) {
        ongoingMatches.removeIf(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam));
    }

    // 4. Get summary of matches sorted by total score, then by recency
    public List<String> getMatchSummary() {
        List<Match> sortedMatches = new ArrayList<>(ongoingMatches);
        sortedMatches.sort((m1, m2) -> {
            // Sort by total score (descending)
            int scoreComparison = Integer.compare(m2.getTotalScore(), m1.getTotalScore());
            if (scoreComparison == 0) {
                // If scores are equal, sort by most recent match (descending)
                return m2.getStartTime().compareTo(m1.getStartTime());
            }
            return scoreComparison;
        });

        List<String> matchSummaries = new ArrayList<>();
        for (Match match : sortedMatches) {
            matchSummaries.add(match.getMatchSummary());
        }

        return matchSummaries;
    }
}
