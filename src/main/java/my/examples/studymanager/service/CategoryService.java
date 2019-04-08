package my.examples.studymanager.service;

import my.examples.studymanager.domain.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public Category getCategory(Long categoryId);
}
