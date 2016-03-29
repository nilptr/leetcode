/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> ret;
        if (root == NULL) return ret;
        if (root->left == NULL && root->right == NULL) {
            ret.push_back(to_string(root->val));
            return ret;
        }
        if (root->left != NULL) {
            vector<string> left = binaryTreePaths(root->left);
            for (auto i = left.begin(); i < left.end(); ++i)
                ret.push_back(to_string(root->val) + "->" + *i);
        }
        if (root->right != NULL) {
            vector<string> right = binaryTreePaths(root->right);
            for (auto i = right.begin(); i < right.end(); ++i)
                ret.push_back(to_string(root->val) + "->" + *i);
        }
        return ret;
    }
};