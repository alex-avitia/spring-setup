package com.codeup.anameforyourprojectwithoutspaces.springblog;

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