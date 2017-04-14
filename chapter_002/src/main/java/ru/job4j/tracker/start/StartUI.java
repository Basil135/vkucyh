package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

/**
 * This class is UI of application tracker.
 *
 * @author Kucykh Vasily (mailto.basil135@mail.ru)
 * @version $Id$
 * @since 13.04.2017
 */
public class StartUI {

    /**
     * parameter input is interface Input.
     */
    private Input input;
    /**
     * parameter tracker is object Tracker class.
     */
    private Tracker tracker;

    /**
     * constructor of StartUI class.
     *
     * @param input is Input interface
     * @param tracker is object of Tracker class
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * main method.
     *
     * @param args are input args
     */
    public static void main(String[] args) {

        Input consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();

        new StartUI(consoleInput, tracker).init();

    }

    /**
     * method initialize tracker application.
     */
    public void init() {

        int answer;

        String mainMenu = mainMenu();

        boolean condition = true;

        while (condition) {

            answer = Integer.parseInt(input.ask(mainMenu));

            if (answer == 6) {
                condition = false;
            } else if (answer == 0) {
                setItem(input, tracker);
            } else if (answer == 1) {
                showAllItems(tracker);
            } else if (answer == 2) {
                update(input, tracker);
            } else if (answer == 3) {
                deleteItem(input, tracker);
            } else if (answer == 4) {
                System.out.println(findById(input, tracker).toString());
            } else if (answer == 5) {
                findItemsByName(input, tracker);
            }

        }

    }

    /**
     * method update item in tracker.
     *
     * @param input is object of ConsoleInput class
     * @param tracker is object of Tracker class
     */
    private static void update(Input input, Tracker tracker) {

        int chooseUpdate;

        Item updateItem;

        updateItem = tracker.findById(
                input.ask("print id of item: ")
        );
        chooseUpdate = Integer.parseInt(
                input.ask("what line do you need to update?\n1. Name\n2. Description")
        );

        if (chooseUpdate == 1) {
            updateItem.setName(
                    input.ask("Enter new name to item: ")
            );
            tracker.update(updateItem);
        } else if (chooseUpdate == 2) {
            updateItem.setDescription(
                    input.ask("Enter new description to item: ")
            );
            tracker.update(updateItem);
        }

    }

    /**
     * method find item by id from tracker.
     *
     * @param input is object of ConsoleInput class
     * @param tracker is object of Tracker class
     * @return found item
     */
    private static Item findById(Input input, Tracker tracker) {
        return tracker.findById(
                input.ask("print id of item: ")
        );
    }

    /**
     * method return string as main menu.
     *
     * @return string as main menu
     */
    private static String mainMenu() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("0. Add new Item\n");
        stringBuilder.append("1. Show all Items\n");
        stringBuilder.append("2. Edit item\n");
        stringBuilder.append("3. Delete Item\n");
        stringBuilder.append("4. Find Item by id\n");
        stringBuilder.append("5. Find Items by name\n");
        stringBuilder.append("6. Exit program\n");
        stringBuilder.append("Select: ");

        return stringBuilder.toString();

    }

    /**
     * method set item to tracker.
     *
     * @param input is object of ConsoleInput class
     * @param tracker is object of Tracker class
     */
    private static void setItem(Input input, Tracker tracker) {

        String[] addItems = new String[2];

        addItems[0] = "input name of item: ";
        addItems[1] = "input description of item: ";

        Item item = new Item(null, null, null);
        item.setName(input.ask(addItems[0]));
        item.setDescription(input.ask(addItems[1]));
        System.out.println(tracker.add(item).toString());

    }

    /**
     * method delete item from tracker.
     *
     * @param input is object of ConsoleInput class
     * @param tracker is object of Tracker class
     */
    private static void deleteItem(Input input, Tracker tracker) {
        tracker.delete(findById(input, tracker));
        System.out.println("item successfully removed!");
    }

    /**
     * method show all items from tracker.
     *
     * @param tracker is object of Tracker class
     */
    private static void showAllItems(Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }

    /**
     * method find item by name in tracker.
     *
     * @param input is object of ConsoleInput class
     * @param tracker is object of Tracker class
     */
    private static void findItemsByName(Input input, Tracker tracker) {
        for (Item item : tracker.findByName(input.ask("print name of item: "))) {
            System.out.println(item.toString());
        }
    }

}
