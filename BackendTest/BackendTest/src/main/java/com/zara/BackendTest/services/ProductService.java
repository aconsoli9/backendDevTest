package com.zara.BackendTest.services;

import org.openapitools.model.ProductDetail;
import java.util.Set;

public interface ProductService {

    Set<ProductDetail> getProductDetails(final String productId);

}
