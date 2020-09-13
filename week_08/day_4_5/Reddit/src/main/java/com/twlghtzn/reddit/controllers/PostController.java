package com.twlghtzn.reddit.controllers;

import com.twlghtzn.reddit.models.Post;
import com.twlghtzn.reddit.services.PostService;
import com.twlghtzn.reddit.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class PostController {
  private final PostService postService;
  private final UserService userService;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public String showTrendingPosts(Model model, @RequestParam(name = "id", required = false) Long id,
                                  @RequestParam(name = "page", required = false) String page) {
    if (id != null) {
      model.addAttribute("user", userService.getUserById(id));
      model.addAttribute("info", "userPresent");
      model.addAttribute("id", id);
    }
    if (page != null) {
      int pageNumber = Integer.parseInt(page);
      model.addAttribute("posts", postService.getPostsPerPage(pageNumber));
      model.addAttribute("actualPage", pageNumber);
    } else {
      model.addAttribute("posts", postService.getPostsPerPage(0));
      model.addAttribute("actualPage", 0);
    }
    model.addAttribute("pages", postService.getPages());
    return "index";
  }

  @PostMapping(path = "/")
  public String navigateToPage(@RequestParam(name = "page") String page) {
    return "redirect:/?page=" + page;
  }

  @PostMapping(path = "/voteup")
  public String votePostUp(@RequestParam(name = "postId") Long postId,
                           @RequestParam(name = "id") Long id,
                           @RequestParam(name = "page") String page) {
    postService.voteUp(postId, id);
    return "redirect:/?id=" + id + "&page=" + page;
  }

  @PostMapping(path = "/votedown")
  public String votePostDown(@RequestParam(name = "postId") Long postId,
                             @RequestParam(name = "id") Long id,
                             @RequestParam(name = "page") String page) {
    postService.voteDown(postId, id);
    return "redirect:/?id=" + id + "&page=" + page;
  }

  @RequestMapping(path = "/submit", method = RequestMethod.GET)
  public String showSubmitPostPage(Model model, @RequestParam(name = "id") Long id) {
    model.addAttribute("id", id);
    return "submit";
  }

  @PostMapping(path = "/submit")
  public String submitPost(@RequestParam(name = "title") String title,
                           @RequestParam(name = "url") String url,
                           @RequestParam(name = "id") Long id) {
    postService.addPost(new Post(title, url, userService.getUserById(id)));
    return "redirect:/?id=" + id;
  }


}
