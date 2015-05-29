/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "actors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actors.findAll", query = "SELECT a FROM Actors a"),
    @NamedQuery(name = "Actors.findById", query = "SELECT a FROM Actors a WHERE a.id = :id"),
    @NamedQuery(name = "Actors.findByName", query = "SELECT a FROM Actors a WHERE a.name = :name"),
    @NamedQuery(name = "Actors.findByNationality", query = "SELECT a FROM Actors a WHERE a.nationality = :nationality"),
    @NamedQuery(name = "Actors.findByDateBirth", query = "SELECT a FROM Actors a WHERE a.dateBirth = :dateBirth"),
    @NamedQuery(name = "Actors.findByRealName", query = "SELECT a FROM Actors a WHERE a.realName = :realName")})
public class Actors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "name")
    private String name;
    @Size(max = 80)
    @Column(name = "nationality")
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "biography")
    private String biography;
    @Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    @Size(max = 120)
    @Column(name = "real_name")
    private String realName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actorId")
    private Collection<MoviesActors> moviesActorsCollection;

    public Actors() {
    }

    public Actors(Integer id) {
        this.id = id;
    }

    public Actors(Integer id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @XmlTransient
    public Collection<MoviesActors> getMoviesActorsCollection() {
        return moviesActorsCollection;
    }

    public void setMoviesActorsCollection(Collection<MoviesActors> moviesActorsCollection) {
        this.moviesActorsCollection = moviesActorsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actors)) {
            return false;
        }
        Actors other = (Actors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Actors[ id=" + id + " ]";
    }
    
}
