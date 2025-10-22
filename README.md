# 🔢 Sorting Algorithms Project (Java)

A Java program that implements and compares multiple sorting algorithms including **Merge Sort**, **Quick Sort**, and **Insertion Sort**.  
This project demonstrates algorithmic efficiency, recursion, and data structure manipulation.

---

## 🧠 Overview

The Sorting Project benchmarks three core sorting methods using an array of integers or randomized datasets.  
Each algorithm’s runtime and correctness are compared to demonstrate their performance differences under varying input sizes.

---

## ⚙️ Features

- **Merge Sort** – Divide-and-conquer recursive sort with O(n log n) complexity.  
- **Quick Sort** – Recursive pivot-based partitioning sort for efficient average performance.  
- **Insertion Sort** – Simple iterative sort ideal for small or partially-sorted datasets.  
- **Runtime Measurement** – Calculates and displays the time taken by each algorithm.  
- **User Interaction** – Allows the user to choose which algorithm to run and view results.

---

## 🧩 Example Input

8 A P
8 D P
8 R P
8 S P
8 E P
8 S i
8 S q
8 S m
64 A I
64 A Q
64 A M


---

## 🧩 Example Output

1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
7 7 6 1 7 5 6 8
7 3 6 2 4 8 5 1
1 1 1 1 1 1 1 1
1 2 3 4 5 6 7 8
1 2 3 4 5 6 7 8
1 2 3 4 5 6 7 8
64 A I 63
64 A Q 2016
64 A M 384

---

📊 Algorithmic Complexity

| Algorithm          | Best Case  | Average Case | Worst Case |
| ------------------ | ---------- | ------------ | ---------- |
| **Merge Sort**     | O(n log n) | O(n log n)   | O(n log n) |
| **Quick Sort**     | O(n log n) | O(n log n)   | O(n²)      |
| **Insertion Sort** | O(n)       | O(n²)        | O(n²)      |
