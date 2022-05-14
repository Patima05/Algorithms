package lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static int NUMBER_OF_TREES = 20;
    private static int MAX_DEPTH = 4;


    public static void main(String[] args) {

        Random random = new Random();
        List<TreeImpl<Integer>> trees = new ArrayList<>();

        int returnState = 0;
        for (int i = 0; i < NUMBER_OF_TREES; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            while (returnState >= 0) {
                int value = random.nextInt(51) - 25;
                returnState = tree.add(value, MAX_DEPTH);
            }
            returnState = 0;
            trees.add(tree);
        }

        for (TreeImpl tree : trees) {
            tree.display();
        }

        float sum = 0;

        for (TreeImpl tree : trees) {
            int minDepth = tree.getMinDepth();
            sum += (tree.isBalanced(MAX_DEPTH)) ? 1 : 0;
        }

        System.out.printf("Из %d деревьев сбалансированных %2.1f%%", NUMBER_OF_TREES, (sum * 100 / NUMBER_OF_TREES));

    }

}