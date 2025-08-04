package io.github.artsiomdavidovich.meinbon.service;

import io.github.artsiomdavidovich.meinbon.domain.entity.Category;
import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ObjectNotFoundException;
import io.github.artsiomdavidovich.meinbon.repository.CategoryRepository;
import io.github.artsiomdavidovich.meinbon.service.interfaces.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryByTitle(String title) {
        return categoryRepository.findByTitle(title)
                .orElseThrow(
                        () -> new ObjectNotFoundException(String.format("Category with title: %s not found", title))
                );
    }
}
