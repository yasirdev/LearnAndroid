package com.yasir.android.customlistview;

import java.util.InputMismatchException;

/**
 * Created by YasirRajpoot on 30/08/2016.
 */
public class RowItem {
    String title,description;
    int image, id;

    public RowItem()
    {

    }

    public RowItem(int id , String title , String description , int image)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
