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
     * main method.
     *
     * @param args are input args
     */
    public static void main(String[] args) {

        int input;

        String mainMenu = mainMenu();

        Tracker tracker = new Tracker();

        ConsoleInput consoleInput = new ConsoleInput();

        boolean condition = true;

        while (condition) {

            input = Integer.parseInt(consoleInput.ask(mainMenu));

            if (input == 6) {
                condition = false;
            } else if (input == 0) {
                setItem(consoleInput, tracker);
            } else if (input == 1) {
                showAllItems(tracker);
            } else if (input == 2) {
                update(consoleInput, tracker);
            } else if (input == 3) {
                deleteItem(consoleInput, tracker);
            } else if (input == 4) {
                System.out.println(findById(consoleInput, tracker).toString());
            } else if (input == 5) {
                findItemsByName(consoleInput, tracker);
            }

        }

    }

    /**
     * method update item in tracker.
     *
     * @param consoleInput is object of ConsoleInput class
     * @param tracker is object of Tracker class
     */
    private static void update(ConsoleInput consoleInput, Tracker tracker) {

        int chooseUpdate;

        Item updateItem;

        updateItem = tracker.findById(
                consoleInput.ask("print id of item: ")
        );
        chooseUpdate = Integer.parseInt(
                consoleInput.ask("what line do you need to update?\n1. Name\n2. Description\n3.comment")
        );

        if (chooseUpdate == 1) {
            updateItem.setName(
                    consoleInput.ask("Enter new name to item: ")
            );
            tracker.update(updateItem);
        } else if (chooseUpdate == 2) {
            updateItem.setDescription(
                    consoleInput.ask("Enter new description to item: ")
            );
            tracker.update(updateItem);
        }

    }

    /**
     * method find item by id from tracker.
     *
     * @param consoleInput is object of ConsoleInput class
     * @param tracker is object of Tracker class
     * @return found item
     */
    private static Item findById(ConsoleInput consoleInput, Tracker tracker) {
        return tracker.findById(
                consoleInput.ask("print id of item: ")
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
     * @param consoleInput is object of ConsoleInput class
     * @param tracker is object of Tracker class
     */
    private static void setItem(ConsoleInput consoleInput, Tracker tracker) {

        String[] addItems = new String[2];

        addItems[0] = "input name of item: ";
        addItems[1] = "input description of item: ";

        Item item = new Item(null, null, null);
        item.setName(consoleInput.ask(addItems[0]));
        item.setDescription(consoleInput.ask(addItems[1]));
        System.out.println(tracker.add(item).toString());

    }

    /**
     * method delete item from tracker.
     *
     * @param consoleInput is object of ConsoleInput class
     * @param tracker is object of Tracker class
     */
    private static void deleteItem(ConsoleInput consoleInput, Tracker tracker) {
        tracker.delete(findById(consoleInput, tracker));
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
     * @param consoleInput is object of ConsoleInput class
     * @param tracker is object of Tracker class
     */
    private static void findItemsByName(ConsoleInput consoleInput, Tracker tracker) {
        for (Item item : tracker.findByName(consoleInput.ask("print name of item: "))) {
            System.out.println(item.toString());
        }
    }

}
