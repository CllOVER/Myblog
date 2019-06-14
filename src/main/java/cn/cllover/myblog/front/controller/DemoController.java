package cn.cllover.myblog.front.controller;

import cn.cllover.myblog.common.controller.BaseController;
import cn.cllover.myblog.front.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController extends BaseController {


    @RequestMapping("404")
    public String qwqw(Model model) {
        User currentUser = super.getCurrentUser();
        model.addAttribute("user",currentUser);
        return "404";
    }


}
