package cn.rtomde.admin.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Valid
public class PageParam extends BaseParam {

    private static final long MAX_PAGE_SIZE = 100;

    @Schema(description = "页码", defaultValue = "1", minimum = "1")
    @Min(value = 1, message = "页码不能小于 1")
    private long pageNum = 1;

    @Schema(description = "分页数量", defaultValue = "20", minimum = "1", maximum = "100")
    @Min(value = 1, message = "页数不能小于 1")
    @Max(value = 100, message = "页数不能大于 100")
    private long pageSize = 20;

    public long getPageNum() {
        return pageNum > 0 ? pageNum : 1;
    }

    public long getPageSize() {
        return pageSize > 0 ? (pageSize <= MAX_PAGE_SIZE ? pageSize : MAX_PAGE_SIZE) : 1;
    }
}
