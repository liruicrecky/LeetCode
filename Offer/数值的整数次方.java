public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        
        if (exponent == 1) {
            return base;
        }
        
        if (exponent > 1) {
            double res = Power(base, exponent >> 1);
            res *= res;
            if ((exponent & 1) == 1) {
                res *= base;
            }
            return res;
        }
        
        if (exponent < 0) {
            exponent = -exponent;
            double res = Power(base, exponent);
            return 1 / res;
        }
        return -1;
  }
}