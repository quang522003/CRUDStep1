package com.example.category_management_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.category_management_service.entity.Category;
import com.example.category_management_service.repository.CategoryRepository;
import com.example.category_management_service.service.CategoryService;

@SpringBootTest
class CategoryManagementServiceApplicationTests {

	private CategoryService categoryService;
    private CategoryRepository categoryRepositoryMock;

	@BeforeEach
    void setUp() {
        categoryRepositoryMock = mock(CategoryRepository.class);
        categoryService = new CategoryService(categoryRepositoryMock);
    }

	@Test
	void getCategoryById_ValidId_ReturnsCategory() {
		//cho mẫu
		int categoryId = 1;
        Category expectedCategory = new Category(categoryId);

		//cho repo làm
		when(categoryRepositoryMock.findById(categoryId)).thenReturn(java.util.Optional.of(expectedCategory));
		
		//cho service làm
		Category actualCategory = categoryService.getCategoryById(categoryId).get();

		//so sánh repo và service
		assertEquals(expectedCategory, actualCategory);
	}

}
