package multitenancyerror

import grails.gorm.MultiTenant

class MyDomain implements MultiTenant<MyDomain> {

    Long userId
    Date date

    Long tenantId

    static constraints = {
    }

    def beforeInsert(){
        tenantId = userId
    }

    def beforeUpdate(){
        tenantId = userId
    }
}
