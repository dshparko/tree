package com.company;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        inputChoice();
    }

    public static int checkInput() {
        Scanner sc = new Scanner(System.in);
        int value;
        try {
            value = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Необходимо ввести число.");
            value = checkInput();
        }
        return value;
    }

    public static void inputChoice() {
        Tree tree = new Tree();
        int choice;
        int bufferValue;
        while (true) {
            System.out.println("1 - добавить узел\n" +
                    "2 - поиск узла\n" +
                    "3 - удаление узла\n" +
                    "4 - обход дерева\n"+
                    "5 - завершение программы");
            choice = checkInput();
            switch (choice) {
                case 1:
                    System.out.println("Введите узел.");
                    bufferValue = checkInput();
                    tree.insertValue(bufferValue);
                    break;
                case 2:
                    bufferValue = checkInput();
                    System.out.println(tree.find(bufferValue,tree.root));
                    break;
                case 3:
                    System.out.println("Введите узел.");
                    bufferValue = checkInput();
                    System.out.println(tree.find(bufferValue,tree.root));
                    TreeNode buffer = tree.find(bufferValue,tree.root);
                    System.out.println(tree.delete(buffer,bufferValue));
                    break;
                case 4:
                    System.out.println("Дерево: ");
                    tree.printTree(tree.root, (short) 0);
                    System.out.println("\nОбратный обход дерева");
                    tree.print(tree.root);
                    System.out.println("Прямой обход дерева");
                    tree.printel(tree.root);
                    System.out.println("Симметричный обход дерева");
                    tree.printet(tree.root);
                    break;
                case 5:
                    exit(0);
                    break;
            }
        }
    }
}
