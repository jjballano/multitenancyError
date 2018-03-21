package multitenancyerror

import grails.gorm.multitenancy.Tenants
import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class MyServiceSpec extends Specification {

    MyService myService

    void "aSaveOperationWithoutTenant should not use the default tenant id value"() {
        given:
        Date date = new Date()

        when:
        myService.aSaveOperationWithoutTenant(date)

        then:
        MyDomain.findByDate(date).tenantId == 55
    }

    void "aSaveOperationWithTenantId should not use the default tenant id value"() {
        given:
        Date date = new Date()

        when:
        myService.aSaveOperationWithTenantId(date)

        then:
        Tenants.withId(55l) {
            MyDomain.findByDate(date).tenantId == 55
        }
    }
}
