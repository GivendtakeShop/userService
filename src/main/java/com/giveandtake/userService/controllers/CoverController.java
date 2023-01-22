package com.giveandtake.userService.controllers;

import com.giveandtake.userService.proxies.CoverProxy;
import com.giveandtake.userService.proxies.beans.CoverBean;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.giveandtake.userService.constants.PathConstant.*;


@RestController
@RequestMapping(V1+COVER)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CoverController {

    private final CoverProxy coverProxy;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CoverBean addFile(@RequestBody MultipartFile file, @RequestParam String productId){
        return coverProxy.addFile(file,productId);
    }


    @GetMapping("{id}")
    public CoverBean getFile(@PathVariable String id){
        return coverProxy.getFile(id);
    }
}