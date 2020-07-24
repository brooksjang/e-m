package com.example.em.controller;

import com.alibaba.fastjson.JSON;
import com.example.em.pojo.UserVO;
import com.example.em.service.IUserSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserSV userSV;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        String result = "";
        try {
            UserVO user = userSV.getUserByAcctInfo(username, password);
            if (user != null) {
                session.setAttribute("loginUser", user.getuAcct());
                session.setAttribute("userName", user.getuName());
                result = "redirect:/main.html";
            } else {
                model.addAttribute("msg", "账号或密码错误");
                result = "index";
            }
        } catch (Exception e) {
            logger.info("登录异常", e);
            throw new RuntimeException();
        }

        return result;
    }

    /**
     * 该接口仅仅用于测试登录逻辑
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login2")
    @ResponseBody
    public UserVO login2(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        UserVO user = userSV.getUserByAcctInfo(username, password);
        logger.info("user：" + JSON.toJSONString(user));
        return user;
    }

    @RequestMapping("/loginOut")
    public String loginOut(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
