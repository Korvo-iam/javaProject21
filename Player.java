import java.util.ArrayList;


class Player {
    String name;
    ArrayList<String> cardHand;

    
    public Player(String name) {
        this.name = name;
        this.cardHand = new ArrayList<>();
    }


    public void showCards(String player) {
        System.out.println(this.name + ":");

        for (int row = 0; row < 5; row++) {

            for (int i = 0; i < cardHand.size(); i++) {

                boolean hidden = player.equals("dealer") && i == 1;

                String card = hidden ? "?" : cardHand.get(i);

                if (row == 0) {
                    System.out.print("┌──────┐  ");
                } 
                else if (row == 1) {
                    System.out.printf("│      │  ");
                } 
                else if (row == 2) {
                    if (hidden) {
                        System.out.printf("│  %s?  │  ", card);
                    } else if (card.startsWith("10")) {
                        System.out.printf("│ %s  │  ", card);
                    } else {
                        System.out.printf("│  %s  │  ", card);
                    }
                }
                else if (row == 3) {
                    System.out.print("│      │  ");
                } 
                else {
                    System.out.print("└──────┘  ");
                }
            }

            System.out.println();
        }
    }



    public void addCard(String cardName){
        this.cardHand.add(cardName);
    }


    public int countScores() {
        int score = 0;

        for (String element : this.cardHand) {
            String card = element.substring(0, element.length() - 1);

            if (card.equals("J") || card.equals("Q") || card.equals("K")) {
                score += 10;
            } else if (card.equals("A")) {
                score += 11;
            } else {
                score += Integer.parseInt(card);
            }
        }

        return score;
    }


    public void showScores(){
        System.out.printf("Счёт игрока : %s \n", countScores());
    }
}