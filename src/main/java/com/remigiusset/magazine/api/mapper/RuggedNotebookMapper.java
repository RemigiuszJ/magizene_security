package com.remigiusset.magazine.api.mapper;

import com.remigiusset.magazine.api.model.RuggedNotebookDTO;
import com.remigiusset.magazine.domain.RuggedNotebook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RuggedNotebookMapper {

    RuggedNotebookMapper INSTANCE = Mappers.getMapper(RuggedNotebookMapper.class);
    RuggedNotebookDTO ruggedNotebookToRuggedNotebookDTO(RuggedNotebook ruggedNotebook);
    RuggedNotebook ruggedNotebookDTOToRuggedNotebook(RuggedNotebookDTO ruggedNotebookDTO);
}
