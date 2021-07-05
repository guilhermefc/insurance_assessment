package guicarneiro.com.origin.dao;

import guicarneiro.com.origin.model.User;

import java.util.List;

public interface UserDao {

    int addUser(User user);

    List<User> getAllUsers();
}
