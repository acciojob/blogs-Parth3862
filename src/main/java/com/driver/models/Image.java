package com.driver.models;

public class Image {
    private int imageId;
    private String dimensions;
    private Blog blog;

    // Constructors
    public Image() {
    }

    public Image(int imageId, String dimensions, Blog blog) {
        this.imageId = imageId;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    // Getters and Setters
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    // Method to delete an image
    // Method to delete an image
    public void deleteImage() {
        if (imageId != 0) {
            if (blog != null) {
                blog.removeImage(this);
            }

            imageId = 0;

        }
    }

    public void setDescription(String description) {
    }
}
