package auction.controller;

import auction.dto.AuctionItemDTO;

import auction.dto.BidDTO;
import auction.service.BidService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BidControllerIntegrationTest {

    private TestRestTemplate restTemplate;
    private BidService bidService;

    @Test
    public void createBid() {
        int sizeBefore = bidService.findAll().size();

        ResponseEntity<AuctionItemDTO> responseEntity = restTemplate.withBasicAuth("bpaskali", "password")
                .postForEntity("/auctionItems", new AuctionItemDTO
                        (null, "name", 100, 150, false), AuctionItemDTO.class);

        ResponseEntity<BidDTO> responseEntity1 = restTemplate
                .postForEntity("/bids", new BidDTO
                        (1L, 111, "name", "lastName", 456), BidDTO.class);
        assertEquals(HttpStatus.OK, responseEntity1.getStatusCode());
        assertEquals(sizeBefore + 1, bidService.findAll().size());
    }

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @Autowired
    public void setRestTemplate(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
