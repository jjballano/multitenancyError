package multitenancyerror

import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

@Service(MyDomain)
@CurrentTenant
abstract class MyRepositoryService {

    abstract MyDomain save(MyDomain myDomain)
}
