package com.giveandtake.userService.proxies;

import com.giveandtake.userService.proxies.beans.CoverBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.giveandtake.userService.constants.PathConstant.*;

@FeignClient(name = "fileService", url = "localhost:8081" + V1+FILE)
public interface CoverProxy {


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CoverBean addFile(@RequestBody MultipartFile file, @RequestParam String productId);


    @GetMapping("{id}")
    public CoverBean getFile(@PathVariable String id);



}


