# Text-Based Hero Game

This is a simple text-based hero game developed for **Coursework 1** of the **Comp1202 - Programming 1** module. The game involves two heroes battling each other, gaining experience points (XP), leveling up, and using spells. The game is played in a command-line interface.

## Features
- **Hero Registration**: Users can create and set up heroes with custom attributes.
- **Combat System**: Heroes can attack each other with random damage based on their attack range.
- **Leveling System**: Heroes gain XP and level up, increasing their attack power and defense.
- **Spells**: Heroes can cast spells on their opponent to weaken them.
- **Game Termination**: The game ends when one hero's health reaches zero.

## How to Play
1. Run the Java program.
2. Choose from the following menu options:
   - `1` Register Hero 1
   - `2` Register Hero 2
   - `3` Hero 1 attacks Hero 2
   - `4` Hero 2 attacks Hero 1
   - `5` Hero 1 casts a spell on Hero 2
   - `6` Hero 2 casts a spell on Hero 1
3. The game continues until one hero dies.

## Game Mechanics
- **Attacks**: Heroes deal random damage within their `damageMin` and `damageMax` range.
- **Defense**: Damage is reduced based on the hero's defense attribute.
- **Spells Available**:
  - **Anti-Armor**: Reduces the target's armor to 0.
  - **Demi**: Halves the target's health.
  - **Cripple**: Halves the target's attack power.
  - **Poison**: Slowly reduces the target's health over time.
- **XP & Leveling**:
  - Heroes earn XP from battles.
  - When XP reaches a certain threshold, the hero levels up, increasing attack and defense stats.

## Dependencies
- Java 8 or later
- No external libraries required

## How to Run
1. Compile the Java program:
   ```sh
   javac Hero.java

