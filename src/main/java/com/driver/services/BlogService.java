package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageRepository imageRepository;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // Handle user not found error
            return null;
        }
        Date currentDate = new Date();
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(currentDate);
        blog.setUser(user);
        return blogRepository.save(blog);
    }

    public void deleteBlog(int blogId) {
        Blog blog = blogRepository.findById(blogId).orElse(null);
        if (blog != null) {
            // Delete corresponding images
            List<Image> images = imageRepository.findByBlogId(blogId);
            for (Image image : images) {
                imageRepository.deleteById(image.getImageId());
            }
            // Then delete the blog itself
            blogRepository.deleteById(blogId);
        }
    }
}
