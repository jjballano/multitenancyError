package multitenancyerror

import grails.gorm.multitenancy.Tenants
import grails.gorm.multitenancy.WithoutTenant
import grails.gorm.transactions.Transactional

@Transactional
class MyService {

    MyRepositoryService myRepositoryService

    @WithoutTenant
    def aSaveOperationWithoutTenant(Date date) {
        MyDomain myDomain = new MyDomain(date: date, userId: 55)
        Tenants.withId(myDomain.userId) {
            myRepositoryService.save(myDomain)
        }
    }


    def aSaveOperationWithTenantId(Date date) {
        MyDomain.withTenant(55){
            MyDomain myDomain = new MyDomain(date: date, userId: 60)
            myRepositoryService.save(myDomain)
        }
    }
}
