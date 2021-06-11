package com.codeup.anameforyourprojectwithoutspaces;


import javax.persistence.*;

@Entity
@Table(name="not_a_table")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String table_leg1;

    @Column(nullable = false)
    private String table_leg2;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getTable_leg1() {
    return table_leg1;
}

public void setTable_leg1(String table_leg1) {
    this.table_leg1 = table_leg1;
}

    public String getTable_leg2() {
        return table_leg2;
    }

    public void setTable_leg2(String table_leg2) {
        this.table_leg2 = table_leg2;
    }
}
