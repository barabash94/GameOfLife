public class GameApp {

    public static void main(String[] args) {

        Simulation simulation = new Simulation(100, 100);

        int a;
        simulation.setAlive(2, 3);
        simulation.setAlive(3, 3);
        simulation.setAlive(4, 3);

        for (a = 0; a <100; a++){
            if( a%5==0){
                simulation.printBoard();
            }

            simulation.step();


        }
        simulation.printBoard();

    }
}