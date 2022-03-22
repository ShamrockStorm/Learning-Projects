package org.springex.service;

import org.springex.model.Definition;
import org.springex.provider.DefinitionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictionaryService {
    @Autowired
    @Qualifier("mockDefinitionProvider")
    private DefinitionProvider definitionProvider;

    public List<Definition> define(String term) {
        return this.definitionProvider.loadDefinitions(term);
    }

}
