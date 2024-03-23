package com.driver.services;

import com.driver.models.Image;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    ImageRepository imageRepository;

    public Image addImage(Integer blogId, String description, String dimensions){
        // Check if the blog exists
        if (blogRepository.existsById(blogId)) {
            // Create a new image object
            Image image = new Image();
            image.setDescription(description);
            image.setDimensions(dimensions);
            image.setBlog(blogRepository.findById(blogId).orElse(null));
            return imageRepository.save(image);
        } else {
            return null;
        }
    }

    public void deleteImage(Integer id){

        if (imageRepository.existsById(id)) {

            imageRepository.deleteById(id);
        }
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {

        List<Image> images = imageRepository.findByBlogId(id);

        int imagesThatFit = 0;
        for (Image image : images) {
            if (checkIfImageFitsScreen(image.getDimensions(), screenDimensions)) {
                imagesThatFit++;
            }
        }

        return imagesThatFit;
    }

    private boolean checkIfImageFitsScreen(String imageDimensions, String screenDimensions) {
        return true;
    }
}
