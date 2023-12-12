package com.Molndal.WebShopService.Controllers;

import com.Molndal.WebShopService.Models.Article;
import com.Molndal.WebShopService.Models.History;
import com.Molndal.WebShopService.Models.User;
import com.Molndal.WebShopService.Service.CartService;
import com.Molndal.WebShopService.Service.HistoryService;
import com.Molndal.WebShopService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/webshop/history")
public class HistoryController {

  @Autowired
   private HistoryService historyService;
  @Autowired
  private UserService userService;
  @Autowired
  private CartService cartService;

    @GetMapping("")
    private ResponseEntity<List<History>> getAllHistorik() {
        List<History> allHistory = historyService.getAllHistory();
        return ResponseEntity.ok(allHistory);
    }
    @GetMapping("/current")
    private ResponseEntity<List<History>> getCurrentUserHistory() {
        try {
            List<History> userHistory = historyService.getUserHistory();
            return ResponseEntity.ok(userHistory);
        } catch (Exception e) {
            // Log or handle the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/purchase")
    private ResponseEntity<String> purchaseCart() {
        User currentUser = userService.getCurrentUser();
        cartService.purchaseCart(currentUser);
        return ResponseEntity.ok("Purchase completed successfully.");
    }


}
