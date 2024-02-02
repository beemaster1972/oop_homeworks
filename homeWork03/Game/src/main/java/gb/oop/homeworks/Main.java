package gb.oop.homeworks;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static final int maxWordSize = 5;
    public static String promptTypeGame = String.format("Для начала определимся с типом игры:%n" +
            "  1 - только цифры%n" +
            "  2 - только кириллица%n" +
            "  3 - только латиница%n" +
            "  0 - завершить игру%n" +
            "Введите ответ: ");
    public static String promptCommand = String.format("Доступные действия:%n" +
            "  1 - начать новую игру%n" +
            "  2 - рестарт текущей игры%n" +
            "  3 - продолжить игру%n" +
            "  4 - показать историю текущей игры%n" +
            "  0 - завершить игру%n" +
            "Введите ответ: ");
    public static String promptConditions = String.format("Выберите режим игры:%n" +
            "  1 - только уникальные символы%n" +
            "  2 - символы могут повторятся%n" +
            "Введите ваш ответ: ");
    public static String promptValue = "Введите %s";

    public static AbstractGame getTypeGame(int typeGame) {
        AbstractGame result;
        result = switch (typeGame) {
            case 1 -> new NumeralGame();
            case 2 -> new RuGame();
            case 3 -> new EnGame();
            default -> null;
        };
        return result;
    }

    public static int getAnswer(String prompt, Scanner scanner) {
        System.out.printf(prompt);
        int result = -999;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число!");
        } catch (NoSuchElementException e) {
            System.out.println("Всё електричество кончилось! Кина не будет!");
        } catch (IllegalStateException e) {
            System.out.println("Ну это вообще какая-то невероятная ситуация! Тут наши полномочия всё!");
        }
        return result;

    }

    public static String getString(String prompt, Scanner scanner) {
        System.out.printf(prompt);
        String result = scanner.nextLine();
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AbstractGame newGame;
        int userAnswer = getAnswer(promptTypeGame, scanner);
        while (userAnswer != 0) {
            newGame = getTypeGame(userAnswer);
            if (Objects.isNull(newGame)) {
                userAnswer = 0;
                continue;
            }
            Integer wordSize = getAnswer(String.format(promptValue, "размер загадываемого слова: "), scanner);
            Integer maxAttempts = getAnswer(String.format(promptValue, "количество попыток: "), scanner);
            Conditions conditions = switch (getAnswer(promptConditions, scanner)) {
                case 1 -> Conditions.UNIQUE_SYMBOLS;
                case 2 -> Conditions.NON_UNIQUE_SYMBOLS;
                default -> null;
            };
            if (checkParameters(newGame, wordSize, maxAttempts, conditions)) {
                newGame.start(wordSize, maxAttempts, conditions);
            }
            while (newGame.getGameStatus().equals(GameStatus.START)) {
                userAnswer = getAnswer(promptCommand, scanner);
                switch (userAnswer) {
                    case 1:
                        System.out.println("Ну новую, так новую...");
                        newGame.stop();
                        break;
                    case 2:
                        newGame.restart();
                        break;
                    case 3:
                        String value = getString(String.format(promptValue, "ваш вариант загаданного слова: "), scanner);
                        Answer answer = newGame.inputValue(value);
                        System.out.println(answer);
                        break;
                    case 4:
                        HistoryGame history = newGame.getHistoryGame();
                        if (!Objects.isNull(history)) {
                            history.showHistory();
                        } else System.out.println("Игра ещё не начиналась. Какая может быть история");
                        break;
                    case 0:
                        newGame.stop();
                        break;
                    default:
                        System.out.println("Я могу до безконечности задавать вопросы. А ты готов до безконечности давать неправильные ответы?");
                        break;

                }
            }
        }
        System.out.println("Пока-пока...");
        scanner.close();
    }

    private static boolean checkParameters(AbstractGame game, Integer wordSize, Integer maxAttempts, Conditions conditions) {
        if (Objects.isNull(conditions)) return false;
        if (wordSize <= 0 || wordSize > maxWordSize) {
            System.out.printf("Размер загадываемого слова не может быть больше %d и меньше или равно нуля%n",
                    maxWordSize);
            return false;
        }
        return maxAttempts != 0;
    }
}