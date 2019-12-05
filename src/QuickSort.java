public class QuickSort implements SortingAlgorithm {


    public void sort(int[] qArr) {
        sort(qArr, 0, qArr.length-1);
    }

    public void sort(int []qArr, int min, int max){
        if (min < max){
            int mid = split(qArr, min, max);
            sort(qArr,min, mid-1);
            sort(qArr, mid+1, max);
        }
    }

    public int split(int [] qArr, int min, int max){
        int i = min + 1;
        int j= max;
        int p = min;

        while(i <= j ){
            while (qArr[i]< qArr [p] && i <= max){
                i++;
            }
            while ( j > min && qArr[j] >= qArr[p]){
                j--;
            }
            if (i<=j){
                swap(qArr, i, j);
                j--;
                i++;
            }

        }
        swap (qArr, j, p);
        return j;
    }

    public void swap (int[] qArr, int x, int y){
        int t = qArr[x];
        qArr[x]= qArr[y];
        qArr[y]= t;
    }

}
