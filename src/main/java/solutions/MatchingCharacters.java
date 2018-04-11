package solutions;

import java.util.Stack;

public class MatchingCharacters {

    public static int matchCharacters(String inputString){
        if(inputString == null || inputString.isEmpty() || inputString.length() == 1){
            return -1;
        }
        int offset = 32;
        int matchedIndex = 0;
        char[] inputStringArray = inputString.toCharArray();
        Stack<Character> tempStack = new Stack<>();
        for(int i=0; i<inputStringArray.length; i++){
            if((int)inputStringArray[i] > 64 && (int)inputStringArray[i] < 123){
                if(tempStack.empty() || (int)inputStringArray[i] <=90){
                    tempStack.push(inputStringArray[i]);
                } else{
                    if((int)tempStack.peek() == (int)inputStringArray[i] - offset) {
                        tempStack.pop();
                        matchedIndex = i;
                    } else{
                        return -1;
                    }
                }
            } else{
                return -1;
            }
        }
        return matchedIndex;
    }

    /**
     * Program to return last matched index.
     * Rules are, a cap should be followed by cap or its matching character. If this rule breaks, return -1.
     * @param args
     */
    public static void main(String[] args) {
        String testInput1 = "ABba";
        String testInput2 = "ABbCca";
        String testInput3 = "949939";

        System.out.println(matchCharacters(testInput1));
        System.out.println(matchCharacters(testInput2));
        System.out.println(matchCharacters(testInput3));
    }
}
