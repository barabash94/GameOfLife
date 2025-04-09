public class GameApp {

    public static void main(String[] args) {


            Simulation simulation = new Simulation(new Board(15, 15));

            simulation.setAlive(3, 5);
            simulation.setAlive(4, 5);
            simulation.setAlive(5, 5);

            int numOfSteps = 100;

            for (int step = 0; step < numOfSteps; step++) {
                clearConsole();
                simulation.board.printBoard();
                simulation.step();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            clearConsole();
            simulation.board.printBoard();
        }


        public static void clearConsole() {
            try {
                final String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (final Exception e) {

            }
        }
    }

