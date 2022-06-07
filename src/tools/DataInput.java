package tools;

import data.*;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Класс, осуществляющий ввод пользователем параметров объекта MusicBand
 */


public class DataInput {

    public static String askName() {
        String name;
        while (true) {

            try {
                if (CommandFinder.scriptMode) {
                    name = ConsoleUI.bufferedReader.readLine();
                } else {
                    ConsoleUI.output("Введите имя продукта: ");
                    name = ConsoleUI.reader.next();
                }
                if (name.equals("")) {
                    ConsoleUI.output("Строка пустая! Введите имя продукта.");
                    continue;
                }
                break;
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return name;
    }

    public static long askX() {
        long x;
        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    x = Long.parseLong(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите число х: ");
                    x = Long.parseLong(ConsoleUI.reader.next());
                }
                break;
            } catch (final NumberFormatException e) {
                ConsoleUI.output("Х должен быть числом! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return x;
    }

    public static Double askY() {
        Double y;
        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    y = Double.parseDouble(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите число y: ");
                    y = Double.parseDouble(ConsoleUI.reader.next());
                }
                break;
            } catch (final NumberFormatException e) {
                ConsoleUI.output("Y должен быть числом! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return y;
    }

    public static Coordinates askCoordinates() {
        return new Coordinates(askX(), askY());
    }


    public static long askPrice() {
        long price;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    price = Integer.parseInt(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите цену продукта: ");
                    price = Integer.parseInt(ConsoleUI.reader.next());
                }
                if (price > 0)
                    break;
                else {
                    ConsoleUI.output("Цена должна быть больше нуля! Повторите ввод.");
                }
            } catch (final NumberFormatException e) {
                ConsoleUI.output("Количество участников должно быть числом больше нуля! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return price;
    }


    public static UnitOfMeasure askUnitOfMeasure() {
        String string;
        UnitOfMeasure unitOfMeasure;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    string = ConsoleUI.bufferedReader.readLine();
                } else {
                    ConsoleUI.output("Список доступных способов измерения: \n" + UnitOfMeasure.toListString());
                    ConsoleUI.output("Выберите нужный тип: ");
                    string = ConsoleUI.reader.next();
                }
                unitOfMeasure = UnitOfMeasure.valueOf(string.toUpperCase());
                break;
            } catch (NoSuchElementException | IllegalArgumentException | IllegalStateException e) {
                ConsoleUI.output("Что-то пошло не так! Выберите тип ещё раз.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return unitOfMeasure;
    }


    public static long askIdOrganization() {
        long id;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    id = Long.parseLong(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите id организации: ");
                    id = Long.parseLong(ConsoleUI.reader.next());
                }
                if (id > 0)
                    break;
                else {
                    ConsoleUI.output("id быть числом больше нуля! Повторите ввод.");
                }
            } catch (final NumberFormatException e) {
                ConsoleUI.output("id должно быть числом больше нуля! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return id;
    }

    public static String askNameOrganization() {
        String name;
        while (true) {

            try {
                if (CommandFinder.scriptMode) {
                    name = ConsoleUI.bufferedReader.readLine();
                } else {
                    ConsoleUI.output("Введите имя организации: ");
                    name = ConsoleUI.reader.next();
                }
                if (name.equals("")) {
                    ConsoleUI.output("Строка пустая! Введите имя организации.");
                    continue;
                }
                break;
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return name;
    }
    public static long askAnnualTurnover() {
        long annualTurnover;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    annualTurnover = Long.parseLong(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите id организации: ");
                    annualTurnover = Long.parseLong(ConsoleUI.reader.next());
                }
                if (annualTurnover > 0)
                    break;
                else {
                    ConsoleUI.output("id быть числом больше нуля! Повторите ввод.");
                }
            } catch (final NumberFormatException e) {
                ConsoleUI.output("id должно быть числом больше нуля! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return annualTurnover;
    }
    public static OrganizationType askOrganizationType() {
        String string;
        OrganizationType organizationType;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    string = ConsoleUI.bufferedReader.readLine();
                } else {
                    ConsoleUI.output("Список доступных типов организации: \n" + OrganizationType.toListString());
                    ConsoleUI.output("Выберите нужный тип: ");
                    string = ConsoleUI.reader.next();
                }
                organizationType = OrganizationType.valueOf(string.toUpperCase());
                break;
            } catch (NoSuchElementException | IllegalArgumentException | IllegalStateException e) {
                ConsoleUI.output("Что-то пошло не так! Выберите тип ещё раз.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return organizationType;
    }
    public static Organization askOrganization() {
        return new Organization(askIdOrganization(), askNameOrganization(),askAnnualTurnover(),askOrganizationType());
    }


    public static Product askMusicBand () {
            return new Product(askName(), askCoordinates(),askPrice(), askUnitOfMeasure(),askOrganization());
        }
}
