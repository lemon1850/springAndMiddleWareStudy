package cn.catgod.mvc.controller;

import cn.catgod.mvc.dto.BuyDto;
import cn.catgod.mvc.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author weiqiang.lin
 * @version 1.0
 * @date 2021/3/17
 */
@Api("swaggerDemo")
@RestController("/")
public class SwaggerController {

    @ApiOperation(value = "购买书籍", notes = "通过post bookId购买对应的商品")
    @PostMapping("/buy")
    public Book requestForBuy(BuyDto buyDto){
        return new Book("DDIA", BigDecimal.ONE);
    }
}
