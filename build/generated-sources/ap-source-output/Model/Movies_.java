package Model;

import Model.MoviesActors;
import Model.MoviesGenres;
import Model.MoviesStaffmembers;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-04T16:56:43")
@StaticMetamodel(Movies.class)
public class Movies_ { 

    public static volatile CollectionAttribute<Movies, MoviesActors> moviesActorsCollection;
    public static volatile SingularAttribute<Movies, Integer> year;
    public static volatile SingularAttribute<Movies, String> originalTitle;
    public static volatile CollectionAttribute<Movies, MoviesStaffmembers> moviesStaffmembersCollection;
    public static volatile SingularAttribute<Movies, Integer> id;
    public static volatile SingularAttribute<Movies, String> countryOrigin;
    public static volatile SingularAttribute<Movies, String> studioDistributor;
    public static volatile SingularAttribute<Movies, String> title;
    public static volatile CollectionAttribute<Movies, MoviesGenres> moviesGenresCollection;

}