package tools;

import commands.*;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class CommandManager {
    private InsertCommand addCommand;
    private ClearCommand clearCommand;
    private ExecuteScriptCommand executeScriptCommand;
    private HelpCommand helpCommand;
    private InfoCommand infoCommand;
    private RemoveKeyCommand removeKey;
    private SaveCommand saveCommand;
    private ShowCommand showCommand;
    private UpdateIdCommand updateIdCommand;
    private ExitCommand exitCommand;
    private RemoveLowerCommand removeLowerCommand;
    private ReplaceIfGreaterCommand replaceIfGreaterCommand;
    private ReplaceIfLowerCommand replaceIfLowerCommand;
    private PrintDescendingCommand printDescendingCommand;
    private PrintDescendingPriceCommand printDescendingPriceCommand;
    private PrintDescendingUnitOfMeasureCommand printDescendingUnitOfMeasureCommand;

    private final Integer HISTORY_SIZE = 6;
    private List<Command> commands;

    public CommandManager(InsertCommand addCommand, ClearCommand clearCommand,
                          ExecuteScriptCommand executeScriptCommand, HelpCommand helpCommand,
                          InfoCommand infoCommand, RemoveKeyCommand removeKey,
                          SaveCommand saveCommand, ShowCommand showCommand, UpdateIdCommand updateIdCommand,
                          ExitCommand exitCommand,ReplaceIfLowerCommand replaceIfLowerCommand, RemoveLowerCommand removeLowerCommand,
                          ReplaceIfGreaterCommand replaceIfGreaterCommand,PrintDescendingCommand printDescendingCommand, PrintDescendingPriceCommand printDescendingPriceCommand,PrintDescendingUnitOfMeasureCommand printDescendingUnitOfMeasureCommand) {
        this.addCommand = addCommand;
        this.clearCommand = clearCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.removeKey = removeKey;
        this.saveCommand = saveCommand;
        this.showCommand = showCommand;
        this.updateIdCommand = updateIdCommand;
        this.exitCommand = exitCommand;
        this.removeLowerCommand = removeLowerCommand;
        this.replaceIfGreaterCommand = replaceIfGreaterCommand;
        this.replaceIfLowerCommand = replaceIfLowerCommand;
        this.printDescendingCommand = printDescendingCommand;
        this.printDescendingPriceCommand = printDescendingPriceCommand;
        this.printDescendingUnitOfMeasureCommand = printDescendingUnitOfMeasureCommand;

        commands =new ArrayList();
        commands.add(addCommand);
        commands.add(clearCommand);
        commands.add(executeScriptCommand);
        commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(removeKey);
        commands.add(saveCommand);
        commands.add(showCommand);
        commands.add(updateIdCommand);
        commands.add(exitCommand);
        commands.add(removeLowerCommand);
        commands.add(replaceIfGreaterCommand);
        commands.add(replaceIfLowerCommand);
        commands.add(printDescendingCommand);
        commands.add(printDescendingPriceCommand);
        commands.add(printDescendingUnitOfMeasureCommand);
       /* addCommand, clearCommand, executeScriptCommand, helpCommand,
                infoCommand, removeKey, saveCommand, showCommand, updateIdCommand, exitCommand, removeLowerCommand,
                replaceIfLowerCommand,printDescendingCommand, printDescendingPriceCommand, printDescendingUnitOfMeasureCommand
       {

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public Object set(int index, Object element) {
                return null;
            }

            @Override
            public void add(int index, Object element) {

            }

            @Override
            public Object remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator listIterator() {
                return null;
            }

            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            //@Override
            //public T[] toArray(Object[] a) {
            //    return new T[0];
            //}
        };*/

    }

    public CommandManager(InsertCommand addCommand, ClearCommand clearCommand, ExecuteScriptCommand executeScriptCommand, HelpCommand helpCommand, InfoCommand infoCommand, RemoveKeyCommand removeKey, SaveCommand saveCommand, ShowCommand showCommand, UpdateIdCommand updateIdCommand, ReplaceIfGreaterCommand replaceIfGreaterCommand, ReplaceIfLowerCommand replaceIfLowerCommand, RemoveLowerCommand removeLowerCommand, PrintDescendingCommand printDescendingCommand, PrintDescendingPriceCommand printDescendingPriceCommand, PrintDescendingUnitOfMeasureCommand printDescendingUnitOfMeasureCommand) {
    }


    public String help() {
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("insert null {element} : добавить новый элемент с заданным ключом");
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_key null : удалить элемент из коллекции по его ключу");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого");
        System.out.println("replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого");
        System.out.println("remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный");
        System.out.println("print_descending : вывести элементы коллекции в порядке убывания");
        System.out.println("print_field_descending_price : вывести значения поля price всех элементов в порядке убывания");
        System.out.println("print_field_descending_unit_of_measure : вывести значения поля unitOfMeasure всех элементов в порядке убывания");

        return "";
    }


    public String commandsString() {
        return commands.stream()
                .map(x -> x.getName())
                .collect(Collectors.joining("\n"));
    }

}
