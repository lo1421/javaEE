package src.test.java;

public class ThreadedBinaryTreeTest {
    public static void main(String[] args) {
        ThreadedBinaryTree<String> tree = new ThreadedBinaryTree<>();

        // 创建节点
        ThreadedBinaryTree.BinaryTreeNode<String> r = new ThreadedBinaryTree.BinaryTreeNode<>("r");
        //添加r根节点的左子结点a
        ThreadedBinaryTree.BinaryTreeNode<String> a = new ThreadedBinaryTree.BinaryTreeNode<>("a");
        //添加r根节点的右子结点b
        ThreadedBinaryTree.BinaryTreeNode<String> b = new ThreadedBinaryTree.BinaryTreeNode<>("b");
        //添加a节点的左子结点c
        ThreadedBinaryTree.BinaryTreeNode<String> c = new ThreadedBinaryTree.BinaryTreeNode<>("c");
        //添加a节点的右子结点d
        ThreadedBinaryTree.BinaryTreeNode<String> d = new ThreadedBinaryTree.BinaryTreeNode<>("d");
        //添加b节点的左子结点e
        ThreadedBinaryTree.BinaryTreeNode<String> e = new ThreadedBinaryTree.BinaryTreeNode<>("e");
        //添加b节点的右子结点f
        ThreadedBinaryTree.BinaryTreeNode<String> f = new ThreadedBinaryTree.BinaryTreeNode<>("f");
        //添加c节点的左子结点g
        ThreadedBinaryTree.BinaryTreeNode<String> g = new ThreadedBinaryTree.BinaryTreeNode<>("g");



        // 插入节点
        tree.insertNode(null, r, true);
        tree.insertNode(r, a,true);
        tree.insertNode(r, b, false);
        tree.insertNode(a, c, true);
        tree.insertNode(a, d, false);
        tree.insertNode(c, null,true);
        tree.insertNode(c, f,false);
        tree.insertNode(d, null, true);
        tree.insertNode(d, g, false);
        tree.insertNode(f, null, false);
        tree.insertNode(f, null, true);
        tree.insertNode(g, null, true);
        tree.insertNode(g, null, false);
        tree.insertNode(b, null, true);
        tree.insertNode(b, e, false);
        tree.insertNode(e, null, true);
        tree.insertNode(e, null, false);



        // 线索化
        tree.inorderThreaded();

       //遍历二叉树
        tree.inThreadList(tree.getRoot());
    }
}
