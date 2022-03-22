package org.springex.provider;

import org.springex.model.Definition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultDefinitionProvider implements DefinitionProvider{

    public List<Definition> loadDefinitions(String term) {
        throw new RuntimeException("Not Implemented");
    }
}
