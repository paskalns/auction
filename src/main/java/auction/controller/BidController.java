package auction.controller;

import auction.dto.BidDTO;
import auction.service.BidService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bids")
@AllArgsConstructor
public class BidController {

    private final BidService bidService;

    @PostMapping
    public ResponseEntity<BidDTO> createBid(@RequestBody BidDTO bidDTO) {
        return ResponseEntity.ok(bidService.createBid(bidDTO));
    }
}
