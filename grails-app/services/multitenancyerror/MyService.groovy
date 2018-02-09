package multitenancyerror

import grails.gorm.multitenancy.WithoutTenant
import grails.gorm.transactions.Transactional

@Transactional
class MyService {

    MyRepositoryService myRepositoryService

    @WithoutTenant
    def aSaveOperation(Date date) {
        MyDomain myDomain = new MyDomain(date: date, userId: 55)
        myRepositoryService.save(myDomain)
    }
}
