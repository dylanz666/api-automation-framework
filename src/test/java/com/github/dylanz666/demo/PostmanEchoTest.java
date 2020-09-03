package com.github.dylanz666.demo;

import com.alibaba.fastjson.JSONObject;
import com.github.dylanz666.constant.MethodEnum;
import com.github.dylanz666.controller.RequestController;
import com.github.dylanz666.domain.RequestSpec;
import com.github.dylanz666.util.AssertUtil;
import com.github.dylanz666.util.annotation.Skip;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author : dylanz
 * @since : 09/03/2020
 */
@SpringBootTest
@Feature("API in PostmanEcho")
public class PostmanEchoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private RequestController requestController;
    @Autowired
    private AssertUtil assertUtil;

    @Test(priority = 1)
    @Description("Get https://postman-echo.com/get?name=%s")
    public void getPostmanEcho() throws Exception {
        String name = "test1";
        String url = "https://postman-echo.com/get?name=%s";
        url = String.format(url, name);

        RequestSpec requestSpec = new RequestSpec();
        requestSpec.setUrl(url);
        requestSpec.setMethod(MethodEnum.GET);
        Response response = requestController.launch(requestSpec);

        assertUtil.assertEquals(response.getStatusCode(), 200);
        assertUtil.assertEquals(JSONObject.parseObject(response.asString()).getString("url"), url);
        assertUtil.assertEquals(JSONObject.parseObject(response.asString()).getJSONObject("args").getString("name"), name);
    }
}
