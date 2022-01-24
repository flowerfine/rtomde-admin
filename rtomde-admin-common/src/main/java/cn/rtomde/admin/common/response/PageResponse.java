package cn.rtomde.admin.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Schema
public class PageResponse<T> extends BaseResponse {

    private static final long serialVersionUID = -5272870411950609527L;

    /**
     * 当前页
     */
    @Schema(description = "当前页", defaultValue = "1")
    private Long pageNum = 1L;

    /**
     * 页面大小
     */
    @Schema(description = "页面大小", defaultValue = "20")
    private Long pageSize = 20L;

    /**
     * 总记录数
     */
    @Schema(description = "总记录数")
    private Long totalRecord = 0L;

    /**
     * 分页数据详情，返回结果集
     */
    @Schema(description = "分页数据详情，返回结果集")
    private Collection<T> details;

    @Schema(description = "总页数")
    public Long getTotalPage() {
        if (getTotalRecord() == 0L) {
            return 0L;
        } else {
            long pages = getTotalRecord() / getPageSize();
            if (getTotalRecord() % getPageSize() != 0L) {
                ++pages;
            }
            return pages;
        }
    }

    /**
     * 是否存在上一页
     */
    @Schema(description = "是有存在上一页")
    public boolean isHasPrevious() {
        return getPageNum() > 1L;
    }

    /**
     * 是否存在下一页
     */
    @Schema(description = "是否存在下一页")
    public boolean isHasNext() {
        return getPageNum() < getTotalPage();
    }

    @Schema(description = "是否存在数据")
    public boolean isHasDetails() {
        if (getTotalRecord() <= 0 || details.size() == 0) {
            return false;
        }
        return true;
    }
}