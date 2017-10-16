package dasniko.soteria;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
//@DataBaseIdentityStoreDefinition(
//    dataSourceLookup = "java:jboss/datasources/ExampleDS",
//    callerQuery = "select password from account where username = ? and active = true",
//    groupsQuery = "select roles from account_roles r, account a where a.id = r.account_id and a.username = ?"
//)
@ApplicationPath("/soteria")
public class SoteriaApplication extends Application {
}
