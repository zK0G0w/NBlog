package top.naccl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.naccl.entity.Slogan;
import top.naccl.service.SloganService;

/**
 * @Description:返回LinuxDo尾图
 * @Author: WainZeng
 * @Date: 2024/9/27 10:19
 */

@Controller
@RequestMapping("/LinuxDo/v1")
public class SloganController {

    @Autowired
    private SloganService sloganService;

    @GetMapping("/slogan")
    public String getRandomSlogan(Model model) {
        String slogan = sloganService.getRandomSlogan();
        model.addAttribute("slogan", slogan);
        return "svg";
    }

    @GetMapping("/add")
    public String showAddSloganForm() {
        return "addSlogan"; // 返回显示表单的页面
    }

    @PostMapping("/addslogan")
    public String addSlogan(@RequestParam("content") String content, Model model) {
        // 检查输入内容是否为空
        if (content == null || content.trim().isEmpty()) {
            model.addAttribute("error", "Slogan content cannot be empty.");
            return "addSlogan"; // 返回到添加 slogan 的页面
        }

        // 创建 Slogan 对象并保存
        Slogan slogan = new Slogan();
        slogan.setContent(content);

        try {
            // 调用服务层插入 Slogan
            sloganService.insertSlogan(slogan);
            model.addAttribute("message", "Slogan added successfully.");
            return "addSlogan"; // 或者返回到成功后的页面
        } catch (Exception e) {
            model.addAttribute("error", "Failed to add slogan.");
            e.printStackTrace(); // 输出异常信息
            return "addSlogan";
        }
    }

}
