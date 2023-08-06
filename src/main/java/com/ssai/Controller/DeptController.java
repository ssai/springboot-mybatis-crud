package com.ssai.Controller;


import com.ssai.anno.Log;
import com.ssai.pojo.Dept;
import com.ssai.pojo.Result;
import com.ssai.service.DeptService;
import com.ssai.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope("prototype")
@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
    //@RequestMapping(value = "/dept",method = RequestMethod.GET)//指定请求方式为GET
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据ID查询部门数据
     * @return
     */
    //@RequestMapping(value = "/dept",method = RequestMethod.GET)//指定请求方式为GET
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("查询id为{}的部门数据",id);
        //调用service查询部门数据
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    /**
     * 根据id修改部门信息
     * @param
     * @return
     */
    @Log
    @PutMapping
    public Result updateById(@RequestBody Dept dept){
        log.info("修改id为{}的部门数据",dept.getId());
        deptService.updateById(dept);
        return Result.success();

    }

    /**
     * 删除部门数据
     */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门:{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        //调用service新增部门
        deptService.add(dept);
        return Result.success();
    }

}
