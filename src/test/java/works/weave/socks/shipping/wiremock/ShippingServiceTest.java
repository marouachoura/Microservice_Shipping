package works.weave.socks.shipping.wiremock;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
//import works.weave.socks.AutoConfigureWireMock;

import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Instant;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
// @ContextConfiguration
public class ShippingServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;
    //Date dateNow = Date.now();
    
//LocalDateTime dateNow = LocalDateTime.now();
//ZonedDateTime dateNow = ZonedDateTime.now();
String dateNow = Instant.now().toString();


    @Test
    public void shouldReturnHealthyStatus() throws JSONException {
        String expectedJsonString = "{\"health\":[{\"service22\":\"shipping-rabbitmq\",\"status\":\"err\"},{\"service\":\"shipping\",\"status\":\"OK\"}]}";
        JSONObject expectedJson = new JSONObject(expectedJsonString);
        // stubFor(get(urlEqualTo("/health"))
        //         .willReturn(aResponse()
        //                 .withStatus(200)
        //                 .withHeader("Content-Type", "application/json") 
        //                 .withBody( expectedJson))
        //                         );


        stubFor(get(urlEqualTo("/shipping"))
        .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json") 
                // .withBody("GET ALL Shipping Resource."))
                //         );
                .withBody( expectedJsonString))
                        );

        // Make a request to the Shipping service to check the health endpoint
        // RestTemplate restTemplate = new RestTemplate();
       // ResponseEntity<String> response = restTemplate.getForEntity("http://127.0.0.1:8080/shipping", String.class);
       //ResponseEntity<JSONObject> response = restTemplate.getForEntity("http://127.0.0.1:8080/health", JSONObject.class);
       ResponseEntity<String> response = restTemplate.getForEntity("http://127.0.0.1:8080/health", String.class);
       System.out.println("============s"+response);
      // JSONObject response2 = (JSONObject) response.getBody();
       JSONObject response2 = new JSONObject(response.getBody());
        // ResponseEntity<String> response = restTemplate.getForEntity("http://
        JSONAssert.assertEquals(expectedJson, response2, JSONCompareMode.LENIENT);

        // assertThat(response.getStatusCodeValue(), is(200));
        // // assertThat(response.getBody(), containsString( "GET ALL Shipping Resource."
        // //        ));
        // assertThat(response.getBody(), containsString( expectedJson
        // ));
      


        // ResponseEntity<String> response = restTemplate.getForEntity("/health", String.class);
        // String actualJson = response.getBody();
        // assertThat(expectedJson, is(actualJson));

        // assertEquals(expectedJson, actualJson);







        // ResponseEntity<String> response = restTemplate.getForEntity("/health", String.class);
        // assertThat(response.getStatusCode(), is(HttpStatus.OK));
        // assertThat(response.getBody(), is("OK"));

        // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // assertThat(response.getBody()).isEqualTo("OK");
    }
}
//     @Value("${wiremock.server.port}")
//     private int wireMockPort;

//     @Autowired
//     private TestRestTemplate restTemplate;

//     @Test
//     public void shouldReturnHealthyStatus() {
//         stubFor(get(urlEqualTo("/health"))
//                 .willReturn(aResponse()
//                         .withStatus(200)
//                         .withBody("OK")));

//         ResponseEntity<String> response = restTemplate.getForEntity("/health", String.class);

//         assertThat(response.getStatusCodeValue()).isEqualTo(200);
//         assertThat(response.getBody()).isEqualTo("OK");
//     }

//     @After
//     public void tearDown() {
//         WireMock.reset();
//     }
// }


//     private static WireMockServer wireMockServer;

//     @BeforeClass
//     public static void setUp() {
//         wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8090));
//         wireMockServer.start();
//         WireMock.configureFor("localhost", 8090);
//     }

//     // @AfterClass
//     // public static void tearDown() {
//     //     wireMockServer.stop();
//     // }

//     @Test
//     public void shouldReturnHealthyStatus() {
//         stubFor(get(urlEqualTo("/health"))
//                 .willReturn(aResponse()
//                         .withStatus(200)
//                         .withBody("OK")));

//         // Make a request to the Shipping service to check the health endpoint
//         RestTemplate restTemplate = new RestTemplate();
//         ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/health", String.class);

//         assertThat(response.getStatusCodeValue()).isEqualTo(200);
//         assertThat(response.getBody()).isEqualTo("OK");
//     }
// }