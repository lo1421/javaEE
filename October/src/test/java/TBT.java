package src.test.java;

/**
 * 线索二叉树测试Threaded Binary Tree
 * 这个测试类目的是用来实现线索二叉树的(中序)
 */
public class TBT<E> {

    /**
     * 外部保存根节点的引用
     */
   public BinaryTreeNode<E> root;

    /**
     * 线索化的时候保存的cur节点的前驱节点
     */
    public BinaryTreeNode<E>  pre;


    /**
     * 线索二叉树的节点个数
     */
    public int size;


    /**
     *无参构造方法,可以完成部分属性的初始化
     */
    public TBT(){
    }

    /**
     *
     * @param root
     */
    public TBT(BinaryTreeNode<E> root){
        try {
            checkRootDataIllegal(root.data);
        } catch (DataIllegalException e) {
            throw new RuntimeException(e);
        }
        this.root = new BinaryTreeNode<>(root.data);
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

    public void checkRootDataIllegal(E data) throws DataIllegalException {
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
        return parent.left == null ? null : parent.left;
    }

    /**
     * 获取右孩子
     * @param parent 父亲节点
     * @return 返回当前父亲节点的右孩子
     */
    public BinaryTreeNode<E> getRight(BinaryTreeNode<E> parent){
        //注意需要判断传进来的父亲节点是否存在右孩子,如果存在才可以返回右孩子对象,如果不存在就返回null
        return parent.right == null ? null : parent.right;
    }

    public void checkParent(BinaryTreeNode<E> parent){
        if(parent ==null){
            throw  new NullPointerException("父亲节点不能为空");
        }
    }

    /**
     * 封装的节点类
     * @param <E>
     */

    static  class BinaryTreeNode<E> {
        //数据域
        public E data;
        //保存左孩子或者直接前驱节点的引用(保存直接前驱节点的条件是没有左孩子,如果有左孩子就直接指向左孩子)
        public BinaryTreeNode<E> left ;
        //保存右孩子或者直接后继节点的引用(保存直接后继节点的条件是没有右孩子,如果有右孩子就直接指向右孩子)
        public BinaryTreeNode<E> right;

        //标志位ltag == false 时,表示 left指向左孩子; ltag == true 时,表示left指向前驱结点
        public boolean ltag;
        //标志位rtag == false 时,表示 rigth 指向右孩子; rtag == true 时,表示right指向后继节点
        public boolean rtag;

        /**
         * 构造方法
         * @param data 创建节点的时候就初始化data的数值
         */
        public BinaryTreeNode (E data){
            this.data = data;
        }

        /**
         * 重写ToString()方法
         * @return
         */
        public String toString(){
            return this.data.toString();
        }

    }

    public static void main(String[] args) {

    }
}


class DataIllegalException extends Exception{
    public DataIllegalException(String m){
        super(m);
    }
}
