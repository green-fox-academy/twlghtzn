package com.twlghtzn.reddit.controllers;

import com.twlghtzn.reddit.models.Post;
import com.twlghtzn.reddit.services.PostService;
import com.twlghtzn.reddit.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SetupController {
  private PostService postService;
  private UserService userService;

  public SetupController(PostService postService,
                         UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @RequestMapping(path = "/setup", method = RequestMethod.GET)
  public String fillEnvironment(Model model) {
    userService.addUser("bela", "1111");
    userService.addUser("geza", "2222");
    userService.addUser("orsi", "3333");
    userService.addUser("andrew", "4444");
    postService.addPost(new Post("Hello how wide is this column", "https://www.google.com",
        userService.getUserById(1L)));
    postService.addPost(new Post("Hi", "https://www.google.com", userService.getUserById(1L)));
    postService.addPost(new Post("What", "https://www.google.com", userService.getUserById(1L)));
    postService.addPost(new Post("Great", "https://www.google.com", userService.getUserById(2L)));
    postService.addPost(new Post("Dunno", "https://www.google.com", userService.getUserById(2L)));
    postService.addPost(new Post("Bang", "https://www.google.com", userService.getUserById(2L)));
    postService
        .addPost(new Post("I am Groot", "https://www.google.com", userService.getUserById(3L)));
    postService
        .addPost(new Post("Yoda was here", "https://www.google.com", userService.getUserById(3L)));
    postService.addPost(new Post("Bloat", "https://www.google.com", userService.getUserById(4L)));
    postService.addPost(new Post("Nice", "https://www.google.com", userService.getUserById(4L)));
    postService.addPost(new Post("Please", "https://www.google.com", userService.getUserById(4L)));
    return "done";
  }
}
