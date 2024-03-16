public class Simulation {

    int length;
    int width;
    int[][] board;

    public Simulation(int length, int width) {
        this.length = length;
        this.width = width;
        this.board = new int[width][length];
    }

    public void printBoard() {
        System.out.println("---");
        for (int x = 0; x < width; x++) {
            String line = "|";
            for (int y = 0; y < length; y++) {
                if (this.board[x][y] == 0) {
                    line += ".";
                } else {
                    line += "*";
                }

            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("---\n");
    }

    public void setAlive(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < length) {
            this.board[x][y] = 1;

        }
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborX = x + i;
                int neighborY = y + j;
                if (neighborX >= 0 && neighborX < width && neighborY >= 0 && neighborY < length) {
                    count += this.board[neighborX][neighborY];
                }
            }
        }
        count -= this.board[x][y];
        return count;
    }


public void step() {
    int[][] newBoard = new int[width][length];
    for (int y = 0; y < length; y++) {
        for (int x = 0; x < width; x++) {
            int aliveNeighbours = countAliveNeighbours(x, y);
            if (this.board[x][y] == 1) {
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
    this.board = newBoard;
}
}



