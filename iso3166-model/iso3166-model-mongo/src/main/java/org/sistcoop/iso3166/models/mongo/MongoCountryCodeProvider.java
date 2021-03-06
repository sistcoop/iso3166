package org.sistcoop.iso3166.models.mongo;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.sistcoop.iso3166.models.CountryCodeModel;
import org.sistcoop.iso3166.models.CountryCodeProvider;
import org.sistcoop.iso3166.models.mongo.entities.CountryCodeEntity;
import org.sistcoop.iso3166.models.search.SearchCriteriaModel;
import org.sistcoop.iso3166.models.search.SearchResultsModel;

@Named
@Stateless
@Local(CountryCodeProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MongoCountryCodeProvider implements CountryCodeProvider {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public CountryCodeModel create(String alpha2Code, String alpha3Code, String numericCode,
            boolean independent, String status, String shortNameEn, String shortNameUppercaseEn,
            String fullNameEn) {
        CountryCodeEntity entity = new CountryCodeEntity();
        entity.setAlpha2Code(alpha2Code);
        entity.setAlpha3Code(alpha3Code);
        entity.setNumericCode(numericCode);
        entity.setIndependent(independent);
        entity.setStatus(status);
        entity.setShortNameEn(shortNameEn);
        entity.setShortNameUppercaseEn(shortNameUppercaseEn);
        entity.setFullNameEn(fullNameEn);
        em.persist(entity);
        return new CountryCodeAdapter(em, entity);
    }

    @Override
    public boolean remove(CountryCodeModel countryCodeModel) {
        CountryCodeEntity countryCodeEntity = em.find(CountryCodeEntity.class, countryCodeModel.getId());
        if (countryCodeEntity == null)
            return false;
        em.remove(countryCodeEntity);
        return true;
    }

    @Override
    public CountryCodeModel findByAlpha2Code(String alpha2Code) {
        TypedQuery<CountryCodeEntity> query = em.createNamedQuery(CountryCodeEntity.findByAlpha2Code,
                CountryCodeEntity.class);
        query.setParameter("alpha2Code", alpha2Code);
        List<CountryCodeEntity> results = query.getResultList();
        if (results.isEmpty())
            return null;
        return new CountryCodeAdapter(em, results.get(0));
    }

    @Override
    public CountryCodeModel findByAlpha3Code(String alpha3Code) {
        TypedQuery<CountryCodeEntity> query = em.createNamedQuery(CountryCodeEntity.findByAlpha3Code,
                CountryCodeEntity.class);
        query.setParameter("alpha3Code", alpha3Code);
        List<CountryCodeEntity> results = query.getResultList();
        if (results.isEmpty())
            return null;
        return new CountryCodeAdapter(em, results.get(0));
    }

    @Override
    public CountryCodeModel findByNumericCode(String numericCode) {
        TypedQuery<CountryCodeEntity> query = em.createNamedQuery(CountryCodeEntity.findByNumericCode,
                CountryCodeEntity.class);
        query.setParameter("numericCode", numericCode);
        List<CountryCodeEntity> results = query.getResultList();
        if (results.isEmpty())
            return null;
        return new CountryCodeAdapter(em, results.get(0));
    }

    @Override
    public SearchResultsModel<CountryCodeModel> search(SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<CountryCodeModel> search(SearchCriteriaModel criteria, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CountryCodeModel findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CountryCodeModel> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
