import static java.lang.Math.min;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDiffInBST(TreeNode root) {
        int[] result = minDiffInBSTHelper(root, Integer.MAX_VALUE);
        return result[0];
    }

    //return minDiff, left, right
    public int[] minDiffInBSTHelper(TreeNode root, int minDiff)
    {
        TreeNode left = root.left;
        TreeNode right = root.right;
        int currentMinDiff = minDiff;
        int currentLeft = root.val;
        int currentRight = root.val;
        if (left != null)
        {
            int[] leftResult = minDiffInBSTHelper(left, currentMinDiff);
            currentMinDiff = Math.min(currentMinDiff, leftResult[0]);
            currentMinDiff = min(currentMinDiff, currentLeft - leftResult[2]);
            currentLeft = leftResult[1];
        }
        if(right != null)
        {
            int[] rightResult = minDiffInBSTHelper(right, currentMinDiff);
            currentMinDiff = min(currentMinDiff, rightResult[0]);
            currentMinDiff = min(currentMinDiff, rightResult[1]-currentRight);
            currentRight = rightResult[2];
        }
        return new int[]{currentMinDiff, currentLeft, currentRight};
    }
}
