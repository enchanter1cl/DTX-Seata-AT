package com.erato.goodsservice.req;

import lombok.Data;

@Data
public class GoodsCategoryEditReq {

//    @ApiModelProperty("待修改分类id")
//    @NotNull(message = "分类id不能为空")
//    @Min(value = 1, message = "分类id不能为空")
    private Long categoryId;

//    @ApiModelProperty("分类层级")
//    @NotNull(message = "categoryLevel不能为空")
//    @Min(value = 1, message = "分类级别最低为1")
//    @Max(value = 3, message = "分类级别最高为3")
    private Byte categoryLevel;

//    @ApiModelProperty("父类id")
//    @NotNull(message = "parentId不能为空")
//    @Min(value = 0, message = "parentId最低为0")
    private Long parentId;

//    @ApiModelProperty("分类名称")
//    @NotEmpty(message = "categoryName不能为空")
//    @Length(max = 16,message = "分类名称过长")
    private String categoryName;

//    @ApiModelProperty("排序值")
//    @Min(value = 1, message = "categoryRank最低为1")
//    @Max(value = 200, message = "categoryRank最高为200")
//    @NotNull(message = "categoryRank不能为空")
    private Integer categoryRank;
}
