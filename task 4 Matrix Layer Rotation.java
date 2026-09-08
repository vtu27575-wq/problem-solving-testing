class Result {
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            List<Integer> a = new ArrayList<>();

            for (int j = layer; j < n - layer; j++)
                a.add(matrix.get(layer).get(j));

            for (int i = layer + 1; i < m - layer; i++)
                a.add(matrix.get(i).get(n - layer - 1));

            for (int j = n - layer - 2; j >= layer; j--)
                a.add(matrix.get(m - layer - 1).get(j));

            for (int i = m - layer - 2; i > layer; i--)
                a.add(matrix.get(i).get(layer));

            int shift = r % a.size();
            int k = 0;

            for (int j = layer; j < n - layer; j++)
                matrix.get(layer).set(j, a.get((k++ + shift) % a.size()));

            for (int i = layer + 1; i < m - layer; i++)
                matrix.get(i).set(n - layer - 1, a.get((k++ + shift) % a.size()));

            for (int j = n - layer - 2; j >= layer; j--)
                matrix.get(m - layer - 1).set(j, a.get((k++ + shift) % a.size()));

            for (int i = m - layer - 2; i > layer; i--)
                matrix.get(i).set(layer, a.get((k++ + shift) % a.size()));
        }

        for (List<Integer> row : matrix) {
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
