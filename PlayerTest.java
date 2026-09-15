public class PlayerTest {

/*    static void check(boolean condition, String testName) {
        if (!condition) {
            throw new AssertionError("FAILED: " + testName);
        }
        System.out.println("PASSED: " + testName);
    }*/

    static void countScoreOfTwoTens() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.addCard("10♠");
        testPlayer.addCard("10♥");
        assert testPlayer.countScores() == 20; 
    }

    static void countCardsAmount() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.addCard("10♠");
        testPlayer.addCard("10♥");
        assert testPlayer.cardHand.size() == 2;
    }

    static void countTwoAces() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.addCard("A♠");
        testPlayer.addCard("A♥");
        assert testPlayer.countScores() == 12;
    }

    static void countTooManyAces() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.addCard("A♠");
        testPlayer.addCard("A♥");
        testPlayer.addCard("10♥");
        assert testPlayer.countScores() == 22;
    }

    static void countAceAndKingAs21() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.addCard("A♠");
        testPlayer.addCard("K♥");
        assert testPlayer.countScores() == 21;
    }

    static void countDifferentCards() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.addCard("5♠");
        testPlayer.addCard("6♥");
        testPlayer.addCard("7♣");
        assert testPlayer.countScores() == 18;
    }

    public static void main(String[] args) {
        countScoreOfTwoTens();
        countCardsAmount();
        countTwoAces();
        countTooManyAces();
        countAceAndKingAs21();
        countDifferentCards();

        System.out.println("All tests passed!");
    }
}

