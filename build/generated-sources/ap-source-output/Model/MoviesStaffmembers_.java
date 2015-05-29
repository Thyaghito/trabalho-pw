package Model;

import Model.Movies;
import Model.Staffmembers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-04T16:56:43")
@StaticMetamodel(MoviesStaffmembers.class)
public class MoviesStaffmembers_ { 

    public static volatile SingularAttribute<MoviesStaffmembers, Staffmembers> staffmemberId;
    public static volatile SingularAttribute<MoviesStaffmembers, Movies> movieId;
    public static volatile SingularAttribute<MoviesStaffmembers, Integer> id;

}