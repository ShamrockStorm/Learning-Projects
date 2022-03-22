package org.springex.provider;

import org.springex.model.Definition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class MockDefinitionProvider implements DefinitionProvider {
    public List<Definition> loadDefinitions(String term) {
        return Stream.of(1,2,3)
                .map(index -> new Definition(term, "THis is a definition for " + term + index))
                .collect(Collectors.toList());
    }
}
