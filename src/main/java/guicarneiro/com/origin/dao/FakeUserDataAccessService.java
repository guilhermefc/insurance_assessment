package guicarneiro.com.origin.dao;

import guicarneiro.com.origin.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {

    private static final List<User> DB = new ArrayList<>();

    @Override
    public int addUser(User user) {
        DB.add(user);
        return 1;
    }

    @Override
    public List<User> getAllUsers() {
        return DB;
    }
}
