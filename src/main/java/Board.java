public class Board {



    private int length;
    private int width;
    private int[][] board;

    public Board(int length, int width) {
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

    public void setCellAlive(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < length) {
            this.board[x][y] = 1;
        }
    }

    public int getCellState(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < length) {
            return this.board[x][y];
        }
        return 0; // Default state if coordinates are out of bounds
    }

    public void updateState(int[][] newBoardState) {
        if (newBoardState.length == width && newBoardState[0].length == length) {
            this.board = newBoardState;
        } else {
            System.out.println("Invalid board state dimensions. Board state not updated.");
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
