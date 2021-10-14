package com.example.lib.Model;

import android.text.Editable;

public class SinhVienInsert {
    private String groupName;

    private String imageUrl;

    private String title;

    private String content;

    public String getGroupName ()
    {
        return groupName;
    }

    public void setGroupName (String groupName)
    {
        this.groupName = groupName;
    }

    public String getImageUrl ()
    {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [groupName = "+groupName+", imageUrl = "+imageUrl+", title = "+title+", content = "+content+"]";
    }

}
