package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlockMapperVisitor;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

@Component
public class ArticleBlockToDtoConverter implements Converter<Set<ArticleBlock>, Collection<? extends ArticleBlockDto>> {

    @Autowired
    private ArticleBlockMapperVisitor articleBlockMapperVisitor;

    ArticleBlockToDtoConverter(ArticleBlockMapperVisitor articleBlockMapperVisitor) {
        this.articleBlockMapperVisitor = articleBlockMapperVisitor;
    }

    @Override
    public Collection<ArticleBlockDto> convert(MappingContext<Set<ArticleBlock>, Collection<? extends ArticleBlockDto>> context) {
        return context.getSource().stream()
                      .map(this::entityToDto)
                      .sorted(comparingInt(ArticleBlockDto::getSortIndex))
                      .collect(toList());
    }

    private ArticleBlockDto entityToDto(ArticleBlock block) {
        return block.asDto(articleBlockMapperVisitor);
    }
}
