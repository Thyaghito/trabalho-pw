/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "movies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findById", query = "SELECT m FROM Movies m WHERE m.id = :id"),
    @NamedQuery(name = "Movies.findByTitle", query = "SELECT m FROM Movies m WHERE m.title = :title"),
    @NamedQuery(name = "Movies.findByOriginalTitle", query = "SELECT m FROM Movies m WHERE m.originalTitle = :originalTitle"),
    @NamedQuery(name = "Movies.findByYear", query = "SELECT m FROM Movies m WHERE m.year = :year"),
    @NamedQuery(name = "Movies.findByCountryOrigin", query = "SELECT m FROM Movies m WHERE m.countryOrigin = :countryOrigin"),
    @NamedQuery(name = "Movies.findByStudioDistributor", query = "SELECT m FROM Movies m WHERE m.studioDistributor = :studioDistributor")})
public class Movies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "original_title")
    private String originalTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;
    @Size(max = 80)
    @Column(name = "country_origin")
    private String countryOrigin;
    @Size(max = 80)
    @Column(name = "studio_distributor")
    private String studioDistributor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieId")
    private Collection<MoviesActors> moviesActorsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieId")
    private Collection<MoviesGenres> moviesGenresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieId")
    private Collection<MoviesStaffmembers> moviesStaffmembersCollection;

    public Movies() {
    }

    public Movies(Integer id) {
        this.id = id;
    }

    public Movies(Integer id, String title, String originalTitle, int year) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getStudioDistributor() {
        return studioDistributor;
    }

    public void setStudioDistributor(String studioDistributor) {
        this.studioDistributor = studioDistributor;
    }

    @XmlTransient
    public Collection<MoviesActors> getMoviesActorsCollection() {
        return moviesActorsCollection;
    }

    public void setMoviesActorsCollection(Collection<MoviesActors> moviesActorsCollection) {
        this.moviesActorsCollection = moviesActorsCollection;
    }

    @XmlTransient
    public Collection<MoviesGenres> getMoviesGenresCollection() {
        return moviesGenresCollection;
    }

    public void setMoviesGenresCollection(Collection<MoviesGenres> moviesGenresCollection) {
        this.moviesGenresCollection = moviesGenresCollection;
    }

    @XmlTransient
    public Collection<MoviesStaffmembers> getMoviesStaffmembersCollection() {
        return moviesStaffmembersCollection;
    }

    public void setMoviesStaffmembersCollection(Collection<MoviesStaffmembers> moviesStaffmembersCollection) {
        this.moviesStaffmembersCollection = moviesStaffmembersCollection;
    }
    
    @XmlTransient
    public List getActors() { 
        if(moviesActorsCollection == null){
            moviesActorsCollection = new ArrayList<MoviesActors>();
            return new ArrayList();
        }else{
            List items = new ArrayList(moviesActorsCollection.size());
            for(MoviesActors value : moviesActorsCollection){
                items.add(value.getActorId().getId().toString());
            }
            return items;
        }        
    }
    public List getArrayActors() { 
        if(moviesActorsCollection == null){
            moviesActorsCollection = new ArrayList<MoviesActors>();
            return new ArrayList();
        }else{
            List items = new ArrayList(moviesActorsCollection.size());  
            for(MoviesActors value : moviesActorsCollection){
                items.add(value.getActorId());
            }
            return items;
        }        
    }
    public void setActors(List<String> actors) {  
        for (String idActor : actors) {           
            MoviesActors relation = new MoviesActors();
            relation.setMovieId(this);
            relation.setActorId(new Actors(Integer.parseInt(idActor)));
            this.moviesActorsCollection.add(relation);
        }  
    } 

    @XmlTransient
    public List getStaffmembers() { 
        if(moviesStaffmembersCollection == null){
            moviesStaffmembersCollection = new ArrayList<MoviesStaffmembers>();
            return new ArrayList();
        }else{
            List items = new ArrayList(moviesStaffmembersCollection.size());
            for(MoviesStaffmembers value : moviesStaffmembersCollection){
                items.add(value.getStaffmemberId().getId().toString());
            }
            return items;
        }
    }
    public List getArrayStaffmembers() { 
        if(moviesStaffmembersCollection == null){
            moviesStaffmembersCollection = new ArrayList<MoviesStaffmembers>();
            return new ArrayList();
        }else{
            List items = new ArrayList(moviesStaffmembersCollection.size());
            for(MoviesStaffmembers value : moviesStaffmembersCollection){
                items.add(value.getStaffmemberId());
            }
            return items;
        }
    }
    public void setStaffmembers(List<String> staffmembers) {  
        for (String idStaffmember : staffmembers) {           
            MoviesStaffmembers relation = new MoviesStaffmembers();
            relation.setMovieId(this);
            relation.setStaffmemberId(new Staffmembers(Integer.parseInt(idStaffmember)));
            this.moviesStaffmembersCollection.add(relation);
        }  
    }  

    @XmlTransient
    public List getGenres() { 
         if(moviesGenresCollection == null){
            moviesGenresCollection = new ArrayList<MoviesGenres>();
            return new ArrayList();
        }else{
            List items = new ArrayList(moviesGenresCollection.size());
            for(MoviesGenres value : moviesGenresCollection){
                items.add(value.getGenreId().getId().toString());
            }
            return items;
        }
    }
    public List getArrayGenres() { 
         if(moviesGenresCollection == null){
            moviesGenresCollection = new ArrayList<MoviesGenres>();
            return new ArrayList();
        }else{
            List items = new ArrayList(moviesGenresCollection.size());
            for(MoviesGenres value : moviesGenresCollection){
                items.add(value.getGenreId());
            }
            return items;
        }
    }
    public void setGenres(List<String> genres) {  
        for (String idGenre : genres) {           
            MoviesGenres relation = new MoviesGenres();
            relation.setMovieId(this);
            relation.setGenreId(new Genres(Integer.parseInt(idGenre)));
            this.moviesGenresCollection.add(relation);
        }  
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
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Movies[ id=" + id + " ]";
    }
    
}
