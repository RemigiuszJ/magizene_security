package com.remigiusset.magazine.services;


import com.remigiusset.magazine.api.model.NotebookDTO;

import java.util.List;

public interface NotebookService {

    List<NotebookDTO> getAllNotebooks();
    NotebookDTO getNotebookById( Long id);
    List<NotebookDTO> getNotebookByStatus(String status);
    List<NotebookDTO> getNotebookByPreorder(String preorder);
    List<NotebookDTO> getNotebookByRanking(String ranking);
    NotebookDTO createNewNotebook( NotebookDTO notebookDTO);
    NotebookDTO updateNotebook(Long id,NotebookDTO notebookDTO);
    void deleteNotebookById(Long id);
}
