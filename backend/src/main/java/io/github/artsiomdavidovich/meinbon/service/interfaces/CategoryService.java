package io.github.artsiomdavidovich.meinbon.service.interfaces;

import io.github.artsiomdavidovich.meinbon.domain.entity.Category;

public interface CategoryService {

    Category getCategoryByTitle(String title);

}
