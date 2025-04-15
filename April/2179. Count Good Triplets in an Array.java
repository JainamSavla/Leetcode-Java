//tc:O(n log n)
//sc:O(n)

class Solution {
    // Fenwick Tree (BIT)
    static class FenwickTree {
        int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 2]; // +2 for 1-based indexing and boundary safety
        }

        public void update(int index, int delta) {
            index++; // 1-based index
            while (index < tree.length) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++; // 1-based index
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Step 1: Map values in nums2 to their positions
        int[] posInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            posInNums2[nums2[i]] = i;
        }

        // Step 2: Transform nums1 values to their positions in nums2
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = posInNums2[nums1[i]];
        }

        // Step 3: Count smaller elements on the left using Fenwick Tree
        FenwickTree leftTree = new FenwickTree(n);
        int[] leftSmaller = new int[n];
        for (int i = 0; i < n; i++) {
            leftSmaller[i] = leftTree.query(transformed[i] - 1);
            leftTree.update(transformed[i], 1);
        }

        // Step 4: Count greater elements on the right using another Fenwick Tree
        FenwickTree rightTree = new FenwickTree(n);
        int[] rightGreater = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightGreater[i] = rightTree.query(n - 1) - rightTree.query(transformed[i]);
            rightTree.update(transformed[i], 1);
        }

        // Step 5: Compute result
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) leftSmaller[i] * rightGreater[i];
        }

        return result;
    }
}
