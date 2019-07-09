// [1,2,3,3,3,3,4,5],3
// [3],3
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int firstK = getFirstK(array, k);
        int lastK = getLastK(array, k);
        if (firstK == -1 && lastK == -1) {
            return 0;
        }
        return firstK == lastK ? 1 : lastK - firstK + 1;
    }

    private int getFirstK(int[] array, int k) {
        int s = 0, e = array.length - 1;
        int res = -1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (array[mid] == k) {
                if (mid > 0 && array[mid - 1] != k || mid == 0) {
                    res = mid;
                    break;
                } else {
                    e = mid - 1;
                }
            } else if (array[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return res;
    }

    private int getLastK(int[] array, int k) {
        int s = 0, e = array.length - 1;
        int res = -1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (array[mid] == k) {
                if (mid < e && array[mid + 1] != k || mid == e) {
                    res = mid;
                    break;
                } else {
                    s = mid + 1;
                }
            } else if (array[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return res;
    }
}