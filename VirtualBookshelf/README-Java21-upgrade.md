Upgrade to Java 21 (LTS) — instructions

This project does not use Maven/Gradle. These instructions help install Java 21 and build the sources using `javac`.

1) Install JDK 21 (macOS)

- Homebrew (recommended):

```bash
brew install openjdk@21
# Add to shell profile (zsh):
# Add the following to ~/.zshrc or run in terminal:
# export PATH="/usr/local/opt/openjdk@21/bin:$PATH"
```

- SDKMAN (alternative):

```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 21-open
sdk use java 21-open
```

- Adoptium/Eclipse Temurin: download installer for mac and follow GUI installer.

2) Verify JDK 21 is active

```bash
java -version
javac -version
# Both should report a 21.x version
```

3) Build the project

A helper script `build.sh` is included. From the repository root run:

```bash
chmod +x build.sh
./build.sh
```

This compiles sources under `src/` into `bin/` using `--release 21`.

4) Run the app

Assuming main class is `ia.mainMenu` (package `ia`), run:

```bash
java -cp bin ia.mainMenu
```

5) If you later add a build tool

- For Maven: set `<maven.compiler.release>21</maven.compiler.release>` or configure `maven-compiler-plugin` with `--release 21`.
- For Gradle: set `java.toolchain.languageVersion = JavaLanguageVersion.of(21)` or `compileJava.options.release = 21`.

6) Next steps I can do for you

- Add a Gradle wrapper and build.gradle configured for Java 21
- Convert project to Maven with `pom.xml` and Java 21 settings
- Attempt an automated code modernization using OpenRewrite (requires Copilot Pro)

If you'd like any of those, tell me which and I will proceed.