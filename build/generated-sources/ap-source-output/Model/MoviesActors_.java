package Model;

import Model.Actors;
import Model.Movies;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-04T16:56:43")
@StaticMetamodel(MoviesActors.class)
public class MoviesActors_ { 

    public static volatile SingularAttribute<MoviesActors, Actors> actorId;
    public static volatile SingularAttribute<MoviesActors, Movies> movieId;
    public static volatile SingularAttribute<MoviesActors, Integer> id;

}