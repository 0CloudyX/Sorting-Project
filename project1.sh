#!/bin/bash

# Exit immediately if a command fails
set -e

# Compile the Java program
javac SortingProject.java

# Run the program with input from stdin
java -Xss64m SortingProject

