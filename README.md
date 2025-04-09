# Game of Life Simulation

**Game of Life Simulation** is a cellular automaton based on Conway's Game of Life. The application allows you to simulate the evolution of cells on a board based on specific rules. It provides a simple way to visualize the changes in the state of cells over time.

## Features
- Cells can be alive or dead, represented by `*` (alive) and `.` (dead) on the board.
- The board is a grid with customizable dimensions.
- The application updates the state of each cell based on its neighbors.
- The simulation runs for a specified number of steps, and the board is printed at each step.

## Rules (Conway's Game of Life)
1. **Any live cell with fewer than two live neighbors dies (underpopulation).**
2. **Any live cell with two or three live neighbors lives on to the next generation.**
3. **Any live cell with more than three live neighbors dies (overpopulation).**
4. **Any dead cell with exactly three live neighbors becomes a live cell (reproduction).**

## Technologies Used
- Java

## How to Run the Application
1. Clone this repository:
   ```bash
   git clone https://github.com/barabash94/GameOfLife.git
