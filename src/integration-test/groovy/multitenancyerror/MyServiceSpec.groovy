package multitenancyerror


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
class MyServiceSpec extends Specification {

    MyService myService

    void "aSaveOperation should not use the default tenant id value"() {
        given:
        Date date = new Date()

        when:
        myService.aSaveOperation(date)

        then:
        MyDomain.findByDate(date).tenantId == 55
    }
}
