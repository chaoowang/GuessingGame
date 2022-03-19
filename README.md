# Guessing Game
### CP3406 mobile computing prac01
The objective of the app "Guessing Game" is to guess the secret number between the range 1 – 10.
## Java Code
### Game.java
Game.java represents the app logic for playing: “guess the secret number between the range 1 – 10”.
```
public class Game {
    public boolean check(int i) {
        int max = 10;
        int min = 1;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        if (i == random_int){
            return true;
        } else{
            return false;
        }
    }
}
```
### ExampleUnitTest.java
The **@Test** annotation tells Android Studio that this method is a unit test. Unit testing is a semi-automated way to test your codebase.
In this case, the test checks that our Game class works properly.
```public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void run_game(){
        Game game = new Game();

        boolean guessedCorrect = false;
        for (int i =1; i<11; ++i){
            guessedCorrect = game.check(i);
            if(guessedCorrect){
                break;
            }
        }
        assertTrue(guessedCorrect);
    }
}
```
## Connect the Game with the GUI
### checkGuess method
A new method called **checkGuess()** is added to **MainActivity.java**
```
import android.view.View;

public void checkGuess(View view){
    }
```
Because of its signature, this method is accessible in the XML layout code: the signature for this kind of method must be a **public** method, return **void** and have a single **View** parameter.
### Link the checkGuess method to the button
In activity_main.xm, the onClick attribute is added to the Button tag and set its value to be “checkGuess”
```
<Button
        android:onClick="checkGuess"/>
```
### EditTExt id and inputType
Change the id value to be “@+id/userInput”. Change inputType to be “number”
```
<EditText
        android:id="@+id/userInput"
        android:inputType="number" />
```
### Access the EditText(user input)
Back in **MainActivity**, an API method called **findViewById()** is used to helps us get access to the **EditText** in Java. Then we use the **EditText** to get access to the user’s text and convert the **String** into an int:
```
public void checkGuess(View view){
        EditText userInput = findViewById(R.id.userInput);
        String text = userInput.getText().toString();
        int guess = Integer.parseInt(text);
    }
```
### Use Toast API to display the status of the game to the user
```
public void checkGuess(View view){
        EditText userInput = findViewById(R.id.userInput);
        String text = userInput.getText().toString();
        int guess = Integer.parseInt(text);

        Toast toast = Toast.makeText(this,"you won!", Toast.LENGTH_LONG);

        if (!game.check(guess)){
            toast.setText("Incorrect...try again!");
        }

        toast.show();
    }
```
