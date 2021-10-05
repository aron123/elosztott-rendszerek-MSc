package hu.me.iit.osztott;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final StorageClient storageClient;

    @GetMapping("/order")
    public String order() {
        int remainingProducts = storageClient.deliver();
        return "Order Confirmed! Remaining products: " + remainingProducts;
    }
}
