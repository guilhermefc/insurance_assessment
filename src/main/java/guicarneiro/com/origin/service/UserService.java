package guicarneiro.com.origin.service;

import guicarneiro.com.origin.dao.UserDao;
import guicarneiro.com.origin.model.RiskAssessment;
import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.riskAssessment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("fakeDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public RiskAssessment addUser(User user) {
        RiskAssessment riskAssessment = new RiskAssessment(
                new RiskProfileAuto(user).getUserProfile(),
                new RiskProfileLife(user).getUserProfile(),
                new RiskProfileDisability(user).getUserProfile(),
                new RiskProfileHome(user).getUserProfile());

        return riskAssessment;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
