package cn.catgod.mvc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author weiqiang.lin
 * @version 1.0
 * @date 2021/3/17
 */
@Data
@ApiModel(value = "书籍购买请求体", description = "描述买书时需要的信息")
public class BuyDto {

    @ApiModelProperty(value = "书本id", example = "123", required = true)
    private long bookId;
    @ApiModelProperty(value = "书本isbn", example = "DA121434")
    private String isbn;
}
