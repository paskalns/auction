package auction.controller;

import auction.AbstractClassIntegrationTests;
import auction.dto.AuctionItemDTO;

import auction.dto.BidDTO;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BidControllerIntegrationTest extends AbstractClassIntegrationTests {

    @Test
    public void createBid() {
        int sizeBefore = bidService.findAll().size();

        ResponseEntity<AuctionItemDTO> responseEntity = restTemplate.withBasicAuth("bpaskali", "password")
                .postForEntity("/auctionItems", new AuctionItemDTO
                        (null, "name2", new BigDecimal("100"), new BigDecimal("150"), false), AuctionItemDTO.class);

        ResponseEntity<BidDTO> responseEntity1 = restTemplate
                .postForEntity("/bids", new BidDTO
                        (responseEntity.getBody().getId(), new BigDecimal("111"), "name", "lastName", 123), BidDTO.class);
        assertEquals(HttpStatus.OK, responseEntity1.getStatusCode());
        assertEquals(sizeBefore + 1, bidService.findAll().size());
    }

}

