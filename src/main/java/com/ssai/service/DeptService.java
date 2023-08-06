package com.ssai.service;

import com.ssai.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询全部部门数据
     * @return
     */
     List<Dept> list();

    /**
     * 删除部门
     * @param id
     */

    void delete(Integer id) throws Exception;

    /**
     * 增加部门
     * @param dept
     */
    void add(Dept dept);


    /**
     * 根据ID查询部门数据
     * @return
     */
    Dept selectById(Integer id);

    /**
     * 根据id修改部门信息
     * @param dept
     */
    void updateById(Dept dept);
}
