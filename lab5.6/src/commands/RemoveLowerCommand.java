package commands;

/**
 * Команда remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный
 */
public class RemoveLowerCommand extends Command{
    public RemoveLowerCommand() {
        super("remove_lower_key"," удалить из коллекции все элементы, ключ которых меньше, чем заданный");
    }
}
