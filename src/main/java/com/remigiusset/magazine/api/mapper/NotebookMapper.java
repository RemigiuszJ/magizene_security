package com.remigiusset.magazine.api.mapper;

import com.remigiusset.magazine.api.model.NotebookDTO;
import com.remigiusset.magazine.domain.Notebook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotebookMapper {

    NotebookMapper INSTANCE = Mappers.getMapper(NotebookMapper.class);
    NotebookDTO notebookToNotebookDTO(Notebook notebook);
    Notebook notebookDTOToNotebook(NotebookDTO notebookDTO);
}
