package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.exception.UnknownArticleBlockTypeException;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ArticleBlockMapperVisitorTest {

    private ArticleBlockMapperVisitor underTest;

    @Before
    public void setUp() {
        underTest = new ArticleBlockMapperVisitor();
    }

    @Test
    public void testImageMapping() {
        // Setup
        final ImageBlock imageBlock = prepareTestImageEntity();
        final String onlySomeRandomDtoProperty = "https://someurl.com/image/1001";

        // Run the test
        final com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock result = underTest.visit(imageBlock);

        // Verify the results
        // only simple check, full checks are omitted for now and tests could be parameterized
        assertEquals(onlySomeRandomDtoProperty, result.getImage().getUrl());
    }

    @Test
    public void testTextMapping() {
        // Setup
        final TextBlock textBlock = new TextBlock();
        final com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock expectedResult = new com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock();

        // Run the test
        final com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock result = underTest.visit(textBlock);

        // Verify the results
        // full checks are omitted for now
    }

    @Test
    public void testGalleryMapping() {
        // Setup
        final GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setImages(Collections.emptyList());
        final GalleryBlockDto expectedResult = null;

        // Run the test
        final GalleryBlockDto result = underTest.visit(galleryBlock);

        // Verify the results
        // full checks are omitted for now
    }

    @Test
    public void testVideoMapping() {
        // Setup
        final VideoBlock videoBlock = new VideoBlock();
        final com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock expectedResult = null;

        // Run the test
        final com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock result = underTest.visit(videoBlock);

        // Verify the results
        // full checks are omitted for now
    }

    @Test(expected = UnknownArticleBlockTypeException.class)
    public void testAudioMapping() {
        // Setup
        final AudioBlock audioBlock = new AudioBlock();

        // Run the test
        underTest.visit(audioBlock);
    }

    private ImageBlock prepareTestImageEntity() {
        final Image image = new Image();
        image.setId(1001L);
        image.setLastModified(new Date());
        image.setLastModifiedBy("Max Mustermann");
        image.setImageSize(ImageSize.LARGE);
        image.setUrl("https://someurl.com/image/" + 1001L);
        final ImageBlock imageBlock = new ImageBlock();
        imageBlock.setImage(image);
        imageBlock.setSortIndex(1);
        return imageBlock;
    }
}
