package lt.codeacademy.demo.controller;


import lt.codeacademy.demo.entity.Post;
import lt.codeacademy.demo.service.PostService;
import lt.codeacademy.demo.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public record HomeController(PostService postService) {

    @Autowired
    public HomeController {
    }

    @GetMapping("/home")
    public String home(@RequestParam(defaultValue = "0") int page,
                       Model model) {

        Page<Post> posts = postService.findAllOrderedByDatePageable(page);
        Pager pager = new Pager(posts);

        model.addAttribute("pager", pager);

        return "/home";
    }
}
