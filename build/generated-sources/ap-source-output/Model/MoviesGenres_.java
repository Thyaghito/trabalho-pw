package Model;

import Model.Genres;
import Model.Movies;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-04T16:56:43")
@StaticMetamodel(MoviesGenres.class)
public class MoviesGenres_ { 

    public static volatile SingularAttribute<MoviesGenres, Genres> genreId;
    public static volatile SingularAttribute<MoviesGenres, Movies> movieId;
    public static volatile SingularAttribute<MoviesGenres, Integer> id;

}