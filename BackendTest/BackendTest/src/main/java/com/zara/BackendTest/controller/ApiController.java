package com.zara.BackendTest.controller;

import com.zara.BackendTest.services.ProductService;
import lombok.AllArgsConstructor;
import org.openapitools.api.ProductApi;
import org.openapitools.model.ProductDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
public class ApiController implements ProductApi {

    private final ProductService productService;

    @GetMapping( value = "/product/{productId}/similar",
            produces = { "application/json" } )
    public ResponseEntity<Set<ProductDetail>> getProductSimilar(@PathVariable( "productId" ) final String productId ) {
        return new ResponseEntity( productService.getProductDetails( productId ), HttpStatus.OK );
    }
}
