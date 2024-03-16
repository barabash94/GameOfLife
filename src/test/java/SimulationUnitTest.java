import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationUnitTest {

    Board board;


    @Test
    public void testSetAliveAndPrintBoard() {

        //Given
        Simulation simulation = new Simulation(new Board(3, 3));
        simulation.setAlive(0, 0);
        simulation.setAlive(1, 1);
        simulation.setAlive(2, 2);


        //Then
        String expected = "---\n|*..|\n|.*.|\n|..*|\n---\n";
        verifyBoardOutput(expected, simulation);
    }

    @Test
    public void testStep() {
        //Given
        Simulation simulation = new Simulation(new Board(3, 3));
        simulation.setAlive(0, 0);
        simulation.setAlive(1, 1);
        simulation.setAlive(2, 2);

        //When
        simulation.step();

        //Then
        String expected = "---\n|...|\n|.*.|\n|...|\n---\n";
        verifyBoardOutput(expected, simulation);
    }

    private void verifyBoardOutput(String expectedOutput, Simulation simulation) {
        String boardOutput = getNormalizedBoardOutput(simulation);
        String normalizedExpectedOutput = expectedOutput.trim().replace("\r\n", "\n");
        assertEquals(normalizedExpectedOutput, boardOutput);
    }

    private String getNormalizedBoardOutput(Simulation simulation) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        board.printBoard();
        return outputStream.toString().trim().replace("\r\n", "\n");
    }
}