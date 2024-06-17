package org.sesame.pdl.Controller;

import lombok.AllArgsConstructor;
import org.sesame.pdl.Entity.Project;
import org.sesame.pdl.Entity.User;
import org.sesame.pdl.Service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {

    private IUserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }

    @GetMapping ("/getById/{id}")
    public User getByIdUser (@PathVariable int id)

    {
        return userService.getByIdUser(id);
    }

    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user
    )
    {
        return userService.saveUser(user);
    }

    @PutMapping ("/updateUser/{id}")
    public User updateUser(@RequestBody User user , @PathVariable int id )
    {
        user.setId(id);
        return userService.updateUser(user,id);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteUser(@PathVariable int id)
    {

        userService.deleteUser(id);
    }

   /* @PutMapping("/affecterTacheUser/{nomTache}")

    public void affecterTacheToUser(@PathVariable String nomTache, @RequestBody User user)
    {
        userService.affecterTacheToUser(nomTache,user);
    }*/



}
