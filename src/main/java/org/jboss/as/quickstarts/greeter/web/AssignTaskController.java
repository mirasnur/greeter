package org.jboss.as.quickstarts.greeter.web;

import org.jboss.as.quickstarts.greeter.TaskState;
import org.jboss.as.quickstarts.greeter.domain.Task;
import org.jboss.as.quickstarts.greeter.domain.User;
import org.jboss.as.quickstarts.greeter.domain.UserDao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by miras on 12/3/14.
 */

@Named
@RequestScoped
public class AssignTaskController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private UserDao userDao;

    private List<User> users;

    private String userId;

    @Named
    @Produces
    @RequestScoped
    private Task newTask = new Task();

    public void assign() {
        try {
            User user = userDao.getForUsername(userId);
            newTask.setState(TaskState.ASSIGNED);
            newTask.setUser(user);
            user.getTasks().add(newTask);
            userDao.save(user);
            String message = "A new task with has been created successfully";
            facesContext.addMessage(null, new FacesMessage(message));
        } catch (Exception e) {
            String message = "An error has occured while assigning the task (see log for details)";
            facesContext.addMessage(null, new FacesMessage(message));
        }
    }

    public String cancel(){
       return "/greet.xhtml";
    }


    public List<User> getUsers() {
        return userDao.getAll();
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
