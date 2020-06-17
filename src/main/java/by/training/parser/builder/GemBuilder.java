package by.training.parser.builder;

import by.training.parser.entity.Gem;
import by.training.parser.exception.XMLParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class GemBuilder {

    private static final Logger LOGGER = LogManager.getLogger(GemBuilder.class);
    protected static final int FIRST_ITEM_INDEX = 0;
    protected List<Gem> gemList;

    public GemBuilder() {
        this.gemList = new ArrayList<>();
    }

    public abstract void buildGemList(InputStream sourceFile) throws XMLParserException;

    public List<Gem> getGemList() {
        return gemList;
    }

    protected void closeInputStream(InputStream stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            LOGGER.warn("Cannot close input stream");
        }
    }
}
