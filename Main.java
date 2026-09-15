import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean gameOver;
    static Random random = new Random();
    static ArrayList<String> cards = new ArrayList<>(Arrays.asList(
        "2♠","2♥","2♦","2♣",
        "3♠","3♥","3♦","3♣",
        "4♠","4♥","4♦","4♣",
        "5♠","5♥","5♦","5♣",
        "6♠","6♥","6♦","6♣",
        "7♠","7♥","7♦","7♣",
        "8♠","8♥","8♦","8♣",
        "9♠","9♥","9♦","9♣",
        "10♠","10♥","10♦","10♣",
        "J♠","J♥","J♦","J♣",
        "Q♠","Q♥","Q♦","Q♣",
        "K♠","K♥","K♦","K♣",
        "A♠","A♥","A♦","A♣"));
    static Player dealerHand;
    static Player playerHand;
    public static void main(String[] args) {
    startGame();
    }


    public static void startGame(){
        dealerHand = new Player("dealer");
        playerHand = new Player("player");
        dealerHand.addCard(cards.remove(random.nextInt(cards.size())));
        playerHand.addCard(cards.remove(random.nextInt(cards.size())));
        dealerHand.addCard(cards.remove(random.nextInt(cards.size())));
        playerHand.addCard(cards.remove(random.nextInt(cards.size())));
        playerHand.showCards("player", false);
        dealerHand.showCards("dealer", false);
        continueGame();
    }


    public static boolean ifPlayerWon(){
        if (dealerHand.countScores()>playerHand.countScores() || playerHand.countScores()>21){
            //System.out.printf("Карты игрока %s : %s  \n", dealerHand.name, dealerHand.cardHand);
            return false;
        }
        else{
            return true;   
        }
    }


    public static void continueGame(){
        
        gameOver = false;
        while (!gameOver){
            showGame();
            System.out.println("Вы хотите взять карту? y/n\n");
            String respond = scanner.nextLine();
            if(respond.equals("y")){
                playerHand.addCard(cards.remove(random.nextInt(cards.size())));
                playerHand.showCards("player", gameOver);
                dealerHand.showCards("dealer", gameOver);
            }
            if (playerHand.countScores() > 21 || respond.equals("n")){
                gameOver = true;
            }
        }
        showGame();
        if(ifPlayerWon()){
            System.out.println("You won!");
        }
        else{
            System.out.println("Good luck next time!");
        }
        //playerHand.showCards("player");
        //dealerHand.showCards("player");
        System.out.println("game over");
    }
    
    
    public static void showGame() {
        clearScreen();
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║            BLACKJACK             ║");
        System.out.println("╠══════════════════════════════════╣");

        dealerHand.showCards("dealer", gameOver);
        System.out.println();
        playerHand.showCards("player", gameOver);
        playerHand.showScores();
        System.out.println("╚══════════════════════════════════╝");
    }
    
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
