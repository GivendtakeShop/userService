package com.giveandtake.userService.services.file;

import com.giveandtake.userService.entities.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileService {

    public File addFile(MultipartFile file, String userId) throws IOException;

    public File getFile(String id);

}
