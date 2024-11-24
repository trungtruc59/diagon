package com.kt.diagon.controller.admin;

import com.kt.diagon.models.Roles;
import com.kt.diagon.models.User;
import com.kt.diagon.service.RoleService;
import com.kt.diagon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/nhan-vien")
    public String nhanVien(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/pages/user";
    }

    @GetMapping("/user/form")
    public String nhanVienForm(@RequestParam(defaultValue = "0") Long id, Model model) {
        List<Roles> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        if (id > 0) {
            User u = userService.getUserById(id);
            model.addAttribute("user", u);
            model.addAttribute("isUpdate", true);
        }
        else {
            model.addAttribute("isUpdate", false);
            model.addAttribute("user", new User());
        }
        return "admin/forms/_user_form";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam(defaultValue = "0") Long id, Model model) {

        model.addAttribute("userId", id);
        return "admin/forms/_user_delete";
    }

    @PostMapping("/nhan-vien")
    public String addUser (@ModelAttribute User user, Model model) {
        userService.addUser(user);
        return "redirect:/nhan-vien";
    }

    @PostMapping("/nhan-vien/{id}")
    public String updateUser (@PathVariable long id, @ModelAttribute User user, Model model) {
        userService.updateUser(user);
        return "redirect:/nhan-vien";
    }

    @PostMapping("/nhan-vien/delete/{id}")
    public String deleteUser (@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/nhan-vien";
    }
}
