package goodsserviceapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("goods-service")
public interface GoodsServiceFeign {

    @PutMapping("/de-stock/{goodsId}")
    public Boolean deStock(@PathVariable("goodsId") int goodsId);
}
