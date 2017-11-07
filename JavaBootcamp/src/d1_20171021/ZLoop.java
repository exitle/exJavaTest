package d1_20171021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by exitle on 21.10.17.
 */
public class ZLoop {

    public void a1(){
        for(int i=5; i<=10; i++){
            System.out.println(i);
        }
    }

    public void a2(){
        for(int i =0; i<5; i++){
            System.out.println("Hello");
        }
    }

    public void a3(){
        for(int i=5;i<=50;i++){
            if(i%2==0) System.out.println(i);
        }
    }

    public void a4(){
        for(int i=50;i>=10;i--){
            System.out.println(i);
        }
    }

    public void a5(){
        Scanner sc = new Scanner(System.in);
        int res=0;
        for(int i =1;i<=sc.nextInt();i++){
            res+=i;
        }
    }

    public void a6(int res){
        Scanner sc = new Scanner(System.in);
        int scInt;
        while(true){
            scInt = sc.nextInt();
            if (scInt<res){
                System.out.println("Mniejsza");
            } else if(scInt>res){
                System.out.println("Większa");
            } else {
                System.out.println("Koniec");
                break;
            }
        }
    }

    public void a7(){
        List<Integer> numbers = new ArrayList<>();
        int los;
        for (int i=0;i<6;i++){
            los = 1 + (int)(Math.random() * ((49 - 1) + 1));
            if(numbers.indexOf(los)==-1){
                numbers.add(los);
            }
        }
        System.out.println(numbers.toString());
    }

    public void a8(String pwd){
        Scanner sc = new Scanner(System.in);
        String input;
        while(true){
            input = sc.next();
            if(!pwd.equals(input)){
                System.out.println("Invalid password.");
            } else {
                System.out.println("Password accepted");
                break;
            }
        }
    }

    public void a9(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert int");
        int scInt = sc.nextInt();
        int res=1;
        for(int i =1;i<=scInt;i++){
            res*=i;
        }
        System.out.println(res);
    }

}
