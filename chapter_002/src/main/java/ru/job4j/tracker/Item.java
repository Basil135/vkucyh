package ru.job4j.tracker;

import java.util.Arrays;

/**
 * This class describes an item.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.04.2017
 */
public class Item {

    /**
     * name of an item.
     */
    private String name;
    /**
     * id of an item.
     */
    private String id;
    /**
     * description of an item.
     */
    private String description;
    /**
     * creation date at milliseconds.
     */
    private long creationDate;
    /**
     * array of a comments to an item.
     */
    private String[] comments;

    /**
     * constructor of a class Item.
     *
     * @param name is name of an item
     * @param id is id of an item
     * @param description is description of an item
     * @param creationDate is creation date of an item
     * @param comments is array of a comments to an item
     */
    public Item(String name, String id, String description, long creationDate, String[] comments) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.comments = comments;
    }

    /**
     * method return name of an item.
     *
     * @return string that is name of an item
     */
    public String getName() {
        return name;
    }

    /**
     * method set string name to an item.
     *
     * @param name is name of an item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method return id of an item.
     *
     * @return string id of an item
     */
    public String getId() {
        return id;
    }

    /**
     * method set string id to an item.
     *
     * @param id is id of an item
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method return description of an item.
     *
     * @return string that is description of an item
     */
    public String getDescription() {
        return description;
    }

    /**
     * method set description string to an item.
     *
     * @param description is description of an item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * method return creation date at milliseconds of an item.
     *
     * @return creation date
     */
    public long getCreationDate() {
        return creationDate;
    }

    /**
     * method set creation date at milliseconds to an item.
     *
     * @param creationDate is creation date of an item
     */
    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * method return array of string as comments to an item.
     *
     * @return array of string
     */
    public String[] getComments() {
        return comments;
    }

    /**
     * method set array of comments to an item.
     *
     * @param comments is array of comments
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }

    /**
     * method compare this to o.
     *
     * @param o is input object
     * @return return true if this equals to o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (creationDate != item.creationDate) {
            return false;
        }
        if (!name.equals(item.name)) {
            return false;
        }
        if (!id.equals(item.id)) {
            return false;
        }
        if (description != null ? !description.equals(item.description) : item.description != null) {
            return false;
        }
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(comments, item.comments);
    }

    /**
     * method generate integer number.
     *
     * @return integer number
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (creationDate ^ (creationDate >>> 32));
        result = 31 * result + Arrays.hashCode(comments);
        return result;
    }
}