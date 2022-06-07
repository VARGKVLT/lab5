/**
 * Основной класс, осуществляет работу приложения
 * @author Сухарева Софья P3112
 */

import commands.*;
import tools.CollectionManager;
import tools.CommandFinder;
import tools.CommandManager;

public class Main {
    public static void main(String[] args) {


        String readEnv = "READE";
        String writeEnv = "WRITE";
        CollectionManager collectionManager = new CollectionManager(readEnv, writeEnv);
        CommandManager commandManager = new CommandManager(
                new InsertCommand(),
                new ClearCommand(),
                new ExecuteScriptCommand(),
                new HelpCommand(),
                new InfoCommand(),
                new RemoveKeyCommand(),
                new SaveCommand(),
                new ShowCommand(),
                new UpdateIdCommand(),
                new ReplaceIfGreaterCommand(),
                new ReplaceIfLowerCommand(),
                new RemoveLowerCommand(),
                new PrintDescendingCommand(),
                new PrintDescendingPriceCommand(),
                new PrintDescendingUnitOfMeasureCommand()
        );
        CommandFinder commandFinder = new CommandFinder(collectionManager, commandManager);
        commandFinder.commandSearcher();

    }
}
