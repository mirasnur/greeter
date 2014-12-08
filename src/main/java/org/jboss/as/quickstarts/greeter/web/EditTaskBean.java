package org.jboss.as.quickstarts.greeter.web;

import org.jboss.as.quickstarts.greeter.TaskState;
import org.jboss.as.quickstarts.greeter.domain.Task;
import org.jboss.as.quickstarts.greeter.domain.User;
import org.jboss.as.quickstarts.greeter.domain.UserDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class EditTaskBean implements Serializable {

    private List<Task> list;
    private Task task = new Task();
    private boolean edit;
    private User user;

    @Inject
    private UserDao userDao;


    @PostConstruct
    public void init() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String username = (String) facesContext.getExternalContext().
                getRequestParameterMap().get("id");

        user = userDao.getForUsername(username);
        list = user.getTasks();
    }


    public void edit(Task task) {
        this.task = task;
        edit = true;
    }

    public void save() {
        userDao.save(user);
        task = new Task();
        edit = false;
    }

    public void delete(Task task) {
        list.remove(task);
        userDao.save(user);
    }

    public void mark(Task task){
        task.setState(TaskState.DONE);
        userDao.save(user);
    }
    public List<Task> getList() {
        return list;
    }



    public boolean isEdit() {
        return edit;
    }


    public Task getTask() {
        return task;
    }


    public User getUser() {
        return user;
    }
}
