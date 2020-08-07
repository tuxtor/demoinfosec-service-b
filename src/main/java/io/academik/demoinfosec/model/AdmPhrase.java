package io.academik.demoinfosec.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "adm_phrase")
public class AdmPhrase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phrase_id")
    private Long phraseId;

    private String author;

    @Pattern(regexp = "[a-zA-Z ]*")
    private String phrase;

    public AdmPhrase() {
    }

    public Long getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(Long phraseId) {
        this.phraseId = phraseId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
