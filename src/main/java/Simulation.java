

public class Simulation {

    Board board;

    public Simulation(Board board) {
        this.board = board;
    }

    public void setAlive(int x, int y) {
        if (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getLength()) {
            board.setCellAlive(x, y);
        }
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;
        int width = board.getWidth();
        int length = board.getLength();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborX = x + i;
                int neighborY = y + j;
                if (neighborX >= 0 && neighborX < width && neighborY >= 0 && neighborY < length) {
                    count += board.getCellState(neighborX, neighborY);
                }
            }
        }
        count -= board.getCellState(x, y);
        return count;
    }

    public void moveCell(int currentX, int currentY, int newX, int newY) {
        if (newX >= 0 && newX < board.getWidth() && newY >= 0 && newY < board.getLength()) {
            if (board.getCellState(currentX, currentY) == 1) {
                board.setCellDead(currentX, currentY);
                board.setCellAlive(newX, newY);
            }
        }
    }

    public void step() {
        int width = board.getWidth();
        int length = board.getLength();
        int[][] newBoard = new int[width][length];
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                int aliveNeighbours = countAliveNeighbours(x, y);
                if (board.getCellState(x, y) == 1) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        newBoard[x][y] = 0;
                    } else {
                        newBoard[x][y] = 1;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newBoard[x][y] = 1;
                    }
                }
            }
        }
        board.updateState(newBoard);
    }
}


