package com.example.webStore.controllers;

import com.example.webStore.models.PaymentInfo;
import com.example.webStore.services.BasketService;
import com.example.webStore.services.PaymentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final BasketService basketService;

    @PostMapping
    public ResponseEntity<String> payment(@RequestBody PaymentInfoBody paymentInfoBody)
    {
        PaymentInfo paymentInfo = PaymentInfo.builder()
                .cardNumber(paymentInfoBody.getCardNumber())
                .cvv(paymentInfoBody.getCvv())
                .adjectiveTerm(paymentInfoBody.getAdjectiveTerm())
                .name(paymentInfoBody.getName())
                .lastName(paymentInfoBody.getLastName())
                .address(paymentInfoBody.getAddress())
                .pin(paymentInfoBody.getPin()).build();
        //провыряти чи користувач зареэстрований, ы в цьому випадку викликати метод
        //makeTransaction з параметрами аккаунта
        paymentService.makeTransaction(paymentInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

@Getter
@Setter
class PaymentInfoBody {
    private String cardNumber;
    private int cvv;
    private Date adjectiveTerm;
    private String name;
    private String lastName;
    private String address;
    private int pin;
}