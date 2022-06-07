package commands;

/**
 * Команда replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого
 */
public class ReplaceIfGreaterCommand extends Command {
    public ReplaceIfGreaterCommand() {
        super("replace_if_lower", " заменить значение по ключу, если новое значение больше старого");
    }
}
