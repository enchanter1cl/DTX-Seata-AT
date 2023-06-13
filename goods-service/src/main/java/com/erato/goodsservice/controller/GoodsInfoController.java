package com.erato.goodsservice.controller;

import com.erato.cloud.common.dto.Result;
import com.erato.cloud.common.dto.ResultGenerator;
import com.erato.goodsservice.dao.GoodsInfoDao;
import com.erato.goodsservice.entity.GoodsInfo;
import com.erato.goodsservice.entity.LoginAdminUser;
import com.erato.goodsservice.service.GoodsInfoService;
import com.erato.goodsservice.util.PageQueryUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (GoodsInfo)表控制层
 *
 * @author makejava
 * @since 2023-06-11 23:01:24
 */
@RestController
@Slf4j
@RequestMapping("/goods/admin")
public class GoodsInfoController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsInfoService goodsInfoService;

    @Autowired
    GoodsInfoDao goodsInfoDao;

    @PutMapping("/de-stock/{goodsId}")
    public Boolean deStock(@PathVariable("goodsId") long goodsId) {
        //模拟网络波动问题
//        try {
//            Thread.sleep(10*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //减库存
        return goodsInfoService.deStock(goodsId);
    }


    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    //@ApiOperation(value = "商品列表", notes = "可根据名称和上架状态筛选")
    public Result list(@RequestParam(required = false)  Integer pageNumber,
                       @RequestParam(required = false)  Integer pageSize,
                       @RequestParam(required = false)  String goodsName,
                       @RequestParam(required = false)  Integer goodsSellStatus, LoginAdminUser adminUser) {
        log.info("adminUser:{}", adminUser.toString());
        if (pageNumber == null || pageNumber < 1 || pageSize == null) {
            return ResultGenerator.genFailResult("分页参数异常！");
        }
        Map params = new HashMap(8);
        params.put("page", pageNumber);
        params.put("limit", pageSize);
        if (!StringUtils.isEmpty(goodsName)) {
            params.put("goodsName", goodsName);
        }
        if (goodsSellStatus != null) {
            params.put("goodsSellStatus", goodsSellStatus);
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(goodsInfoService.getGoodsPage(pageUtil));
    }

    /**
     * 分页查询
     *
     * @param goodsInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<GoodsInfo>> queryByPage(GoodsInfo goodsInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsInfoService.queryByPage(goodsInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<GoodsInfo> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.goodsInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<GoodsInfo> add(GoodsInfo goodsInfo) {
        return ResponseEntity.ok(this.goodsInfoService.insert(goodsInfo));
    }

    /**
     * 编辑数据
     *
     * @param goodsInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<GoodsInfo> edit(GoodsInfo goodsInfo) {
        return ResponseEntity.ok(this.goodsInfoService.update(goodsInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.goodsInfoService.deleteById(id));
    }

}

