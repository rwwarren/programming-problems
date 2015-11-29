import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FootballScoresTest {

    @Test
    public void testGetWays() throws Exception {
        {
            int ways = FootballScores.getWays(0);
            assertEquals(0, ways);
        }
        {
            int ways = FootballScores.getWays(1);
            assertEquals(0, ways);
        }
        {
            int ways = FootballScores.getWays(2);
            assertEquals(1, ways);
        }
        {
            int ways = FootballScores.getWays(3);
            assertEquals(1, ways);
        }
        {
            int ways = FootballScores.getWays(4);
            assertEquals(1, ways);
        }
        {
            int ways = FootballScores.getWays(5);
            assertEquals(2, ways);
        }
    }

    @Test
    public void testGetWaysAboveSix(){
        {
            int ways = FootballScores.getWays(6);
            assertEquals(3, ways);
        }
    }
}