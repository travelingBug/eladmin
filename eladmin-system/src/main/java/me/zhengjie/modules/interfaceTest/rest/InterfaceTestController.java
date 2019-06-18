package me.zhengjie.modules.interfaceTest.rest;

import com.alibaba.fastjson.JSONObject;
import com.ucap.restful.client.ResClientUtils;
import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.system.domain.Role;
import me.zhengjie.modules.system.service.RoleService;
import me.zhengjie.modules.system.service.query.RoleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static cn.hutool.core.lang.Console.log;

/**
 * 调用大邑方面提供的接口
 */
@RestController
@RequestMapping("api")
public class InterfaceTestController {

    @Autowired
    private RoleService roleService;

    @Log("接口调用")
    @GetMapping(value = "/interfaceTest")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_EDIT')")
    public ResponseEntity sendGetRequest(String interfaceURL){
        log("--------进入接口调用-------");
        log(interfaceURL);
        testInterfaceGetMethod(interfaceURL);
        return new ResponseEntity(roleService.findById(4),HttpStatus.OK);
    }

    /**
     * Get方式的接口测试
     */
    private  static  void testInterfaceGetMethod(String url) {
//        String path="http://10.1.231.85:8004/website-webapp/rest/channel/getChannelsByWebsiteId?websiteId=2d17b9ef1054448d80b6ac9b05a804be";
        String strategyCode = "demoCode";
        String key = "abcd1234";//密钥
        Map<String, String> params = new HashMap<String, String>();
        params.put("websiteId", "98ae5513f6aa426bb8bdd804751396ca");
        String msg = ResClientUtils.sendGetUrl(url, strategyCode, key);
        System.out.println(msg);
    }

    public static void main(String[] args){
        String url = "http://10.1.231.85:8004/website-webapp/rest/channel/getChannelsByWebsiteCode?websiteCode=demo";
        testInterfaceGetMethod(url);
    }

}
