package StringExamples;

// TODO "TDD": test driven development
public class StringDriver {
    public static void main(String[] args) {
        String[] stringList = {"aabbccccaaa", "", "abcd", "abbccc", "uulltttaa", "abbccccc"};
        String[] outputList = {"a2b2c4a3", "", "abcd", "abbccc", "u2l2t3a2", "a1b2c5"};
        for(int i = 0; i < stringList.length; i++){
            System.out.println("Test for String: " + stringList[i]);
            if(StringProblems.compressString(stringList[i]).equals(outputList[i]))
                System.out.println("Success");
            else
                System.out.println("Failure");
        }
    }

    public void permutationTests() {
        String[] string1List = {"", "cat", "test", "b", "a", "", "godcat", "godcat"};
        String[] string2List = {"", "act", "dog", "a", "a", "test", "actdog", "actdod"};
        boolean[] outputList = {false, true, false, false, true, false, true, false};

        // String -> .length()
        // primitive -> .length
        // typically .size()
        for (int i = 0; i < string1List.length; i++) {
            System.out.println("test for strings " + string1List[i] + " " + string2List[i]);
            if (outputList[i] == StringProblems.isPermutation(string1List[i], string2List[i]))
                System.out.println("isPermutation: Success");
            else
                System.out.println("isPermutation: Failure");
            if (outputList[i] == StringProblems.isPermutationOptimized(string1List[i], string2List[i]))
                System.out.println("isPermutationOptimized: Success");
            else
                System.out.println("isPermutationOptimized: Failure");
            if (outputList[i] == StringProblems.isPermutationOptimized2(string1List[i], string2List[i]))
                System.out.println("isPermutationOptimized2: Success");
            else
                System.out.println("isPermutationOptimized2: Failure");
        }
    }

    public void replaceSpacesSimplified() {
        String[] stringList = {"Mr John Smith", " MrJohnSmith", "MrJohnSmith", "MrJohnSmith   "};
        String[] outputList = {"Mr%20John%20Smith", "%20MrJohnSmith", "MrJohnSmith", "MrJohnSmith%20%20%20"};
        for(int i = 0; i < stringList.length; i++) {
            System.out.println("Test for String: " + stringList[i]);
            if(StringProblems.replaceSpacesSimplified(stringList[i]).equals(outputList[i]))
                System.out.println("replaceSpacesSimplified: success");
            else
                System.out.println("replaceSpacesSimplified: failure");
        }
    }

    public void replaceSpaces() {
        String[] stringList = {"Mr John Smith   ", " MrJohnSmith    ", "MrJohnSmith   ", "MrJohnSmith    "};
        int[] lengthList = {13, 12, 11, 14};
        String[] outputList = {"Mr%20John%20Smith", "%20MrJohnSmith", "MrJohnSmith", "MrJohnSmith%20%20%20"};
        for(int i = 0; i < stringList.length; i++) {
            System.out.println("Test for String: " + stringList[i]);
            if(StringProblems.replaceSpacesWithSpecialCharacter(stringList[i], lengthList[i]).equals(outputList[i]))
                System.out.println("replaceSpaces: success");
            else
                System.out.println("replaceSpaces: failure");
        }
    }

}
