package auction.controller;

import auction.dto.AuctionItemDTO;
import auction.service.AuctionItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auctionItems")
@AllArgsConstructor
public class AuctionItemController {

    private final AuctionItemService auctionItemService;

    @GetMapping
    public ResponseEntity<List<AuctionItemDTO>> findAll() {
        return ResponseEntity.ok(auctionItemService.findAll());
    }

    @PostMapping
    public ResponseEntity<AuctionItemDTO> create(@RequestBody @Valid AuctionItemDTO auctionItemDTO) {
        return ResponseEntity.ok(auctionItemService.save(auctionItemDTO));
    }

    @GetMapping("/{jmbg}")
    public ResponseEntity<List<AuctionItemDTO>> getAuctionItemsByJmbg(@PathVariable int jmbg) {
        return ResponseEntity.ok(auctionItemService.getAuctionItemsByJbmg(jmbg));
    }

}
