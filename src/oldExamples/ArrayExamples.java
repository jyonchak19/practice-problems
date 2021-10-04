package oldExamples;

public class ArrayExamples {

    // "Hello there man"
    // "olleH ereht nam"
    // String[] str = s.split(" ");
    // s.trim()
    // sb.append("hello")
    public String reverseWords(String s) {
        String[] strs = s.split(" "); // ["Hello", "there", "man"]
        StringBuilder toReturn = new StringBuilder();
        for(String str: strs) { // "olleH ereht nam "
            toReturn.append(reverse(str));
            toReturn.append(" ");
        }
        return toReturn.toString().trim();
    }

    String reverse(String str) {
        char[] c = str.toCharArray();
        int end = c.length - 1, start = 0;
        while(start < end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        return new String(c);
    }
    // there is someone going on a roadtrip in a car
    // the roadtrip consists of different points n+1, each with different altitudes
    // gain[i] net gain in altitude between points i and i + 1
    // ex gain = [-5,1,       5, 0, -7  ] (length 5)
    // altitudes = [0, -5, -4, 1, 1, -6] (length 6)
    // output 1 (highest altitude)
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;
        //altitudes = [0, -5, -4, 1, 1, -6]
        for(int i = 0; i < gain.length; i++) { // i= 0,1,2,3,4,5
            altitude = altitude + gain[i];
            if(altitude > highest)
                highest = altitude;
        }
        return highest;
    }
    // nums = [3,5,5,2]
    // find max value of (nums[1]-1)*(nums[j]-1)
    // 12, bc i=2, j=1
    public int maxProduct(int[] nums) {
        int highest = 0, secondHighest = 0;
        // highest = 5
        // secondHighest = 4
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= highest) {
                secondHighest = highest;
                highest = nums[i];
            }
        }
        return (highest - 1) * (secondHighest - 1);
    }
}
