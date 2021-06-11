package com.codeup.anameforyourprojectwithoutspaces;

import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //all ads have an ad.title
    @Column(nullable = false, length = 100)
    private String title;

    //all ads
    @Column(nullable = false)
    private String description;
}

    public Ad() {
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

}