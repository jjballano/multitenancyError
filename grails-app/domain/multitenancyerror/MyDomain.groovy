package multitenancyerror

import grails.gorm.MultiTenant

class MyDomain implements MultiTenant<MyDomain> {

    Long tenantId
    Long userId
    Date date
}
