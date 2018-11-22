package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    private final ModelMapper modelMapper;

    private final ArticleBlockToDtoConverter articleBlockToDtoConverter;

    @Autowired
    ArticleMapper(ModelMapper modelMapper, ArticleBlockToDtoConverter articleBlockToDtoConverter) {
        this.modelMapper = modelMapper;
        this.articleBlockToDtoConverter = articleBlockToDtoConverter;
        this.modelMapper.addConverter(articleBlockToDtoConverter);
    }

    public ArticleDto map(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }
}
