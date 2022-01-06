package ${package}.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
#foreach ($column in $columns)
#if($column.attrType == 'LocalDate')
import java.time.LocalDate;
#break
#end
#end
#foreach ($column in $columns)
#if($column.attrType == 'LocalDateTime')
import java.time.LocalDateTime;
import com.alibaba.fastjson.annotation.JSONField;
#break
#end
#end
import lombok.Data;
/**
 * Module: ${className}.java
 *
 * @author ${author}
 * @since JDK ${jdk}
 * @version ${version}
 * @date ${date}
 * @Descriptions:
 */
@Data
@TableName(value = "${tableName}")
public class ${className}{

#foreach ($column in $columns)
	/** $column.comments */
#if ("id" == $column.attrname)
	@TableId(value = "id", type = IdType.AUTO)
#end
#if ("createTime" == $column.attrname)
	@TableField(fill = FieldFill.INSERT)
#end
#if ("updateTime" == $column.attrname)
	@TableField(fill = FieldFill.INSERT_UPDATE)
#end
#if ("date" == $column.dataType)
	@JSONField(format = "yyyy-MM-dd")
#end
#if ("datetime" == $column.dataType)
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
#end
	private $column.attrType $column.attrname;
#end
}