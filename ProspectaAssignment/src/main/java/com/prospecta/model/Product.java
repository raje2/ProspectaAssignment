package com.prospecta.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Product {
	
	private Long id;

	@NotBlank(message = "Title is mandatory")
    private String title;

	@NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be greater than 0")
    private double price;

	@NotBlank(message = "Description is mandatory")
    private String description;

	@NotBlank(message = "Category is mandatory")
    private String category;

	@NotBlank(message = "Image URL is mandatory")
    private String image;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
