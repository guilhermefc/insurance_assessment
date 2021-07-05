package guicarneiro.com.origin.api;

import guicarneiro.com.origin.model.RiskAssessment;
import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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
