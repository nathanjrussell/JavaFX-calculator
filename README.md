# JavaFX Calculator

A basic calculator using Amazon Corretto JDK 24 and JavaFX 24.
It adds, subtracts, multiplies, and divides two numbers.

## Visual components

- `Stage` is the application window
- `Scene` holds the contents of the window
- `GridPane` places controls in rows and columns
- `TextField` lets the user enter a number
- `Button` lets the user choose an operation
- `Label` displays instructions, results, or error messages

## Program code

The `start` method creates the visual components and arranges them.
Each button uses `setOnAction` to respond to a click.
The `calculate` method reads the numbers, performs the math, and updates the result.
The `main` method launches the application.

The visual components determine what the user sees.
The event handlers and calculation code determine what happens when the user clicks.

## Running the calculator

Open `pom.xml` as a Maven project and select Amazon Corretto 24 as the JDK.
In your IDE's Maven panel, open the JavaFX plugin and run its `run` goal.
Maven downloads the JavaFX libraries automatically.
