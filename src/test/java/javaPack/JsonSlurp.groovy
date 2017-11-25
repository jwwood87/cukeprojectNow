package javaPack

import cucumber.api.java.en.Given
import groovy.json.JsonSlurper
import com.eviware.soapui.support.GroovyUtils

/**
 * Created by a84558 on 1/13/17.
 */
class JsonSlurp {
    void hello () {
        println("Hello, World")
    }

    @Given("^Hello World")
    public void helloWorld(){

        System.out.println("Hello, World!");
    }

    @Given("^We parse")
    public void weParseJsonSlurper(){
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText('{ "myList": [4, 8, 15, 16, 23, 42] }')

        assert object instanceof Map
        assert object.myList instanceof List
        assert object.myList == [4, 8, 15, 16, 23, 42]
        assert jsonSlurper.parseText()
        System.out.println("We parsed");
    }
}
