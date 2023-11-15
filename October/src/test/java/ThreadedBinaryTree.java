package src.test.java;

/**
 * 线索二叉树测试Threaded Binary Tree
 * 这个测试类目的是用来实现线索二叉树的(中序)
 */
public class ThreadedBinaryTree<E> {


    private BinaryTreeNode<E> root = null;//根节点
    private BinaryTreeNode<E> pre = null; // 用于保存前一个节点
    private int size;//节点个数

    /**
     *无参构造方法,可以完成部分属性的初始化
     */
    public ThreadedBinaryTree(){
    }

    /**
     *
     * @param root
     */
    public ThreadedBinaryTree(BinaryTreeNode<E> root){
        try {
            checkRootDataIllegal(root.val);
        } catch (DataIllegalException e) {
            throw new RuntimeException(e);
        }
        this.root = root;
        size++;
    }

    /**
     * 判空
     * @return 如果二叉树为空则返回ture
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 检查数据是否为非法的数据
     * @param data val值
     * @throws DataIllegalException 自定义的异常(当数据为空的时候抛出该异常,并打印信息 "数据不能存储空值")
     */
    private void checkRootDataIllegal(E data) throws DataIllegalException {
        if (data==null){
        throw new DataIllegalException("数据不能存储空值");
        }
    }

    /**
     * 节点个数
     * @return 返回的二叉树节点的个数
     */
    public int size(){
        return size;
    }

    /**
     * 获取搜索二叉树的根节点
     * @return 根节点对象
     */
    public BinaryTreeNode<E> getRoot(){
        return this.root;
    }

    /**
     * 获取左孩子
     * @param parent 父亲节点
     * @return 返回的当前父亲节点的左孩子
     */
    public BinaryTreeNode<E> getLeft(BinaryTreeNode<E> parent){
        checkParent(parent);
        //注意需要判断传进来的父亲节点对象是否存在左孩子,如果存在才可以返回左孩子,如果不存在就返回null
        return parent.left;
    }

    /**
     * 获取右孩子
     * @param parent 父亲节点
     * @return 返回当前父亲节点的右孩子
     */
    public BinaryTreeNode<E> getRight(BinaryTreeNode<E> parent){
        //注意需要判断传进来的父亲节点是否存在右孩子,如果存在才可以返回右孩子对象,如果不存在就返回null
        return parent.right;
    }

    /**
     * 检查父亲节点是否为空,如果为空的话就需要抛出异常
     * @param parent 传进来的父亲节点
     */
    private void checkParent(BinaryTreeNode<E> parent){
        if(parent ==null){
            throw  new NullPointerException("父亲节点不能为空");
        }
    }


    /**
     * 向线索二叉树中插入节点
     * @param parent 父节点
     * @param child 要插入的新节点
     * @param isLeft 如果为true，则将节点插入为左孩子；如果为false，则为右孩子
     */
    public void insertNode(BinaryTreeNode<E> parent, BinaryTreeNode<E> child, boolean isLeft) {
        if (parent == null) {
            if (root == null) {
                root = child; // 如果根节点为空，则新节点成为根节点
            } else {
                throw new IllegalStateException("不能在空的父节点上插入");
            }
        } else {
            if (isLeft && parent.left == null) {
                parent.left = child;
            } else if (!isLeft && parent.right == null) {
                parent.right = child;
            } else {
                throw new IllegalStateException("指定的位置已有节点");
            }
        }
        size++;
    }


    // 线索遍历函数
    // 实现中序遍历的同时线索化
    public void inorderThreaded() {
        inorderThreaded(this.root);
    }

    private void inorderThreaded(BinaryTreeNode<E> node) {
        if (node == null) {
            return;
        }

        // 遍历左子树
        inorderThreaded(node.left);

        // 处理当前节点的前驱
        if (node.left == null) {
            node.left = pre;
            node.isLeftThread = true;
        }

        // 处理前一个节点的后继
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.isRightThread = true;
        }

        pre = node; // 更新前一个节点

        // 遍历右子树
        inorderThreaded(node.right);
    }


    /**
     * 中序遍历线索二叉树
     */
    public void inThreadList(BinaryTreeNode<E> root) {
        if (root == null) {
            return;
        }
        //查找中序遍历的起始节点
        while (root != null && !root.isLeftThread) {
            root = root.left;
        }

        while (root != null) {
            System.out.print(root.val + " ");
            // 如果右子节点是线索
            if (root.isRightThread) {
                root = root.right;
            } else {
                //有右子节点，遍历右子节点
                root = root.right;
                //如果右子节点不为null，并且右子节点的左子结点存在
                while (root != null && !root.isLeftThread) {
                    root = root.left;
                }
            }
        }

    }

    /**
     * 封装的节点类
     * @param <E>
     */
  static   class BinaryTreeNode<E> {
        //数据域
        public E val;
        //保存左孩子或者直接前驱节点的引用(保存直接前驱节点的条件是没有左孩子,如果有左孩子就直接指向左孩子)
        public BinaryTreeNode<E> left;
        //保存右孩子或者直接后继节点的引用(保存直接后继节点的条件是没有右孩子,如果有右孩子就直接指向右孩子)
        public BinaryTreeNode<E> right;

        public boolean isLeftThread;  // 左指针是否为线索
        public boolean isRightThread; // 右指针是否为线索

        /**
         * 构造方法
         *
         * @param val 创建节点的时候就初始化data的数值
         */
        public BinaryTreeNode(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.isLeftThread = false;
            this.isRightThread = false;
        }

        /**
         * 重写ToString()方法
         *
         * @return
         */
        public String toString() {
            return this.val.toString();
        }

    }

}

class DataIllegalException extends Exception{
    public DataIllegalException(String m){
        super(m);
    }
}
