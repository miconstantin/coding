package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;

public interface ArticleBlockVisitor {

    com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock visit(ImageBlock imageBlock);

    com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock visit(TextBlock textBlock);

    GalleryBlockDto visit(GalleryBlock galleryBlock);

    com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock visit(VideoBlock videoBlock);

    ArticleBlockDto visit(AudioBlock audioBlock);
}
