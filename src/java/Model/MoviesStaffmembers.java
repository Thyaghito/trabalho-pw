/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "movies_staffmembers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MoviesStaffmembers.findAll", query = "SELECT m FROM MoviesStaffmembers m"),
    @NamedQuery(name = "MoviesStaffmembers.findById", query = "SELECT m FROM MoviesStaffmembers m WHERE m.id = :id")})
public class MoviesStaffmembers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Movies movieId;
    @JoinColumn(name = "staffmember_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Staffmembers staffmemberId;

    public MoviesStaffmembers() {
    }

    public MoviesStaffmembers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movies getMovieId() {
        return movieId;
    }

    public void setMovieId(Movies movieId) {
        this.movieId = movieId;
    }

    public Staffmembers getStaffmemberId() {
        return staffmemberId;
    }

    public void setStaffmemberId(Staffmembers staffmemberId) {
        this.staffmemberId = staffmemberId;
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
        if (!(object instanceof MoviesStaffmembers)) {
            return false;
        }
        MoviesStaffmembers other = (MoviesStaffmembers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.MoviesStaffmembers[ id=" + id + " ]";
    }
    
}
