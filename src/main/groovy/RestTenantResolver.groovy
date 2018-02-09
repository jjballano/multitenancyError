import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException

class RestTenantResolver implements TenantResolver{

    @Override
    Serializable resolveTenantIdentifier() throws TenantNotFoundException {
        //This is just a mock
        Long tenantId = 12
        return (Serializable)tenantId
    }
}
