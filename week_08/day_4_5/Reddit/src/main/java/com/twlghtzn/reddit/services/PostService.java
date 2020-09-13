package com.twlghtzn.reddit.services;

import com.twlghtzn.reddit.models.Post;
import com.twlghtzn.reddit.models.User;
import com.twlghtzn.reddit.repositories.PostRepository;
import com.twlghtzn.reddit.repositories.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PostService {
  private final PostRepository postRepository;
  private final UserRepository userRepository;
  private List<Pageable> pages;
  private Integer postCountPerPage;
  private HashMap<String, Integer> postCountsPerPage;

  public PostService(PostRepository postRepository,
                     UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
    pages = new ArrayList<>();
    postCountsPerPage = new HashMap<>();
    postCountPerPage = 10;
    addAPage();
    fillPostCountsPerPage();
  }

  public HashMap<String, Integer> getPostCountsPerPage() {
    return postCountsPerPage;
  }

  public void addAPage() {
    pages.add(PageRequest.of(pages.size(), getPostCountPerPage(), Sort.by(
        Sort.Order.desc("score"),
        Sort.Order.desc("id"))));
  }

  public void fillPostCountsPerPage() {
    postCountsPerPage.put("3", 3);
    postCountsPerPage.put("5", 5);
    postCountsPerPage.put("10", 10);
  }

  public int getPostCountPerPage() {
    return postCountPerPage;
  }

  public void reloadPages(int count) {
    int postCount = getPostsCount();
    pages.clear();
    if (postCount / count >= 1) {
      for (int i = 0; i < (postCount / count); i++) {
        addAPage();
      }
      if (postCount % count > 0) {
        addAPage();
      }
    } else {
      addAPage();
    }
  }

  public void setPostCountPerPage(int count) {
    postCountPerPage = count;
    reloadPages(count);
  }

  public List<Pageable> getPages() {
    return pages;
  }

  public int getPostsCount() {
    return (int) postRepository.count();
  }

  public void setPageCount() {
   if (getPostsCount() % getPostCountPerPage() == 0) {
     addAPage();
   }
  }

  public Pageable getPageSetup(int page) {
    return pages.get(page);
  }

  public List<Post> getPostsPerPage(int page) {
    return postRepository.findAll(getPageSetup(page));
  }

  public void addPost(Post post) {
    postRepository.save(post);
    reloadPages(getPostCountPerPage());
  }

  public Post getPostById(Long id) {
    return postRepository.findById(id).orElse(null);
  }

  public void voteUp(Long postId, Long userId) {
    if (!getUpVoters(postId).contains(getUser(userId))) {
      votePost(postId, 1);
      getUpVoters(postId).add(getUser(userId));
      postRepository.save(getPostById(postId));
    }
  }

  public void voteDown(Long postId, Long userId) {
    if (!getDownVoters(postId).contains(getUser(userId))) {
      votePost(postId, -1);
      getDownVoters(postId).add(getUser(userId));
      postRepository.save(getPostById(postId));
    }
  }

  public List<User> getDownVoters(Long postId) {
    return getPostById(postId).getUsersVotedDown();
  }

  public List<User> getUpVoters(Long postId) {
    return getPostById(postId).getUsersVotedUp();
  }

  public User getUser(Long userId) {
    return userRepository.findById(userId).orElse(null);
  }

  public void votePost(Long postId, int vote) {
    getPostById(postId).setScore(getPostById(postId).getScore() + vote);
  }
}
