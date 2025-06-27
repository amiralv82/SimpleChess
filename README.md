# ♟️ SimpleChess

**SimpleChess** is a Java-based chess game featuring a graphical user interface. It supports both **two-player** and **single-player** modes with a simple AI opponent. Players can move pieces by **clicking** on them and selecting their destination. The game also includes functionality to **save and resume** progress.

---

## Features

- Graphical UI with mouse-based interaction
- Two-player mode (local)
- Single-player mode with basic AI
- Valid move checking for all pieces:
  - Pawn, Rook, Knight, Bishop, Queen, King
- Save and load game functionality
- Turn-based play (White starts)
- Illegal moves are blocked

---

## How to Run

### Requirements:
- Java 8 or higher

### Steps:
1. Compile the code:
```bash
javac Main.java
```
2.	Run the game:

java Main



Or open the project in an IDE (like IntelliJ or Eclipse) and run Main.java.

---

Gameplay Instructions
	•	Click a piece to select it.
	•	Click a valid destination square to move.
	•	In single-player mode, the AI will make a move after you do.
	•	Use the in-game menu or button to save and load game state.

---

Project Structure
```bash
SimpleChess/
├── board/            # Board display and logic
├── pieces/           # Classes for each chess piece
├── players/          # Player and AI logic
├── utils/            # Utility classes and helpers
├── save/             # Save/load game state
├── Main.java         # Application entry point
```
---

Author

Amir-Abbas Alvand

---

Let me know if you want to add a screenshot section later — or if you’d like help creating your first GitHub Release for this project.
