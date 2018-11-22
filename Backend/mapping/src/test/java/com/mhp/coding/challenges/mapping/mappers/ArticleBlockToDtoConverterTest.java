package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.exception.UnknownArticleBlockTypeException;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlockMapperVisitor;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.AudioBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.internal.MappingContextImpl;
import org.modelmapper.internal.MappingEngineImpl;
import org.modelmapper.spi.MappingContext;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ArticleBlockToDtoConverterTest {

    private ArticleBlockToDtoConverter articleBlockToDtoConverterUnderTest;

    @Before
    public void setUp() {
        articleBlockToDtoConverterUnderTest = new ArticleBlockToDtoConverter(new ArticleBlockMapperVisitor());
    }

    @Test
    public void testConvertWorksWithSomeRandomProperty() {
        // Setup
        Set<ArticleBlock> source = new ArticleRepository().findBy(1001L).getBlocks(); // no time for stubbing
        Class<Set<ArticleBlock>> sourceType = null;
        Collection<? extends ArticleBlockDto> destination = null;
        Class<Collection<? extends ArticleBlockDto>> destinationType = null;
        Type genericDestinationType = null;
        String typeMapName = null;
        MappingEngineImpl mappingEngine = null;
        final MappingContext<Set<ArticleBlock>, Collection<? extends ArticleBlockDto>> context
                = new MappingContextImpl<>(source, sourceType, destination, destinationType, genericDestinationType,
                typeMapName, mappingEngine
        );
        String someRandomProperty = "https://someurl.com/image/3";

        // Run the test
        final Collection<ArticleBlockDto> result = articleBlockToDtoConverterUnderTest.convert(context);

        // Verify the results
        assertEquals(someRandomProperty, ((GalleryBlockDto) new ArrayList<>(result).get(3)).getImages()
                                                                                           .get(1)
                                                                                           .getUrl());
    }

    @Test(expected = UnknownArticleBlockTypeException.class)
    public void testConvertUnknownArticleBlockType() {
        // Setup
        Set<ArticleBlock> source = new ArticleRepository().findBy(1001L).getBlocks(); // no time for stubbing
        source.add(new AudioBlock());
        Class<Set<ArticleBlock>> sourceType = null;
        Collection<? extends ArticleBlockDto> destination = null;
        Class<Collection<? extends ArticleBlockDto>> destinationType = null;
        Type genericDestinationType = null;
        String typeMapName = null;
        MappingEngineImpl mappingEngine = null;
        final MappingContext<Set<ArticleBlock>, Collection<? extends ArticleBlockDto>> context
                = new MappingContextImpl<>(source, sourceType, destination, destinationType, genericDestinationType,
                typeMapName, mappingEngine
        );

        // Run the test
        articleBlockToDtoConverterUnderTest.convert(context);

        // Verify the results
        assertFalse(true);
    }
}
