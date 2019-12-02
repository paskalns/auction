package auction.controller;

import auction.AbstractClassIntegrationTests;
import auction.dto.AuctionItemDTO;

import auction.dto.BidDTO;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BidControllerIntegrationTest extends AbstractClassIntegrationTests {

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

}

