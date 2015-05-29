package Model;

import Model.MoviesStaffmembers;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-04T16:56:43")
@StaticMetamodel(Staffmembers.class)
public class Staffmembers_ { 

    public static volatile SingularAttribute<Staffmembers, String> role;
    public static volatile CollectionAttribute<Staffmembers, MoviesStaffmembers> moviesStaffmembersCollection;
    public static volatile SingularAttribute<Staffmembers, String> name;
    public static volatile SingularAttribute<Staffmembers, Integer> id;

}