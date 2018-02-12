package multitenancyerror

import grails.gorm.multitenancy.Tenants
import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class MyServiceSpec extends Specification {

    MyService myService

    void "aSaveOperation should not use the default tenant id value"() {
        given:
        Date date = new Date()

        when:
        myService.aSaveOperation(date)

        then:
        Tenants.withId(55l) {
            MyDomain.findByDate(date).tenantId == 55
        }
    }
}
