package org.springex.model;

public class Definition {
    private String term;
    private String definition;

    public Definition(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "Definition{" +
                "term='" + term + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
