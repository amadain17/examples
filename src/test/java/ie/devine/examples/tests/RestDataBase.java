package ie.devine.examples.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;

public class RestDataBase {
    public static final String BASE_PATH = "post";
    static final String BASE_URL = "https://postman-echo.com";
    static final String CONTENT_TYPE = "Content-Type";
    static final String RESPONSE_DATA_FIELD = "data";
    static final String ID_PATH = RESPONSE_DATA_FIELD + ".id";
    static final String XML_NS = "ie.amach.testdata";
    static final String XML_LOCAL_PART = "demo";
    static final String XML_BASE = "ns2:" + XML_LOCAL_PART;
    static RequestSpecification requestSpecification;

    @BeforeAll
    public static void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .setBaseUri(BASE_URL)
                .build();
    }
}
