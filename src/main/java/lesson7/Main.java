package lesson7;

public class Main {
    public static void main(String[] args) {
        testSws();
    }

    private static void testSws() {
        Graph graph = new GraphImpl(11);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Воронеж");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула", 10);
        graph.addEdge("Тула", "Липецк", 15);
        graph.addEdge("Липецк", "Воронеж", 25);
        graph.addEdge("Москва", "Рязань", 5);
        graph.addEdge("Рязань", "Тамбов", 7);
        graph.addEdge("Тамбов", "Саратов", 10);
        graph.addEdge("Саратов", "Воронеж", 12);
        graph.addEdge("Москва", "Калуга", 15);
        graph.addEdge("Калуга", "Орел", 5);
        graph.addEdge("Орел", "Курск", 1);
        graph.addEdge("Курск", "Воронеж", 7);

        graph.sws("Москва", "Воронеж");
    }
}
