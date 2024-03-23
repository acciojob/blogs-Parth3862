package com.driver.repositories;

import com.driver.models.Blog;
import com.driver.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByBlogId(int blogId);
}
