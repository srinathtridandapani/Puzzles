package solutions;

import java.util.Stack;

public class ParseCompiler {

    static Stack<String> tagsStack = new Stack<>();

    public static String parseHtml(String inputString) {
        StringBuilder output = new StringBuilder();

        char[] inputStringArray = inputString.toCharArray();

        //Stack<StringBuilder> tagsStack = new Stack<>();
        StringBuilder currHtmlTag = new StringBuilder();

        int currenMaxOutputLength = 30;
        for (int i = 0; i < inputStringArray.length; i++) {
            if (currenMaxOutputLength != 0) {
                if (inputStringArray[i] == '>') {
                    currHtmlTag.append(inputStringArray[i]);
                    trackHtmlTags(tagsStack, currHtmlTag);
                    int currHtmlTagLength = tagsStack.peek().length();
                    currenMaxOutputLength = currenMaxOutputLength - (currHtmlTagLength);
                    output.append('>');
                } else {
                    currHtmlTag.append(inputStringArray[i]);
                    currenMaxOutputLength--;
                    output.append(inputStringArray[i]);
                }
            } else{
                while(!tagsStack.empty()){
                    output.append(tagsStack.pop());
                }
            }
        }

        return output.toString();
    }

    private static int trackHtmlTags(Stack<String> tagsStack, StringBuilder currHtmlTag) {

        System.out.println(currHtmlTag);
        char[] tagArray = currHtmlTag.toString().toCharArray();

        char[] correspondingClosingHtmlTag = new char[tagArray.length + 1];

        for (int i = 0, j = 0; i < tagArray.length; i++, j++) {
            if (i == 1) {
                correspondingClosingHtmlTag[1] = '/';
                correspondingClosingHtmlTag[2] = tagArray[i];
                j = 2;
            } else {
                correspondingClosingHtmlTag[j] = tagArray[i];
            }
        }
        System.out.println(String.valueOf(correspondingClosingHtmlTag));
        tagsStack.push(String.valueOf(correspondingClosingHtmlTag));
        return correspondingClosingHtmlTag.length;
    }

    public static void main(String[] args) {
        String testInput1 = "<div> this <form> test input string is pretty simple </form></div>";
        System.out.println(parseHtml(testInput1));
    }
}
