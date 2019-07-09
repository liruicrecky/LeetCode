public class Solution {
    public int InversePairs(int [] array) {
        int len = array.length;
        if (len == 0 || array == null) {
            return 0;
        }
        return mergeSort(array, 0, len - 1);
    }

    private int mergeSort(int[] array, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = (start + end) >> 1;
        int leftCount = mergeSort(array, start, mid);
        int rightCount = mergeSort(array, mid + 1, end);

        int i = mid, j = end;
        int[] copy = new int[end - start + 1];
        int copyIndex = end - start;
        int count = 0;

        while (start <= i && mid + 1 <= j) {
            if (array[i] > array[j]) {
                copy[copyIndex--] = array[i--];
                count += j - mid;
                if (count > 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[copyIndex--] = array[j--];
            }
        }

        while (i >= start) {
            copy[copyIndex--] = array[i--];
        }

        while (j >= mid + 1) {
            copy[copyIndex--] = array[j--];
        }

        i = 0;
        while (start <= end) {
            array[start++] = copy[i++];
        }

        return (leftCount + rightCount + count) % 1000000007;
    }
}