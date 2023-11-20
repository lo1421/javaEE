package src.test.java;

public class ThreadedBinaryTreeTest {
    public static void main(String[] args) {
        ThreadedBinaryTree<Integer> tree = new ThreadedBinaryTree<>();

        // 创建节点
        ThreadedBinaryTree.BinaryTreeNode<Integer> node6 = new ThreadedBinaryTree.BinaryTreeNode<>(6);
        //添加r根节点的左子结点node3
        ThreadedBinaryTree.BinaryTreeNode<Integer> node3 = new ThreadedBinaryTree.BinaryTreeNode<>(3);
        //添加r根节点的右子结点node7
        ThreadedBinaryTree.BinaryTreeNode<Integer> node7 = new ThreadedBinaryTree.BinaryTreeNode<>(7);
        //添加a节点的左子结点node1
        ThreadedBinaryTree.BinaryTreeNode<Integer> node1 = new ThreadedBinaryTree.BinaryTreeNode<>(1);
        //添加a节点的右子结点node4
        ThreadedBinaryTree.BinaryTreeNode<Integer> node4 = new ThreadedBinaryTree.BinaryTreeNode<>(4);
        //添加b节点的右子结点node2
        ThreadedBinaryTree.BinaryTreeNode<Integer> node2 = new ThreadedBinaryTree.BinaryTreeNode<>(2);
        //添加c节点的左子结点node5
        ThreadedBinaryTree.BinaryTreeNode<Integer> node5 = new ThreadedBinaryTree.BinaryTreeNode<>(5);




        // 插入节点
        tree.insertNode(null, node6, true);
        tree.insertNode(node6, node3,true);
        tree.insertNode(node6, node7, false);
        tree.insertNode(node3, node1, true);
        tree.insertNode(node3, node4, false);
        tree.insertNode(node1, null,true);
        tree.insertNode(node1, node2,false);
        tree.insertNode(node4, null, true);
        tree.insertNode(node4, node5, false);
        tree.insertNode(node2, null, false);
        tree.insertNode(node2, null, true);
        tree.insertNode(node5, null, true);
        tree.insertNode(node5, null, false);
        tree.insertNode(node7, null, true);





        // 线索化
        tree.inorderThreaded();

       //遍历二叉树
        tree.inThreadList(tree.getRoot());
    }
}
