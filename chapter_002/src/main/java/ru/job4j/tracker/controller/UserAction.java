package ru.job4j.tracker.controller;

import ru.job4j.tracker.models.Item;

/**
 * this class contains inner classes as user's actions and managed all actions.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 18.04.2017
 */
public class UserAction {

    /**
     * object of interface Input.
     */
    private final Input input;
    /**
     * object of class Tracker.
     */
    private final Tracker tracker;
    /**
     * array of user's actions.
     */
    private final IAction[] actions = new IAction[7];

    /**
     * constructor of class.
     *
     * @param input is object of interface Input
     * @param tracker is object of class Tracker
     */
    public UserAction(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method fill array of actions.
     */
    public void fillActions() {

        actions[0] = new UserAction.AddItem();
        actions[1] = new UserAction.FindAll();
        actions[2] = new UserAction.UpdateItem();
        actions[3] = new UserAction.DeleteItem();
        actions[4] = new UserAction.FindItemById();
        actions[5] = new UserAction.FindItemsByName();
        actions[6] = new UserAction.ExitTracker();

    }

    /**
     * method return all actions as String.
     *
     * @return actions as String
     */
    public String actionsToString() {

        StringBuilder result = new StringBuilder();

        for (IAction action : actions) {

            if (action != null) {

                result.append("\n");
                result.append(action.info());
                result.append("\n");

            }

        }

        return result.toString();

    }

    /**
     * method select action from array of actions.
     *
     * @param key is user's selection
     * @return action that need to be execute
     */
    public IAction select(int key) {
        return actions[key];
    }

    /**
     * This inner class add item to tracker.
     */
    private class AddItem implements IAction {

        /**
         * method execute the action add item to tracker.
         *
         * @param input object of interface Input
         * @param tracker object of class Tracker
         * @return item as String
         */
        @Override
        public String execute(Input input, Tracker tracker) {

            String name = input.ask("\nplease enter name:\n");
            String desc = input.ask("\nplease enter description of item:\n");

            Item item = new Item(name, desc, null);

            return tracker.add(item).toString();

        }

        /**
         * method return number as key of action.
         *
         * @return number as key of action
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * method return info of action.
         *
         * @return String info
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add item to tracker.");
        }

    }

    /**
     * inner class find all items from tracker.
     */
    private class FindAll implements IAction {

        /**
         * method execute the action.
         *
         * @param input object of interface Input
         * @param tracker object of class Tracker
         * @return item as String
         */
        @Override
        public String execute(Input input, Tracker tracker) {

            StringBuilder result = new StringBuilder();

            for (Item item : tracker.findAll()) {

                result.append("\n");
                result.append(item.toString());
                result.append("\n");

            }

            return result.toString();

        }

        /**
         * method return number as key of action.
         *
         * @return number as key of action
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * method return info of action.
         *
         * @return String info
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find all items.");
        }

    }

    /**
     * inner class update item.
     */
    public class UpdateItem implements IAction {

        /**
         * item that we need to update.
         */
        private Item itemToUpdate;
        /**
         * array of actions for updating item.
         */
        private final IAction[] actionsToUpdate = new IAction[2];

        /**
         * method fill array of actions to updating item.
         */
        private void fillActionsToUpdate() {
            actionsToUpdate[0] = new UserAction.UpdateItem.RenameItem();
            actionsToUpdate[1] = new UserAction.UpdateItem.SetNewDescriptionToItem();
        }

        /**
         * method select action from array of actions.
         *
         * @param key is users select
         * @return return action that need to be executed
         */
        private IAction selectUpdate(int key) {
            return actionsToUpdate[key];
        }

        /**
         * method return array of actions for updating as String.
         *
         * @return array of actions for updating as String
         */
        public String actionsToUpdateToString() {

            fillActionsToUpdate();

            StringBuilder result = new StringBuilder();

            for (IAction action : actionsToUpdate) {

                    result.append("\n");
                    result.append(action.info());
                    result.append("\n");

            }

            return result.toString();

        }

        /**
         * method execute the action.
         *
         * @param input object of interface Input
         * @param tracker object of class Tracker
         * @return item as String
         */
        @Override
        public String execute(Input input, Tracker tracker) {

            String id = input.ask("\nplease type id of item:\n");

             itemToUpdate = tracker.findById(id);

             int key = Integer.valueOf(input.ask(actionsToUpdateToString() + "\nplease type number that you need to update:\n"));

             IAction action = UserAction.UpdateItem.this.selectUpdate(key);

             action.execute(input, tracker);

            return "Item successfully updated.";

        }

        /**
         * method return number as key of action.
         *
         * @return number as key of action
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * method return info of action.
         *
         * @return String info
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Update item.");
        }

        /**
         * set new name to item.
         */
        private class RenameItem implements IAction {

            /**
             * method execute the action.
             *
             * @param input object of interface Input
             * @param tracker object of class Tracker
             * @return item as String
             */
            @Override
            public String execute(Input input, Tracker tracker) {

                String name = input.ask("\nplease type new name to item.\n");
                itemToUpdate.setName(name);

                return String.format("item %s successfully rename", name);
            }

            /**
             * method return number as key of action.
             *
             * @return number as key of action
             */
            @Override
            public int key() {
                return 0;
            }

            /**
             * method return info of action.
             *
             * @return String info
             */
            @Override
            public String info() {
                return String.format("%s. %s", this.key(), "Rename item.");
            }

        }

        /**
         * inner class set new description to item.
         */
        private class SetNewDescriptionToItem implements IAction {

            /**
             * method execute the action.
             *
             * @param input object of interface Input
             * @param tracker object of class Tracker
             * @return item as String
             */
            @Override
            public String execute(Input input, Tracker tracker) {

                String description = input.ask("\nplease type new description to item.\n");
                itemToUpdate.setDescription(description);

                return "new description successfully added.";
            }

            /**
             * method return number as key of action.
             *
             * @return number as key of action
             */
            @Override
            public int key() {
                return 1;
            }

            /**
             * method return info of action.
             *
             * @return String info
             */
            @Override
            public String info() {
                return String.format("%s. %s", this.key(), "Set new description to item.");
            }

        }

    }

    /**
     * inner class delete item.
     */
    private class DeleteItem implements IAction {

        /**
         * method execute the action.
         *
         * @param input object of interface Input
         * @param tracker object of class Tracker
         * @return item as String
         */
        @Override
        public String execute(Input input, Tracker tracker) {

            String id = input.ask("\nplease type id of item you want to delete.\n");
            Item item = tracker.findById(id);
            tracker.delete(item);

            return "\nitem successfully deleted.\n";

        }

        /**
         * method return number as key of action.
         *
         * @return number as key of action
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * method return info of action.
         *
         * @return String info
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete Item by id.");
        }

    }

    /**
     * inner class find item by id.
     */
    private class FindItemById implements IAction {

        /**
         * method execute the action.
         *
         * @param input object of interface Input
         * @param tracker object of class Tracker
         * @return item as String
         */
        @Override
        public String execute(Input input, Tracker tracker) {

            String id = input.ask("\nplease type id of item you need to find:\n");

            Item item = tracker.findById(id);

            return item.toString();

        }

        /**
         * method return number as key of action.
         *
         * @return number as key of action
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * method return info of action.
         *
         * @return String info
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id.");
        }

    }

    /**
     * inner class find items by name.
     */
    private class FindItemsByName implements IAction {

        /**
         * method execute the action.
         *
         * @param input object of interface Input
         * @param tracker object of class Tracker
         * @return item as String
         */
        @Override
        public String execute(Input input, Tracker tracker) {

            StringBuilder result = new StringBuilder();

            String name = input.ask("\nplease type name:\n");

            for (Item item : tracker.findByName(name)) {
                result.append("\n");
                result.append(item.toString());
                result.append("\n");
            }

            return result.toString();
        }

        /**
         * method return number as key of action.
         *
         * @return number as key of action
         */
        @Override
        public int key() {
            return 5;
        }

        /**
         * method return info of action.
         *
         * @return String info
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name.");
        }

    }

    /**
     * inner class exit from tracker.
     */
    private class ExitTracker implements IAction {

        /**
         * method execute the action.
         *
         * @param input object of interface Input
         * @param tracker object of class Tracker
         * @return item as String
         */
        @Override
        public String execute(Input input, Tracker tracker) {
            return "\nGood Bye!";
        }

        /**
         * method return number as key of action.
         *
         * @return number as key of action
         */
        @Override
        public int key() {
            return 6;
        }

        /**
         * method return info of action.
         *
         * @return String info
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit tracker.");
        }

    }

}
