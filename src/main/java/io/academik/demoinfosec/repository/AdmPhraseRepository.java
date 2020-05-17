package io.academik.demoinfosec.repository;

import io.academik.demoinfosec.model.AdmPhrase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class AdmPhraseRepository {

    @Inject
    private EntityManager em;

    public void create(AdmPhrase admPhrase){
        em.persist(admPhrase);
    }

    public AdmPhrase update(AdmPhrase admPhrase){
        return em.merge(admPhrase);
    }

    public AdmPhrase findById(Long phraseId){
        return em.find(AdmPhrase.class, phraseId);
    }

    public void delete(AdmPhrase admPhrase){
        em.remove(admPhrase);
    }

    public List<AdmPhrase> listAll(String author, String phrase){

        String query = "SELECT p FROM AdmPhrase p " +
                    "where p.author LIKE :author " +
                    "and p.phrase LIKE :phrase";

        return em.createQuery(query, AdmPhrase.class)
                .setParameter("author", author)
                .setParameter("phrase", phrase)
                .getResultList();
    }

}
