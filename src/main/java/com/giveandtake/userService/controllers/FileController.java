package com.giveandtake.userService.controllers;


import com.giveandtake.userService.dtos.FileDTO;
import com.giveandtake.userService.dtos.mappers.FileMapper;
import com.giveandtake.userService.services.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


import static com.giveandtake.userService.constants.PathConstant.*;

@RestController
@RequestMapping(V1+FILE)
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;
    private final FileMapper fileMapper;

    @PostMapping
    public FileDTO addFile(@RequestBody MultipartFile file, @RequestParam String userId) throws IOException {
        return fileMapper
                .fileToFileDTO(fileService.addFile(file,userId));
    }


    @GetMapping("{id}")
    public FileDTO getFile(@PathVariable String id) {
        return fileMapper
                .fileToFileDTO(fileService.getFile(id));
    }

}
