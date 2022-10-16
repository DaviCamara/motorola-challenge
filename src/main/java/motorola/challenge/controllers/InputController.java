package motorola.challenge.controllers;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.logging.Logger;

import motorola.challenge.models.InputDTO;

public class InputController {
    private static final Logger logger = Logger.getLogger(InputController.class.toString());
    StringBuilder stringBuilder = new StringBuilder();

    InputDTO inputDTO = new InputDTO();
    String normalizedString;
    int count = 0;
    int j = 0;
    char currentChar = ' ';

    public void charCounter(String inputText) {
        stringBuilder.append("Original String: ");
        stringBuilder.append(inputText);
        System.out.println(stringBuilder.toString());
        stringBuilder.setLength(0);

        if (isEmpty(inputText)) {
            logger.info(stringBuilder.append("Input String empty or contains only blankspaces").toString());
            return;
        } else {
            String normalizedInputText = stringNormalizer(inputText);

            for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                for (int i = 0; i < normalizedInputText.length(); i++) {

                    currentChar = normalizedInputText.charAt(i);
                    while (!isLetter(currentChar)) {
                        currentChar = normalizedInputText.charAt(i++);
                    }

                    if (alphabet == currentChar) {
                        count++;
                    }
                }
                if (count > 0) {
                    inputDTO.setLetter(alphabet);
                    inputDTO.setCount(count);

                    stringBuilder.append(inputDTO.getLetter());
                    stringBuilder.append(": ");
                    stringBuilder.append(inputDTO.getCount());
                    System.out.println(stringBuilder.toString());
                    stringBuilder.setLength(0);

                    count = 0;
                }
            }
        }
        logger.info(stringBuilder.append("Execution Sucessfull.").toString());
    }

    private String stringNormalizer(String inputText) {
        normalizedString = inputText.toLowerCase();
        if (!Normalizer.isNormalized(inputText, Form.NFD)) {
            normalizedString = Normalizer.normalize(normalizedString, Normalizer.Form.NFD);
        }
        return normalizedString;
    }

    private boolean isLetter(char inputText) {
        return Character.isLetter(inputText);
    }

    private boolean isEmpty(String inputText) {
        if (inputText.isBlank() || inputText.isEmpty())
            return true;
        else {
            return false;
        }
    }

}
