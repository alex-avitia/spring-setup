package com.codeup.anameforyourprojectwithoutspaces.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    // spring framework uses this empty constructor
    public Post() {}

    // Insert constructor doesn't require an ID.
    public Post(String title, String description, User owner, List<PostImage> images) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.images = images;
    }

    // Read constructor
    public Post(long id, String title, String description, User owner, List<PostImage> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

}