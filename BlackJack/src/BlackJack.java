import java.util.Random;
import java.util.Scanner;

//import java.util.*;

public final class BlackJack {

        String[] arrCards = {"2","3","4","5","6","7","8","9","10","W","J","K","A"};
        String[] arrSuits = {"\u2665"/*♥*/,"\u2666"/*♦*/,"\u2663"/*♣*/,"\u2660"/*♠*/};
        int[] arrValues = {2,3,4,5,6,7,8,9,10,10,10,10,11};
        String[] arrDeck = {};
        int[] arrDeckVal = {};
    
    public static void main(String[] args){
        new BlackJack();
    }
        
    public BlackJack(){
        int userSum=0, rep=0, ans=1;
        PrintArray();

        do {
            String repCard = Roll();
            int repVal = rollVal(repCard);
            System.out.println("Card: "+repCard+" [Value: "+repVal+"]");
            int aceVal=0;
            if(repVal==11){
                if(userSum+11==21 || userSum+1==21){
                    System.out.println("Rep["+rep+1+"] Result: 21!!!");
                    break;
                } else if(userSum+11>21) {
                    aceVal=1;
                    repVal=0;
                } else {
                    aceVal=11;
                    repVal=0;
                }
            } else {
                aceVal=0;
            }
            userSum = userSum+repVal+aceVal;
            
            if(userSum==21){
                System.out.println("Rep["+rep+1+"] Result: 21!!!");
                break;
            } else if(ans==0){
                System.out.println("Score: "+userSum);
                break;
            } else if(userSum>21){
                System.out.println("Too bad. Your result: "+userSum);
                break;
            } else {
                System.out.println("Rep["+rep+"] Result: "+userSum);
            }
                
            if(rep>=1){
                Scanner scan = new Scanner(System.in);
                System.out.print("\nAnother card?[1/0] ");
                ans = scan.nextInt();
                if(ans==0){
                    System.out.println("Score: "+userSum);
                    break;
                }
                }
            rep=rep+1;
        } while (userSum < 21);
    }
    
    public void PrintArray(){
        arrDeck = new String[52];
        arrDeckVal = new int[52];
        int deckPos = 0;
        for(int i=0; i<arrCards.length;i++){
            for (String arrSuit : arrSuits) {
                arrDeck[deckPos] = arrSuit + arrCards[i];
                arrDeckVal[deckPos] = arrValues[i];
                deckPos++;
            }
        }
    }
    
    public String Roll(){
        Random rn = new Random();
        int rollCard = rn.nextInt(arrDeck.length);
        do {
            rollCard = rn.nextInt(arrDeck.length);
        } while(arrDeck[rollCard] == null);
        return arrDeck[rollCard];
    }
    
    public int rollVal(String rVal){
        int cardPos = getStrArrIndex(arrDeck,rVal);
        int rollVal = arrDeckVal[cardPos];
        arrDeck[cardPos]=null;
        return rollVal;
    }
    
    
    
    public int getIntArrIndex(int[] arr,int value) {
            int k=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==value){
                    k=i;
                    break;
                }
            }
        return k;
    }
    public int getStrArrIndex(String[] arr,String value) {
            int k=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==value){
                    k=i;
                    break;
                }
            }
        return k;
    }
}