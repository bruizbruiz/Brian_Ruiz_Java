package com.company.chatterbook.Models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    List<ChatterPost> chatterPosts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        for (ChatterPost post : chatterPosts) {
                this.chatterPosts.add(post);
        }
    }
}
