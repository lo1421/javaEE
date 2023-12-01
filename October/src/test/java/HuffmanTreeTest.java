package src.test.java;

public class HuffmanTreeTest {

    public static void main(String[] args) {
        int[] weights = {2, 5, 9, 6, 7};

        // 构造哈夫曼树
        HuffmanNode root = HuffmanTree.buildHuffmanTree(weights);

        // 打印哈夫曼树的结构
        System.out.println("Huffman Tree Structure:");
        printHuffmanTreeStructure(root, "");
    }

    // 递归打印哈夫曼树的结构
    private static void printHuffmanTreeStructure(HuffmanNode root, String prefix) {
        if (root != null) {
            System.out.println(prefix + "Weight: " + root.weight);
            if (root.left != null || root.right != null) {
                System.out.println(prefix + "├── Left:");
                printHuffmanTreeStructure(root.left, prefix + "│    ");
                System.out.println(prefix + "└── Right:");
                printHuffmanTreeStructure(root.right, prefix + "     ");
            }
        }
    }
}
