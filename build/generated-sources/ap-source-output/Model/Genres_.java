package Model;

import Model.MoviesGenres;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-04T16:56:43")
@StaticMetamodel(Genres.class)
public class Genres_ { 

    public static volatile SingularAttribute<Genres, Integer> id;
    public static volatile SingularAttribute<Genres, String> title;
    public static volatile CollectionAttribute<Genres, MoviesGenres> moviesGenresCollection;

}