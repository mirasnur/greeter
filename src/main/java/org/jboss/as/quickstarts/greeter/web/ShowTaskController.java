package org.jboss.as.quickstarts.greeter.web;

import org.jboss.as.quickstarts.greeter.domain.Task;
import org.jboss.as.quickstarts.greeter.domain.User;
import org.jboss.as.quickstarts.greeter.domain.UserDao;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by miras on 12/3/14.
 */
@Named
@RequestScoped
public class ShowTaskController {

    private List<User> users;

    @Inject
    private UserDao userDao;


    public List<User> getUsers() {
        return userDao.getAll();
    }

}
