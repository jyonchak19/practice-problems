package oldExamples;

public class TimeComplexityExamples {


    public static void timeComplexityExampleOne(int N){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                count++;
            }
        }
    }
    public static void timeComplexityExampleTwo(int N){
        int count = 0;
        for (int i = N; i > 0; i /= 2) {
            for (int j = 0; j < i; j++) {
                count++; // constant
            }
        }
    }

    public static void timeComplexityExampleThree(int N){
        timeComplexityExampleOne(N);
        int count = 0;
        for (int i = 0; i < N; i ++){
            count += i;
        }
    }
}

