package com.giveandtake.userService.dtos.mappers;

import com.giveandtake.userService.commands.FileCommand;
import com.giveandtake.userService.dtos.FileDTO;
import com.giveandtake.userService.entities.File;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File fileCommandToFile(FileCommand fileCommand);

    FileDTO fileToFileDTO(File file);
}
