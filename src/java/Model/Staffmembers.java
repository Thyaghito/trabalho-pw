/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "staffmembers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staffmembers.findAll", query = "SELECT s FROM Staffmembers s"),
    @NamedQuery(name = "Staffmembers.findById", query = "SELECT s FROM Staffmembers s WHERE s.id = :id"),
    @NamedQuery(name = "Staffmembers.findByName", query = "SELECT s FROM Staffmembers s WHERE s.name = :name"),
    @NamedQuery(name = "Staffmembers.findByRole", query = "SELECT s FROM Staffmembers s WHERE s.role = :role")})
public class Staffmembers implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffmemberId")
    private Collection<MoviesStaffmembers> moviesStaffmembersCollection;

    public Staffmembers() {
    }

    public Staffmembers(Integer id) {
        this.id = id;
    }

    public Staffmembers(Integer id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<MoviesStaffmembers> getMoviesStaffmembersCollection() {
        return moviesStaffmembersCollection;
    }

    public void setMoviesStaffmembersCollection(Collection<MoviesStaffmembers> moviesStaffmembersCollection) {
        this.moviesStaffmembersCollection = moviesStaffmembersCollection;
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
        if (!(object instanceof Staffmembers)) {
            return false;
        }
        Staffmembers other = (Staffmembers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Staffmembers[ id=" + id + " ]";
    }
    
}
