// package works.weave.socks;

// import static org.junit.Assert.assertThat;

// import org.junit.Test;
// //import static org.junit.Assert.*;
// import static org.hamcrest.CoreMatchers.*;

// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.SpringBootConfiguration;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.web.client.RestTemplate;
// import com.github.tomakehurst.wiremock.WireMockServer;
// import com.google.common.annotations.Beta;

// //import com.github.tomakehurst.wiremock.stubbing.StubMapping;
// import static com.github.tomakehurst.wiremock.client.WireMock.*;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @AutoConfigureWireMock(port = 0)
// public class WiremockForTests {
    
//     @Autowired
//     private WireMockServer wireMockServer;
    
//     /**
//      * 
//      */
//     @Test
//     public void test() {
//         // given
//        String url = "http://shipping";
//         wireMockServer.stubFor(get(urlEqualTo("/health"))
//                 .willReturn(aResponse()
//                         .withStatus(200)
//                         .withHeader("Content-Type", "application/json")
//                         .withBody("{\"status\":\"ok\"}")));
//        // wireMockServer.start();
        
//         // when
    
//         RestTemplate restTemplate = new RestTemplate();
       
//         ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//         assertThat(response.getStatusCode(), is(HttpStatus.OK));
        
//         // // then
//         // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//         // assertThat(response.getBody()).isEqualTo("{\"status\":\"ok\"}");
//     }
// }

