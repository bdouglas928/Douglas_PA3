package com.company;
import java.security.SecureRandom;
import java.util.Scanner;
public class Main {

    public static double newQuestion(double num1, double num2, int questionType) {
        double answer = 0.0;
        switch(questionType) {
            case 1:
                System.out.println("How much is " + num1 + " + " + num2);
                answer = num1 + num2;
                break;
            case 2:
                System.out.println("How much is " + num1 + " times " + num2);
                answer = num1 * num2;
                break;
            case 3:
                System.out.println("How much is " + num1 + " - " + num2);
                answer = num1 - num2;
                break;
            case 4:
                if(num2 == 0) {
                    num2 += 1;
                }
                System.out.println("How much is " + num1 + " / " + num2);
                answer = (num1/num2);
                break;
        }
        return answer;
    }

    public static int randVal(SecureRandom rand, int max) {
        int x = rand.nextInt(max);
        return x;
    }

    public static void correct(SecureRandom rand) {
        int a = rand.nextInt(4);
        switch(a) {
            case 0:
                System.out.println("Very good!");
                break;
            case 1:
                System.out.println("Excellent");
                break;
            case 2:
                System.out.println("Nice work!");
                break;
            case 3:
                System.out.println("Keep up the good work!");
                break;
            default:
                System.out.println("Error in correct");
        }
    }

    public static void incorrect(SecureRandom rand){
        int a = rand.nextInt(4);
        switch(a) {
            case 0:
                System.out.println("No. Please try again.");
                break;
            case 1:
                System.out.println("Wrong. Try once more.");
                break;
            case 2:
                System.out.println("Don't give up!");
                break;
            case 3:
                System.out.println("No. Keep trying.");
                break;
            default:
                System.out.println("Error in incorrect");
        }
    }
    public static double playingLevel(int userLevel, SecureRandom randNum) {
        double num = 0;
        switch(userLevel) {
            case 1:
                num = randVal(randNum, 10);
                break;
            case 2:
                num = randVal(randNum, 100);
                break;
            case 3:
                num = randVal(randNum, 1000);
                break;
            case 4:
                num = randVal(randNum, 10000);
                break;
            default:
                System.out.println("Invalid");
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        SecureRandom randNum = new SecureRandom();
        double num = 0;
        double num0 = 0;
        double percentage;
        double answer;
        int level;
        double solution;
        int arithmetic;
        int newArithmetic;
        int runAgain = 0;
        while(runAgain != 1) {
            int correct = 0;
            int incorrect = 0;
            System.out.println("Enter difficulty level\n1 - Single Digit Numbers\n2 - Two Digit Numbers\n3 - Three Digit Numbers\n4 - Four Digit Numbers");
            level = scnr.nextInt();
            System.out.print("1 - Addition\n2 - Multiplication\n3 - Subtraction\n4 - Division\n5 - Mixture\nChoice: ");
            arithmetic = scnr.nextInt();
            for(int i = 0; i < 10; i++) {
            num = playingLevel(level, randNum);
            num0 = playingLevel(level, randNum);
                if(arithmetic == 5) {
                    newArithmetic = randNum.nextInt(4) + 1;
                    solution = newQuestion(num, num0, newArithmetic);
                }
                else {
                    solution = newQuestion(num, num0, arithmetic);
                }
                answer = scnr.nextDouble();
                if (answer != solution) {
                    incorrect(randNum);
                    incorrect += 1;
                }
                if (answer == solution) {
                    correct(randNum);
                    correct += 1;
                }
            }
            System.out.println("\nYou got " + correct + "/10 questions correct and " + incorrect + "/10 incorrect");
            percentage = ((double) correct / 10.0);
            if (percentage < .75) {
                System.out.println("Please ask your teacher for extra help.\n");
            }
            else {
                System.out.println("Congratulations, you are ready to go to the next level!\n");
            }
            System.out.print("Would you like to play again?\n0 - Play Again\n1 - Quit\nChoice: ");
            runAgain = scnr.nextInt();
        }
    }
}
