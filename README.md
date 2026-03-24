# 🚀 Rocket Survival Game (Java Swing)

A simple 2D desktop game built using **Java Swing**, where the player controls a rocket and survives as long as possible while avoiding incoming obstacles.

---

## 🎮 Overview

This project is a lightweight arcade-style survival game designed to demonstrate core Java concepts such as:

* GUI development with Swing
* Event-driven programming
* Game loop logic using timers
* Collision detection
* Basic state management

The objective is simple: **survive as long as possible** while dodging falling projectiles.

---

## 🕹️ Gameplay

* Control the rocket using:

  * **W / A / S / D** or **Arrow Keys**
* Avoid falling obstacles
* You start with **3 lives**
* Each collision reduces a life
* Temporary invulnerability prevents instant repeated damage
* The game ends when all lives are lost
* Your survival time is tracked in seconds

---

## ⚙️ Features

* 🎯 Multiple difficulty levels (Easy, Medium, Hard)
* ⏱️ Real-time survival timer
* ❤️ Life tracking system
* 🛡️ Temporary invulnerability after collision
* 🎲 Randomized projectile spawning
* 🧠 Collision detection using bounding boxes
* 🖥️ Interactive GUI using Java Swing

---

## 🧱 Project Structure

```
├── Main.java        # Entry point
├── MenuGui.java     # Difficulty selection menu
├── GameGui.java     # Core game logic and rendering
```

---

## 🛠️ Technologies Used

* **Java**
* **Java Swing (GUI)**
* **AWT Event Handling**
* **Timers (javax.swing.Timer)**

---

## ▶️ How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR-USERNAME/rocket-game.git
   ```

2. Open the project in your IDE (IntelliJ / Eclipse)

3. Run:

   ```bash
   Main.java
   ```

---

## 🧠 Key Concepts Demonstrated

* Event-driven programming with listeners
* Real-time updates using timers
* Object interaction and collision detection
* GUI layout and component management
* Basic game state handling

---

## 🚀 Future Improvements

* Add scoring system (based on survival time)
* Add sound effects and background music
* Improve graphics and animations
* Add levels or increasing difficulty over time
* Refactor into MVC architecture

---

## 👤 Author

**Leawi Taddesse**
Aspiring Software Engineer (Backend-focused, Java & Spring Boot)

---

## 📌 Notes

This project was built as a learning exercise to strengthen my understanding of **Java GUI development and interactive application design**.
