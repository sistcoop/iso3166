package org.sistcoop.iso3166.models.jpa.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

@Cacheable
@Entity
@Table(name = "COUNTRY_CODE")
@NamedQueries({ @NamedQuery(name = "CountryCodeEntity.findAll", query = "SELECT c FROM CountryCodeEntity c"),
        @NamedQuery(name = "CountryCodeEntity.findByAlpha2Code", query = "SELECT c FROM CountryCodeEntity c WHERE c.alpha2Code = :alpha2Code"),
        @NamedQuery(name = "CountryCodeEntity.findByAlpha3Code", query = "SELECT c FROM CountryCodeEntity c WHERE c.alpha3Code = :alpha3Code"),
        @NamedQuery(name = "CountryCodeEntity.findByNumericCode", query = "SELECT c FROM CountryCodeEntity c WHERE c.numericCode = :numericCode"),
        @NamedQuery(name = "CountryCodeEntity.findByFilterText", query = "SELECT c FROM CountryCodeEntity c WHERE c.alpha2Code LIKE :filterText OR c.alpha3Code LIKE :filterText OR c.numericCode LIKE :filterText OR c.shortNameEn LIKE :filterText OR c.shortNameUppercaseEn LIKE :filterText OR c.fullNameEn LIKE :filterText"),
        @NamedQuery(name = "CountryCodeEntity.count", query = "select count(u) from CountryCodeEntity u") })
public class CountryCodeEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String alpha2Code;
    private String alpha3Code;
    private String numericCode;
    private boolean independent;
    private String status;
    private String shortNameEn;
    private String shortNameUppercaseEn;
    private String fullNameEn;

    public CountryCodeEntity() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 2)
    @Column(name = "ALPHA2_CODE")
    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    @Column(name = "ALPHA3_CODE")
    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    @Column(name = "NUMERIC_CODE")
    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "INDEPENDENT")
    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }

    @Size(min = 1, max = 200)
    @Column(name = "STATUS")
    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    @Column(name = "SHORT_NAME_EN")
    public String getShortNameEn() {
        return shortNameEn;
    }

    public void setShortNameEn(String shortNameEn) {
        this.shortNameEn = shortNameEn;
    }

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    @Column(name = "SHORT_NAME_UPPERCASE_EN")
    public String getShortNameUppercaseEn() {
        return shortNameUppercaseEn;
    }

    public void setShortNameUppercaseEn(String shortNameUppercaseEn) {
        this.shortNameUppercaseEn = shortNameUppercaseEn;
    }

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    @Column(name = "FULL_NAME_EN")
    public String getFullNameEn() {
        return fullNameEn;
    }

    public void setFullNameEn(String fullNameEn) {
        this.fullNameEn = fullNameEn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CountryCodeEntity other = (CountryCodeEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
