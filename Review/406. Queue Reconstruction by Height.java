class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        
        for (int i = 1; i < people.length; i++) {
            int index = people[i][1];
            int[] tmp = people[i];
            int j = i - 1;
            while (j >= index) {
                people[j + 1] = people[j];
                --j;
            }
            
            people[index] = tmp;
        }
        
        return people;
    }
}