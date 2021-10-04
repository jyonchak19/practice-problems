public class StackDriver {
    public static void main(String[] args) {

        String[] stringList = {"(())()", "", "(", ")", "(((", "())", ")))", "()))(("};
        int[] correctOutput = {0, 0, 1, 1, 3, 1, 3, 4};

        for (int i = 0; i < stringList.length; i++) {
            System.out.println("test for string " + stringList[i]);
            if (correctOutput[i] == StackExamples.minAddToMakeValid(stringList[i])) {
                System.out.println("Success");
            }
            else {
                System.out.println("Failure");
            }
        }

    }
    public void testIsValidParentheses() {
        String[] stringList = {"{{}}()", "", "(", ")"};

        for (String s: stringList) {
            System.out.println("test for string " + s);
            if (StackExamples.isValidParentheses(s)){
                System.out.println("Success");
            }
            else {
                System.out.println("Failure");
            }
        }
    }
}
