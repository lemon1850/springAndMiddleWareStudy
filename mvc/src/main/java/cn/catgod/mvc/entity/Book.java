package cn.catgod.mvc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author weiqiang.lin
 * @version 1.0
 * @date 2021/3/17
 */
@Data
@AllArgsConstructor
@ApiModel(value = "书籍", description = "书籍信息")
public class Book {

    @ApiModelProperty(value = "书本名字", example = "DDIA")
    private String name;
    @ApiModelProperty(value = "单价", example = "1.00")
    private BigDecimal unitPrice;
}
