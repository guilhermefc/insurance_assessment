package guicarneiro.com.origin.api;

import guicarneiro.com.origin.model.RiskAssessment;
import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public RiskAssessment addUser(@Valid @NonNull @RequestBody User user) {
        return userService.addUser(user);
    }
}
