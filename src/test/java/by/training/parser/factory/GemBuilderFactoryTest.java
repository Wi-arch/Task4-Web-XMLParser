package by.training.parser.factory;

import by.training.parser.builder.DOMGemBuilder;
import by.training.parser.builder.SAXGemBuilder;
import by.training.parser.builder.StAXGemBuilder;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GemBuilderFactoryTest {

    private GemBuilderFactory gemBuilderFactory = GemBuilderFactory.getInstance();

    @Test
    public void testGetInstance() {
        Object instance = GemBuilderFactory.getInstance();
        assertNotNull(instance);
        assertTrue(instance instanceof GemBuilderFactory);
    }

    @Test
    public void testGetDomGemBuilder() {
        Object instance = gemBuilderFactory.getDomGemBuilder();
        assertNotNull(instance);
        assertTrue(instance instanceof DOMGemBuilder);
    }

    @Test
    public void testGetSaxGemBuilder() {
        Object instance = gemBuilderFactory.getSaxGemBuilder();
        assertNotNull(instance);
        assertTrue(instance instanceof SAXGemBuilder);
    }

    @Test
    public void testGetStAXGemBuilder() {
        Object instance = gemBuilderFactory.getStAXGemBuilder();
        assertNotNull(instance);
        assertTrue(instance instanceof StAXGemBuilder);
    }
}