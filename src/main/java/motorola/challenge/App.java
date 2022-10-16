package motorola.challenge;

import motorola.challenge.views.Input;
import motorola.challenge.controllers.InputController;

public class App {

    public static void main(String[] args) {
        Input input = new Input();
        InputController inputController = new InputController();

        String inputText = input.drawInput();

        inputController.charCounter(inputText);
    }
}
