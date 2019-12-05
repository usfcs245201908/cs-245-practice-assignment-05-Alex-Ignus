import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort implements SortingAlgorithm {

    @Override
    public void sort(int[] mergeArr) {
        if ( mergeArr.length <= 1) {
            return;
        }
        int[] x = arrPartA( mergeArr);
        int[] y = arrPartB( mergeArr);

        sort(x);
        sort(y);


        merge( mergeArr, x, y);
    }
    public static int[] arrPartA(int[] array) {
        return Arrays.stream(array, 0, array.length / 2).toArray();

    }

    public static int[] arrPartB(int[] array) {
        return IntStream.range(0, array.length - array.length / 2).map(i -> array[i + array.length / 2]).toArray();
    }
    public static void merge(int[] result,
                             int[] x, int[] y) {
        int xIndex = 0;
        int yIndex = 0;

        for (int i = 0; i < result.length; i++) {
            if (yIndex >= y.length || (xIndex < x.length &&
                    x[xIndex] <= y[yIndex])) {
                result[i] = x[xIndex];    // take from left
                xIndex++;
            } else {
                result[i] = y[yIndex];   // take from right
                yIndex++;
            }
        }
    }
}