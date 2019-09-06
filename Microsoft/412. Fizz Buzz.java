class Solution {
    public List<String> fizzBuzz(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                res.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}