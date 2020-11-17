package com.company;


public class Tree {
    TreeNode root = null;

    public void insertValue(int key) {
        TreeNode node = new TreeNode();
        node.key = key;
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode prev;
            while (true) {
                prev = current;
                if (key < prev.key) {
                    current = current.left;
                    if (current == null) {
                        prev.left = node;
                        return;
                    }
                } else {
                    if (key > prev.key) {
                        current = current.right;
                        if (current == null) {
                            prev.right = node;
                            return;
                        }
                    }else{
                        System.out.println("Дубликат!");
                        return;
                    }
                }
            }
        }
    }


    public static void printTree(TreeNode root, short x) {
        int i;
        if (root != null) {
            printTree(root.right, (short) (x + 3));
            for (i = 0; i < x; i++) {
                System.out.format(" ");
            }
            System.out.format("%3d\n", root.key);
            printTree(root.left, (short) (x + 3));
        }

    }

    public TreeNode find(int key, TreeNode root) {
        TreeNode current = root;
        while (current.key != key) {
            if (current.key > key) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public static TreeNode delete(TreeNode current, int key) {
        if (current == null) {
            return null;
        }
        if (key < current.key) {
            current.left = delete(current.left, key);
        } else if (key > current.key) {
            current.right = delete(current.right, key);
        } else {
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            current.key = min(current.right);
            current.right = delete(current.right, current.key);
        }
        return current;
    }

    public static int min(TreeNode current) {
        int min = 0;
        while (current.left != null) {
            min = current.left.key;
            current = current.left;
        }
        return min;
    }


    public static void print(TreeNode root) {//
        if (root != null) {//условие сработает, когда мы достигним конца дерева и потомков не останется
            print(root.left);//рекурсивно вызываем левых потомков
            print(root.right);//вызов правых
            root.printNode();//вызов метода принт
        }
    }

    public static void printet(TreeNode root) {//
        if (root != null) {//условие сработает, когда мы достигним конца дерева и потомков не останется
            print(root.left);//рекурсивно вызываем левых потомков
            root.printNode();//вызов метода принт
            print(root.right);//вызов правых
        }
    }

    public static void printel(TreeNode root) {//
        if (root != null) {//условие сработает, когда мы достигним конца дерева и потомков не останется
            root.printNode();//вызов метода принт
            printel(root.left);//рекурсивно вызываем левых потомков
            printel(root.right);//вызов правых

        }
    }
}
