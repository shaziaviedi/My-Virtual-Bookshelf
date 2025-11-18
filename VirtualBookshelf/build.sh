#!/usr/bin/env zsh
set -e

echo "Checking javac..."
if ! command -v javac >/dev/null 2>&1; then
  echo "Error: javac not found. Install JDK 21 and ensure javac is on PATH."
  exit 1
fi

echo "javac version: $(javac -version 2>&1)"

echo "Compiling Java sources with --release 21..."
mkdir -p bin

# Find .java files under src and compile them
JAVA_FILES=$(find src -name "*.java")
if [ -z "$JAVA_FILES" ]; then
  echo "No Java source files found under src/"
  exit 1
fi

javac --release 21 -d bin $JAVA_FILES

echo "Build successful. Classes are in ./bin"

echo "Run the main class with: java -cp bin ia.mainMenu"