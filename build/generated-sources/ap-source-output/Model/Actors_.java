package Model;

import Model.MoviesActors;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-04T16:56:43")
@StaticMetamodel(Actors.class)
public class Actors_ { 

    public static volatile SingularAttribute<Actors, String> realName;
    public static volatile CollectionAttribute<Actors, MoviesActors> moviesActorsCollection;
    public static volatile SingularAttribute<Actors, String> nationality;
    public static volatile SingularAttribute<Actors, String> name;
    public static volatile SingularAttribute<Actors, Integer> id;
    public static volatile SingularAttribute<Actors, String> biography;
    public static volatile SingularAttribute<Actors, Date> dateBirth;

}