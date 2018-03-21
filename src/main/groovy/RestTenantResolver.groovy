import grails.gorm.DetachedCriteria
import multitenancyerror.MyDomain
import org.grails.datastore.mapping.multitenancy.AllTenantsResolver
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException

class RestTenantResolver implements AllTenantsResolver {

    @Override
    Serializable resolveTenantIdentifier() throws TenantNotFoundException {
        //This is just a mock
        Long tenantId = 12
        return (Serializable) tenantId
    }

    @Override
    Iterable<Serializable> resolveTenantIds() {
        new DetachedCriteria<MyDomain>()
                .distinct("tenantId")
                .list() as Iterable<Serializable>
    }
}
