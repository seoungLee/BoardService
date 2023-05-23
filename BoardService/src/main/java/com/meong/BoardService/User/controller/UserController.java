package com.meong.BoardService.User.controller;

import com.meong.BoardService.User.dto.UserDTO;
import com.meong.BoardService.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    // DI
    private final UserService userService;
    // 최원가입 페이지
    @GetMapping("/save")
    public String saveForm(){
        return "/User/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UserDTO userDTO){
        userService.save(userDTO);
        return "/User/login";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "/User/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session){
        UserDTO loginResult = userService.login(userDTO);
        if(loginResult != null){
            // 로그인 성공
            session.setAttribute("loginUser", loginResult.getUsername());
            return "/User/main";
        }else{
            // 로그인 실패
            return "/User/login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<UserDTO> userDTOList = userService.findAll();
        model.addAttribute("userList", userDTOList);
        return "/User/list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        UserDTO userDTO = userService.findById(id);
        model.addAttribute("user", userDTO);
        return "/User/detail";
    }

    @GetMapping("/update")
    public String updateForm(HttpSession session,Model model){
        String myUser = (String)session.getAttribute("loginUser");
        UserDTO userDTO = userService.updeteForm(myUser);
        model.addAttribute("updateUser",userDTO);
        return "/User/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute UserDTO userDTO){
        userService.update(userDTO);
        return "redirect:/user/" + userDTO.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/user/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
    @PostMapping("/userCheck")
    public @ResponseBody String userCheck(@RequestParam("username") String username){
        String checkResult = userService.userCheck(username);
        return checkResult;
//        if(checkResult != null){
//            return "ok";
//        }else {
//            return "no";
//        }
    }

}
