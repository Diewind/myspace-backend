package com.my_space.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.my_space.common.validator.group.AddGroup;
import com.my_space.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author lyh
 * @since 2020-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("back_role")
@ApiModel(value="Role对象", description="角色表")
public class Role implements Serializable {

  private static final long serialVersionUID=1L;

  @ApiModelProperty(value = "角色 ID")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  @NotEmpty(message = "{role.name.empty}", groups = {AddGroup.class, UpdateGroup.class})
  @ApiModelProperty(value = "用户名")
  private String name;

  @NotEmpty(message = "{role.authorizer.empty}", groups = {AddGroup.class, UpdateGroup.class})
  @ApiModelProperty(value = "授权人")
  private String authorizer;

  @TableField(fill = FieldFill.INSERT)
  @ApiModelProperty(value = "创建时间")
  private Date createTime;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  @ApiModelProperty(value = "修改时间")
  private Date updateTime;

  @TableField(fill = FieldFill.INSERT)
  @TableLogic(value = "0", delval = "1")
  @ApiModelProperty(value = "逻辑删除标志，0 表示未删除， 1 表示删除")
  private Integer deleteFlag;

  @Version
  @TableField(fill = FieldFill.INSERT)
  @ApiModelProperty(value = "版本号")
  private Integer version;

  @NotEmpty(message = "{role.authorizedMenu.empty}", groups = {AddGroup.class, UpdateGroup.class})
  @ApiModelProperty(value = "授权菜单")
  private String authorizedMenu;

}
