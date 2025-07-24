# 🧠 Memory Game 

Welcome to the **Memory Game**!  
This is a simple **memory matching game built with Java**. It tests your **memory and concentration** by having you match pairs of cards. The game includes features such as a **dynamic board size**, a **customizable number of lives**, and **random card placements** to make each game unique.

## 🎯 Features

- **Card Matching**: Flip and match pairs of cards.  
- **Dynamic Game Size**: Choose the size of the board (must be an even number).  
- **Lives System**: Players have a limited number of lives, which decreases when an incorrect pair is selected.  
- **Game Over Detection**: The game ends when either all cards are matched or the player runs out of lives.  
- **Interactive User Interface**: A terminal-based interface to interact with the game.  

## 💡 Technologies Used

- **Java** (OOP principles)  
- **Randomization** for card placement  
- **Command-line interface** (CLI)  

## 🖥 Game Flow

- The game board is initialized with a set of **shuffled cards**, each with a corresponding pair.  
- Players take turns selecting **two cards at a time**.  
  - If the cards match, they stay revealed.  
  - If not, they flip back over.  
- The player has a **limited number of lives**.  
  - Each incorrect match reduces one life.  
- The game ends when:  
  - ✅ All cards are matched (🎉 win)  
  - ❌ Player runs out of lives (💀 game over)  
- A **congratulations message** is shown if the player matches all pairs before losing all lives.

## 📁 Project Structure

- `Card.java`:  
  Represents each individual card in the memory game, storing its **value** and **revealed state**.

- `Game.java`:  
  The core class managing **game logic**, including **board initialization**, **gameplay mechanics**, and **user interaction**.
