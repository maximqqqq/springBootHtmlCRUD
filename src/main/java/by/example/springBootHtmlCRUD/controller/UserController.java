package by.example.springBootHtmlCRUD.controller;

import by.example.springBootHtmlCRUD.madel.User;
import by.example.springBootHtmlCRUD.servise.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private UserServise userServise;

    @Autowired
    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/users")//при переходе по ссылке ussers я буду реолизовать функционал метода
    public String findAll(Model model){
        List<User> users = userServise.findAll();
        model.addAttribute("users",users);//Возьми "users" со стр. html и положи в него users
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userServise.saveUser(user);//Сохрани user
        return "redirect:/users";//и переодресуй меня на страницу users
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userServise.deleteById(id);
        return "redirect:/users";//и переодресуй меня на страницу users
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user= userServise.findById(id);//Получил user по id
        model.addAttribute("user",user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userServise.saveUser(user);
        return "redirect:/users";
    }
}
