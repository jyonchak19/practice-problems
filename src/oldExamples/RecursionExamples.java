package oldExamples;

public class RecursionExamples {
    public static void main(String[] args){

    }

    public int triangle(int rows) {
        if(rows == 0)
            return 0;
        return rows + triangle(rows - 1);
    }

    public int strCount(String str, String sub){
        int strLen = str.length();
        int subLen = sub.length();
        if (strLen < subLen)
            return 0;
        if (str.substring(0,subLen).equals(sub))
            return strCount(str.substring(subLen), sub) + 1;
        else
            return strCount(str.substring(1), sub);
    }
}
