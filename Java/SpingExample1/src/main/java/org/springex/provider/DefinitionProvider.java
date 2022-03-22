package org.springex.provider;

import org.springex.model.Definition;

import java.util.List;

public interface DefinitionProvider {

    List<Definition> loadDefinitions(String term);

}
