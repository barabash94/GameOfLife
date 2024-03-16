public class GameApp {

    public static void main(String[] args) {

        Simulation simulation = new Simulation(new Board(50, 50));

        simulation.setAlive(3, 5);
        simulation.setAlive(4, 5);
        simulation.setAlive(5, 5);

        for (int a = 0; a < 100; a++) {
            if (a % 5 == 0) {
                simulation.board.printBoard();
            }

            simulation.step();
        }

        simulation.board.printBoard();
    }
}