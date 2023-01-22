package com.giveandtake.userService.services.file;


import com.giveandtake.userService.commands.FileCommand;
import com.giveandtake.userService.dtos.FileDTO;
import com.giveandtake.userService.dtos.mappers.FileMapper;
import com.giveandtake.userService.entities.File;
import com.giveandtake.userService.entities.User;
import com.giveandtake.userService.repositories.FileRepository;
import com.giveandtake.userService.repositories.UserRepository;
import com.giveandtake.userService.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public File addFile(MultipartFile newFile, String userId) throws IOException {

        User user = userService.getUser(userId);
        String fileName = StringUtils.cleanPath(newFile.getOriginalFilename());
        FileCommand file = new FileCommand(fileName, newFile.getContentType(), newFile.getBytes());

        File img = fileMapper.fileCommandToFile(file);
        fileRepository.save(img);

        user.setImg(img);
        userRepository.save(user);
        return img;

    }

    @Override
    public File getFile(String id) {
        return fileRepository.findById(id).get();
    }


}
