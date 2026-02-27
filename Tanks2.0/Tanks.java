import java.util.Scanner;


class InvalidMenuChoiceException extends Throwable {
    public InvalidMenuChoiceException(String message) {
        super(message);
    }
}

class InvalidCommandException extends Throwable {
    public InvalidCommandException(String message) {
        super(message);
    }
}

class OutOfFieldException extends Throwable {
    public OutOfFieldException(String message) {
        super(message);
    }
}

/* ===== ОСНОВНИЙ КЛАС ===== */

public class Tanks {

    static Scanner scanner = new Scanner(System.in);

    static char[][][] levels = {
            {
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#','T',' ',' ',' ','#',' ',' ',' ',' ',' ','E',' ','#'},
                    {'#',' ','#','#',' ','#',' ','#','#','#',' ',' ',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#',' ','#'},
                    {'#',' ','#','#','#','#',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
            },
            {
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#','T',' ',' ',' ',' ',' ','#',' ',' ',' ','E',' ','#'},
                    {'#',' ','#','#','#','#',' ','#',' ','#','#','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#',' ','#','#','#','#','#','#','#','#','#','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','E',' ','#'},
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
            }
    };

    static char[][] field;
    static int tankX, tankY;
    static int lives = 3;
    static int level = 0;

    static int bulletX, bulletY;
    static boolean bulletActive;

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n=== ТАНЧИКИ ===");
                System.out.println("1. Почати гру");
                System.out.println("2. Вихiд");
                System.out.print("Вибiр: ");

                String c = scanner.nextLine();

                if (c.length() == 0)
                    throw new InvalidMenuChoiceException("Порожній вибір!");

                if (!c.equals("1") && !c.equals("2"))
                    throw new InvalidMenuChoiceException("Невірний пункт меню!");

                if (c.equals("1")) startGame();
                if (c.equals("2")) break;

            } catch (InvalidMenuChoiceException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    static void startGame() {

        lives = 3;
        level = 0;

        while (level < levels.length) {

            loadLevel(level);

            while (true) {

                drawField();
                System.out.println("Життя: " + lives + " | Рiвень: " + (level + 1));
                System.out.print("Команда (w/a/s/d/f/q): ");

                try {

                    String cmd = scanner.nextLine().toLowerCase();

                    if (cmd.length() == 0)
                        throw new InvalidCommandException("Команда не може бути порожньою!");

                    if (!cmd.equals("w") && !cmd.equals("a") &&
                        !cmd.equals("s") && !cmd.equals("d") &&
                        !cmd.equals("f") && !cmd.equals("q"))
                        throw new InvalidCommandException("Невідома команда!");

                    if (cmd.equals("q")) return;

                    moveTank(cmd);
                    moveBullet();
                    enemyAttack();

                } catch (InvalidCommandException e) {
                    System.out.println("❌ " + e.getMessage());
                    continue;
                } catch (OutOfFieldException e) {
                    System.out.println("❌ " + e.getMessage());
                    continue;
                }

                if (lives <= 0) {
                    System.out.println("\n💀 ГРА ЗАВЕРШЕНА");
                    scanner.nextLine();
                    return;
                }

                if (noEnemies()) {
                    level++;
                    break;
                }
            }
        }

        System.out.println("\n🏆 ТИ ПРОЙШОВ УСІ РІВНІ!");
        scanner.nextLine();
    }

    static void loadLevel(int n) {

        field = new char[levels[n].length][levels[n][0].length];

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                field[y][x] = levels[n][y][x];
                if (field[y][x] == 'T') {
                    tankX = x;
                    tankY = y;
                    field[y][x] = ' ';
                }
            }
        }

        bulletActive = false;
    }

    static void drawField() {

        System.out.println();

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {

                if (x == tankX && y == tankY)
                    System.out.print('T');
                else if (bulletActive && x == bulletX && y == bulletY)
                    System.out.print('*');
                else
                    System.out.print(field[y][x]);
            }
            System.out.println();
        }
    }

    static void moveTank(String cmd) throws OutOfFieldException {

        int nx = tankX;
        int ny = tankY;

        if (cmd.equals("w")) ny--;
        if (cmd.equals("s")) ny++;
        if (cmd.equals("a")) nx--;
        if (cmd.equals("d")) nx++;

        if (cmd.equals("f")) {
            if (!bulletActive) {
                bulletX = tankX + 1;
                bulletY = tankY;

                if (bulletX < 0 || bulletX >= field[0].length)
                    throw new OutOfFieldException("Постріл за межі поля!");

                bulletActive = true;
            }
            return;
        }

        if (ny < 0 || ny >= field.length ||
            nx < 0 || nx >= field[0].length)
            throw new OutOfFieldException("Вихід за межі поля!");

        if (field[ny][nx] == 'E') {
            lives--;
            System.out.println("⚠ Ворог атакував! -1 життя");
            return;
        }

        if (field[ny][nx] != '#') {
            tankX = nx;
            tankY = ny;
        }
    }

    static void moveBullet() {

        if (!bulletActive) return;

        bulletX++;

        if (bulletX < 0 || bulletX >= field[0].length) {
            bulletActive = false;
            return;
        }

        if (field[bulletY][bulletX] == '#') {
            bulletActive = false;
            return;
        }

        if (field[bulletY][bulletX] == 'E') {
            field[bulletY][bulletX] = ' ';
            bulletActive = false;
        }
    }

    static void enemyAttack() {

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {

                if (field[y][x] == 'E') {

                    if (Math.abs(x - tankX) + Math.abs(y - tankY) == 1) {
                        lives--;
                        System.out.println("⚠ Ворог поруч! -1 життя");
                        return;
                    }
                }
            }
        }
    }

    static boolean noEnemies() {

        for (int y = 0; y < field.length; y++)
            for (int x = 0; x < field[y].length; x++)
                if (field[y][x] == 'E')
                    return false;

        return true;
    }
}