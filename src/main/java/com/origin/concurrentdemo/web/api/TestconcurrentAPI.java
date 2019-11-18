package com.origin.concurrentdemo.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "并发编程")
public interface TestconcurrentAPI {
    public final String API_SWAGGERUI ="/swaggerUi";

    @GetMapping(value = API_SWAGGERUI+"/testConcurrentDemo/{id}",name = "并发知识1")
    @ResponseBody
    @ApiOperation(value = "并发知识1",notes = "并发知识1")
    public void testConcurrentDemo(@PathVariable Integer id) ;


}
