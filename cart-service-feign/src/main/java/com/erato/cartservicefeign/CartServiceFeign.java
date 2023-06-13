package com.erato.cartservicefeign;

import com.erato.cloud.common.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cart-service")
public interface CartServiceFeign {

    @GetMapping("/shop-cart/getGoodsId")
    public Long getGoodsId(@RequestParam("cartId") long cartId);

    @DeleteMapping("/shop-cart/{id}")
    public Result<Boolean> deleteById(@PathVariable("id") Long id);
}
