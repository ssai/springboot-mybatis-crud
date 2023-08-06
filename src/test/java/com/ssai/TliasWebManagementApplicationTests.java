package com.ssai;

import com.ssai.Controller.DeptController;
import com.ssai.mapper.DeptMapper;
import com.ssai.mapper.EmpMapper;
import com.ssai.pojo.Emp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest
class TliasWebManagementApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;//IOC容器对象

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private SAXReader saxReader;
    //private DeptMapper deptMapper;

   // @Test
/*    public void testDelete(){
*//*        int delete = empMapper.delete(16);
        System.out.println(delete);*//*

       empMapper.delete(16);
    }*/

    /*public void testInsert(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom1");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
        System.out.println(emp.getId());
    }*/

/*    public void testUpdate(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom111");
        emp.setName("汤姆222");
        //emp.setImage("1.jpg");
        emp.setGender((short)2);
        //emp.setJob((short)1);
        //emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        //emp.setDeptId(1);

        empMapper.update(emp);
    }*/
        //根据ID查询员工
/*    public void testGetById(){
        Emp emp = empMapper.getById(20);
        System.out.println(emp);
    }*/

    //根据条件查询员工
/*    public void testList(){
        List<Emp> empList = empMapper.list("张", (short)1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        System.out.println(empList);
    }*/

/*    public void testUpdate2(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(18);
        //emp.setUsername("Tom111");
        //emp.setName("汤姆222");
        //emp.setImage("1.jpg");
        //emp.setGender((short)2);
        //emp.setJob((short)1);
        //emp.setEntrydate(LocalDate.of(2000,1,1));
        //emp.setUpdateTime(LocalDateTime.now());
        //emp.setDeptId(1);

        empMapper.update2(emp);
    }*/

/*    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(18,19,20);
        empMapper.deleteByIds(ids);
    }*/


/*    public void testDeleteByIds(){
        empMapper.deleteByIds(ids);
    }*/

    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "ssai")//签名算法
                .setClaims(claims)//自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期为1h
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("ssai")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4OTQzNjY5OH0.rZ6JKGseBAcloFERdQLifvG88bm3cc72y6c8MQgWmVU")
                .getBody();
        System.out.println(claims);
    }

    @Test
    public void testGetBean(){
        //根据bean的名称获取
        DeptController bean1 = (DeptController) applicationContext.getBean("deptController");
        System.out.println(bean1);
        //根据bean的类型获取
        DeptController bean2 = applicationContext.getBean(DeptController.class);
        System.out.println(bean2);

        //根据bean的名称 及 类型获取
        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
        System.out.println(bean3);

    }



    //第三方bean的管理
    @Test
    public void testThirdBean() throws Exception{
        //SAXReader saxReader =new SAXReader();
        Document document = saxReader.read(this.getClass().getClassLoader().getResource("1.xml"));
        Element rootElement = document.getRootElement();
        String name = rootElement.element("name").getText();
        String age = rootElement.element("age").getText();

        System.out.println(name+":"+age);

    }

    @Test
    public void testGetBean2(){
        Object saxReader =applicationContext.getBean("saxReader");
        System.out.println(saxReader);
    }

}
