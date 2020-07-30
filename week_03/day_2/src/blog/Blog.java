package blog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Blog {

  public static void main(String[] args) {
    List<BlogPost> blogposts = initializeBlog();

    BlogPost loremIpsum = new BlogPost("John Doe", "Lorem Ipsum", "Lorem ipsum dolor sit amet.", "2000.05.04.");

    blogposts.add(loremIpsum);
    blogposts.remove(0);
    blogposts.set(1, new BlogPost("Béla", "örrélisztsz", "demér?!", "2020.07.29."));

    for (int i = 0; i < blogposts.size(); i++) {
      System.out.println(blogposts.get(i).authorName + " " + blogposts.get(i).title + " " + blogposts.get(i).publicationDate);
    }
  }
  public static List<BlogPost> initializeBlog() {
    List<BlogPost> blog = new ArrayList<>();
    blog.add(new BlogPost("Tim Urban", "Wait but why", "A popular long-form, stick-figure-illustrated blog about almost everything.", "2010.10.10."));
    blog.add(new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.", "2017.03.28."));
    return blog;
  }
}
