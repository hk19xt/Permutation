package Permutation;
import java.util.*;

//This program is to permute a string input by user.
//The permutation method is recursively running until the starting position hits the end position.

public class Permutation {

    /* This method is to swap chars between first and second position.
     * @param words string
     * @param firstPosition and secondPosition
     */
    public String swap(String words, int firstPosition, int secondPosition) {
        char temp;
        char[] swapWord = words.toCharArray();
        char[] newWord; // new array swapped.
        String n; // new word swapped.
        temp = swapWord[firstPosition] ;
        swapWord[firstPosition] = swapWord[secondPosition];
        swapWord[secondPosition] = temp;
        newWord = swapWord;
        n = String.valueOf(newWord);
        return n;
    } //swap

    /* This method is to permute all characters.
     * @param inputWords is string to permute.
     * @param initialPosition is the start character of the words.
     * @param endPosition is the end character of the words.
     */
    private void permute(String inputWords, int initialPosition, int endPosition) {
        int next;
        if (initialPosition == endPosition){ // If the position of the initial character is at the end position,
            System.out.println(inputWords); // then print this word. (There is no permutation.)
        } else {
            for (int i = initialPosition; i <= endPosition; i++) {
                inputWords = swap(inputWords,initialPosition,i);
                next = initialPosition + 1;
                permute(inputWords, next, endPosition); // Permute next position character of the word until the end of the position.
                inputWords = swap(inputWords,initialPosition,i);} // Restore the swapped word to original word again for the next swap.
        }

    }//permute

    public static void main(String[] args) {
        String UserInput;
        Scanner scanner = new Scanner(System.in);
        int start = 0;
        int end = 0;

        System.out.println("Enter your words to permute: ");
        UserInput = scanner.next();

        String input = UserInput;
        int length = input.length();
        end = length;
        Permutation p = new Permutation();
        System.out.println(" ");
        System.out.println("The permuted strings are as follows: ");
        p.permute(input, start, end-1);
    }//main

}//Permutation