package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.exception.UnknownArticleBlockTypeException;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ArticleBlockMapperVisitor implements ArticleBlockVisitor {

    @Override
    public com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock visit(ImageBlock imageBlock) {
        com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock blockDto = new com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock();
        blockDto.setSortIndex(imageBlock.getSortIndex());
        ImageDto imageDto = new ImageDto();
        imageDto.setId(imageBlock.getImage().getId());
        imageDto.setUrl(imageBlock.getImage().getUrl());
        imageDto.setImageSize(imageBlock.getImage().getImageSize());
        blockDto.setImage(imageDto);
        return blockDto;
    }

    @Override
    public com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock visit(TextBlock textBlock) {
        com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock blockDto = new com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock();
        blockDto.setSortIndex(textBlock.getSortIndex());
        blockDto.setText(textBlock.getText());
        return blockDto;
    }

    @Override
    public GalleryBlockDto visit(GalleryBlock galleryBlock) {
        GalleryBlockDto blockDto = new GalleryBlockDto();
        blockDto.setSortIndex(galleryBlock.getSortIndex());
        blockDto.setImages(imagesToImagesDto(galleryBlock));
        return blockDto;
    }

    private List<ImageDto> imagesToImagesDto(GalleryBlock block) {
        return block.getImages()
                    .stream()
                    .map(image -> {
                        ImageDto imageDto = new ImageDto();
                        imageDto.setId(image.getId());
                        imageDto.setImageSize(image.getImageSize());
                        imageDto.setUrl(image.getUrl());
                        return imageDto;
                    })
                    .collect(toList());
    }

    @Override
    public com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock visit(VideoBlock videoBlock) {
        com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock blockDto = new com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock();
        blockDto.setSortIndex(videoBlock.getSortIndex());
        blockDto.setType(videoBlock.getType());
        blockDto.setUrl(videoBlock.getUrl());
        return blockDto;
    }

    @Override
    public ArticleBlockDto visit(AudioBlock audioBlock) {
        throw new UnknownArticleBlockTypeException(audioBlock.getClass().getSimpleName());
    }
}
