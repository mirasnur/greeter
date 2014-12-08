package org.jboss.as.quickstarts.greeter.domain;

import org.jboss.as.quickstarts.greeter.TaskState;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by miras on 12/3/14.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column
    private String description;

    @Column
    private Date date;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private TaskState state;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

}
