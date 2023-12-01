package src.test.java;

import java.util.PriorityQueue;

// 定义哈夫曼树节点类
class HuffmanNode implements Comparable<HuffmanNode> {
    int weight;          // 权值
    HuffmanNode left;    // 左子节点
    HuffmanNode right;   // 右子节点

    public HuffmanNode(int weight) {
        this.weight = weight;
    }

    // 实现Comparable接口，用于PriorityQueue的比较
    @Override
    public int compareTo(HuffmanNode other) {
        return this.weight - other.weight;
    }
}

public class HuffmanTree {

    // 构造哈夫曼树的方法
    public static HuffmanNode buildHuffmanTree(int[] weights) {
        // 使用优先队列来存储节点，每次都取出权值最小的两个节点进行合并
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        
        // 将权值数组中的每个元素转化为节点并添加到优先队列中
        for (int weight : weights) {
            pq.add(new HuffmanNode(weight));
        }

        // 不断合并节点直到只剩一个节点，即哈夫曼树的根节点
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();   // 弹出权值最小的节点
            HuffmanNode right = pq.poll();  // 弹出权值次小的节点

            // 创建一个新节点，权值为两个子节点的权值之和
            HuffmanNode parent = new HuffmanNode(left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            // 将新节点添加回优先队列
            pq.add(parent);
        }

        // 返回哈夫曼树的根节点
        return pq.poll();
    }

    // 打印哈夫曼树的方法（可选）
    public static void printHuffmanTree(HuffmanNode root, String prefix) {
        if (root != null) {
            System.out.println(prefix + root.weight);
            printHuffmanTree(root.left, prefix + "0");
            printHuffmanTree(root.right, prefix + "1");
        }
    }

    public static void main(String[] args) {
        int[] weights = {2, 5, 9, 6, 7};

        // 构造哈夫曼树
        HuffmanNode root = buildHuffmanTree(weights);

        // 打印哈夫曼树（可选）
        printHuffmanTree(root, "");
    }
}
