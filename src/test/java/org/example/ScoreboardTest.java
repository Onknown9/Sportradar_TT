package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreboardTest {

    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void testStartMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        List<String> summary = scoreboard.getMatchSummary();
        assertEquals(1, summary.size());
        assertTrue(summary.get(0).contains("Mexico 0 - 0 Canada"));
    }

    @Test
    public void testUpdateScore() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 3, 2);
        List<String> summary = scoreboard.getMatchSummary();
        assertEquals(1, summary.size());
        assertTrue(summary.get(0).contains("Mexico 3 - 2 Canada"));
    }

    @Test
    public void testFinishMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 3, 2);
        scoreboard.finishMatch("Mexico", "Canada");
        List<String> summary = scoreboard.getMatchSummary();
        assertEquals(0, summary.size());
    }

    @Test
    public void testMatchSummaryOrdering() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);

        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", 10, 2);

        scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore("Germany", "France", 2, 2);

        List<String> summary = scoreboard.getMatchSummary();
        assertEquals("Spain 10 - 2 Brazil", summary.get(0));
        assertEquals("Mexico 0 - 5 Canada", summary.get(1));
        assertEquals("Germany 2 - 2 France", summary.get(2));
    }
}
