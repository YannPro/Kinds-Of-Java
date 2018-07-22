package com.example.demo.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Author: yuyong
 * Date: 2018-05-29 上午11:17
 * Description:
 */
public interface BaseService<T> {

    /**
     * 根据 ID 查询
     */
    T selectById(Long id);

    /**
     * 插入一条记录（选择字段，策略插入）
     */
    boolean insert(T entity);

    /**
     * 插入一条记录（全部字段）
     */
    boolean insertAllColumn(T entity);

    /**
     * 插入（批量），该方法不适合 Oracle
     */
    boolean insertBatch(List<T> entityList);

    /**
     * 插入（批量）
     */
    boolean insertBatch(List<T> entityList, int batchSize);

    /**
     * 批量修改插入
     */
    boolean insertOrUpdateBatch(List<T> entityList);

    /**
     * 批量修改插入
     */
    boolean insertOrUpdateBatch(List<T> entityList, int batchSize);

    /**
     * 批量修改或插入全部字段
     */
    boolean insertOrUpdateAllColumnBatch(List<T> entityList);

    /**
     * 批量修改或插入全部字段
     */
    boolean insertOrUpdateAllColumnBatch(List<T> entityList, int batchSize);

    /**
     * 根据 ID 删除
     */
    boolean deleteById(Long id);

    /**
     * 根据 columnMap 条件，删除记录
     */
    boolean deleteByMap(Map<String, Object> columnMap);

    /**
     * 根据 entity 条件，删除记录
     */
    boolean delete(Wrapper<T> wrapper);

    /**
     * 删除（根据ID 批量删除）
     */
    boolean deleteBatchIds(Collection<? extends Long> idList);

    /**
     * 根据 ID 选择修改
     */
    boolean updateById(T entity);

    /**
     * 根据 ID 修改全部字段
     */
    boolean updateAllColumnById(T entity);

    /**
     * 根据 whereEntity 条件，更新记录
     */
    boolean update(T entity, Wrapper<T> wrapper);

    /**
     * 根据ID 批量更新
     */
    boolean updateBatchById(List<T> entityList);

    /**
     * 根据ID 批量更新
     */
    boolean updateBatchById(List<T> entityList, int batchSize);

    /**
     * 根据ID 批量更新全部字段
     */
    boolean updateAllColumnBatchById(List<T> entityList);

    /**
     * 根据ID 批量更新全部字段
     */
    boolean updateAllColumnBatchById(List<T> entityList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     */
    boolean insertOrUpdate(T entity);

    /**
     * 插入或修改一条记录的全部字段
     */
    boolean insertOrUpdateAllColumn(T entity);

    /**
     * 查询（根据ID 批量查询）
     */
    List<T> selectBatchIds(Collection<? extends Long> idList);

    /**
     * 查询（根据 columnMap 条件）
     */
    List<T> selectByMap(Map<String, Object> columnMap);

    /**
     * 根据 Wrapper，查询一条记录
     */
    T selectOne(Wrapper<T> wrapper);

    /**
     * 根据 Wrapper，查询一条记录
     */
    Map<String, Object> selectMap(Wrapper<T> wrapper);

    /**
     * 根据 Wrapper，查询一条记录
     */
    Object selectObj(Wrapper<T> wrapper);

    /**
     * 根据 Wrapper 条件，查询总记录数
     */
    int selectCount(Wrapper<T> wrapper);

    /**
     * 查询列表
     */
    List<T> selectList(Wrapper<T> wrapper);

    /**
     * 翻页查询
     */
    Page<T> selectPage(Page<T> page);

    /**
     * 查询列表
     */
    List<Map<String, Object>> selectMaps(Wrapper<T> wrapper);

    /**
     * 根据 Wrapper 条件，查询全部记录
     */
    List<Object> selectObjs(Wrapper<T> wrapper);

    /**
     * 翻页查询
     */
    @SuppressWarnings("rawtypes")
    Page<Map<String, Object>> selectMapsPage(Page page, Wrapper<T> wrapper);

    /**
     * 翻页查询
     */
    Page<T> selectPage(Page<T> page, Wrapper<T> wrapper);

}

