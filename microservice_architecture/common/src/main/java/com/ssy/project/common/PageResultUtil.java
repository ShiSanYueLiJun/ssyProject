package com.ssy.project.common;

import java.util.Collections;
import java.util.List;

/**
 * @author LiJun
 * @date 2022-01-11 11:23
 * 分页结果工具类
 */
public class PageResultUtil {
    /**
     * 分页找不到数据
     *
     * @param <T> 真实返回模型(泛类型)
     * @return 分页结果
     */
    public static <T> ResultModel<List<T>> success() {
        PageResultModelSupport<List<T>> result = new PageResultModelSupport<>();
        result.setStatus(Status.S.getValue());
        result.setData(Collections.emptyList());
        result.setTotalCount(0);
        return result;
    }

    /**
     * 返回成功数据（带总数）
     *
     * @param modelList  返回列表数据
     * @param totalCount 总数
     * @param <T>        返回模型(泛类型)
     * @return 分页结果
     */
    public static <T> ResultModel<List<T>> success(List<T> modelList, int totalCount) {
        PageResultModelSupport<List<T>> result = new PageResultModelSupport<>();
        result.setStatus(Status.S.getValue());
        result.setData(modelList);
        result.setTotalCount(totalCount);
        return result;
    }

    /**
     * 返回成功数据（带总数,当前页码,当前分页数）
     *
     * @param modelList  返回列表数据
     * @param totalCount 总数
     * @param pageSize   每页数
     * @param pageIndex  页码
     * @param <T>        返回模型
     * @return 分页结果
     */
    public static <T> ResultModel<List<T>> success(List<T> modelList, int totalCount, int pageSize,
                                                   int pageIndex) {
        PageResultModelSupport<List<T>> result = new PageResultModelSupport<>();
        result.setStatus(Status.S.getValue());
        result.setData(modelList);
        result.setTotalCount(totalCount);
        result.setPageIndex(pageIndex);
        result.setPageSize(pageSize);
        return result;
    }

    /**
     * 仅有message
     * @param messageStr
     * @param <T>
     * @return
     */
    public static <T> ResultModel<List<T>> fail(String messageStr) {
        PageResultModelSupport<List<T>> result = new PageResultModelSupport<>();
        result.setStatus(Status.F.getValue());
        Message message = new Message(messageStr);
        result.setMessage(message);

        //result.setNeedRetry(errorCodeEnum.isNeedRetry());
        return result;
    }

    /**
     * 自定义message
     * @param resultCodeEnum
     * @param messageStr
     * @param <T>
     * @return
     */
    public static <T> ResultModel<List<T>> fail(ResultCodeEnum resultCodeEnum, String messageStr) {
        PageResultModelSupport<List<T>> result = new PageResultModelSupport<>();
        result.setStatus(resultCodeEnum.getResultStatus().getValue());

        Message message = new Message(resultCodeEnum);
        message.setMessage(messageStr);

        result.setMessage(message);

        //result.setNeedRetry(errorCodeEnum.isNeedRetry());
        return result;
    }





    /*
     * 根据页容页码获取数据起始位置
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static int getFromIndex(int pageIndex, int pageSize) {
        pageIndex = pageIndex <= 1 ? 1 : pageIndex;
        pageSize = pageSize <= 1 ? 1 : pageSize;
        return (pageIndex - 1) * pageSize;
    }

    /**
     * 根据页容页码 数据总数量获取数据结束位置
     *
     * @param pageIndex
     * @param pageSize
     * @param totalCount
     * @return
     */
    public static int getEndIndex(int pageIndex, int pageSize, int totalCount) {
        pageIndex = pageIndex <= 1 ? 1 : pageIndex;
        pageSize = pageSize <= 1 ? 1 : pageSize;
        return (pageIndex - 1) * pageSize + pageSize <= totalCount ? (pageIndex - 1) * pageSize + pageSize : totalCount;
    }

    /**
     * 在内存中进行分页
     *
     * @param contentList 内容列表
     * @param pageIndex   页码
     * @param pageSize    页容
     * @param <T>
     * @return
     */
    public static <T> ResultModel<List<T>> splitPageInMemory(
            List<T> contentList, int pageIndex, int pageSize) {
        int totalCount = contentList.size();
        int fromIndex = getFromIndex(pageIndex, pageSize);
        int endIndex = getEndIndex(pageIndex, pageSize, totalCount);
        if (fromIndex >= totalCount) {
            contentList = Collections.emptyList();
        } else {
            contentList = contentList.subList(fromIndex, endIndex);
        }
        return PageResultUtil.success(contentList, totalCount, pageSize, pageIndex);
    }
}
