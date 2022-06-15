package com.zara.BackendTest.services;

import org.openapitools.model.ProductDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Set<ProductDetail> getProductDetails( final String productId ) {
        Set<ProductDetail> productDetailsSet =  new HashSet<>();
        ArrayList<ProductDetail> productDetails = new ArrayList<>();
        try {
            String url = String.format("http://localhost:3001/product/%s/similarids", productId);
            RestTemplate restTemplate = new RestTemplate();
            ArrayList result = restTemplate.getForObject( url, ArrayList.class );
            if ( result != null ) {
                for ( Object number : result ) {
                    String urlInfoId = String.format("http://localhost:3001/product/%s", number);
                    ProductDetail productDetail = restTemplate.getForObject( urlInfoId, ProductDetail.class );
                    productDetails.add( productDetail );
                    productDetailsSet.add( productDetail );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDetailsSet;
    }
}
