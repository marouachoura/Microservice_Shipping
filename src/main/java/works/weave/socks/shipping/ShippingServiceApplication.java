package works.weave.socks.shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
// import lombok.extern.log4j.Log4j2;


// @Data
// @NoArgsConstructor
// @AllArgsConstructor(staticName = "of")
// class TestingResponse {
//   String output;
// }
// @Data
// @NoArgsConstructor
// @AllArgsConstructor(staticName = "of")
// class TestingRequest {
//   String input;
// }
// // @Log4j2
// @Component
// @RequiredArgsConstructor
// class RestClient {

//   final RestTemplate restTemplate;

//   public TestingResponse post(TestingRequest request) {
//    // log.info("sending: {}", request);
//     String url = "http://127.0.0.1:8080/shipping";
//     TestingResponse response = restTemplate.postForEntity(url, request, TestingResponse.class)
//                                            .getBody();
//     //log.info("received: {}", response);
//     return response;
//   }
// }


@SpringBootApplication
public class ShippingServiceApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ShippingServiceApplication.class, args);
    }
}
