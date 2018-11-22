package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ArticleMapperTest {

    @Mock
    private Article mockArticle;

    @Mock
    private ModelMapper mockModelMapper;

    @Mock
    private ArticleBlockToDtoConverter mockArticleBlockToDtoConverter;

    private ArticleMapper articleMapperUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        articleMapperUnderTest = new ArticleMapper(mockModelMapper, mockArticleBlockToDtoConverter);
    }

    @Test
    public void testMap() {
        // Setup
        final Article article = mockArticle;

        // Run the test
        articleMapperUnderTest.map(article);

        // Verify the results
        verify(mockModelMapper).map(article, ArticleDto.class);
    }
}
