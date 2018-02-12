package multitenancyerror


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
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
        MyDomain.findByDate(date).tenantId == 55
    }
}
