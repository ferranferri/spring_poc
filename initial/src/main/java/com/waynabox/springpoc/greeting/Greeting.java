package com.waynabox.springpoc.greeting;

/**
 * gretting
 */
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;

    }

    /**
     * Gets the content
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * gets the id
     * @return the id
     */
    public long getId() {
        return id;
    }

}
