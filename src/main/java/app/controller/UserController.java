package app.controller;

import app.dto.AddUserDTO;
import app.dto.AuthUserDTO;
import app.response.GenericResponse;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/demo")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public GenericResponse addUser(@RequestBody AddUserDTO addUserDTO) {
        return userService.addUser(addUserDTO);
    }

    @PostMapping
    public GenericResponse authenticateUser(@RequestBody AuthUserDTO authUserDTO) {
        return userService.authUser(authUserDTO);
    }
}
