package multitenancyerror

import grails.gorm.MultiTenant

class MyDomain implements MultiTenant<MyDomain> {

    Long userId
    Date date

    Long tenantId

    static constraints = {
    }

    def beforeInsert(){
        if (tenantId == null){
            //In case of @WithoutTenant in MyService
            tenantId = userId
        }
    }

    def beforeUpdate(){
        if (tenantId == null){
            //In case of @WithoutTenant in MyService
            tenantId = userId
        }
    }
}
