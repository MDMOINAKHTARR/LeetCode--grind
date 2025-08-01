class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int aboveLeft = triangle.get(i - 1).get(j - 1);
                    int aboveRight = triangle.get(i - 1).get(j);
                    row.add(aboveLeft + aboveRight);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}
