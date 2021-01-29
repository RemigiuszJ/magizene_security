package com.remigiusset.magazine.services;

import com.remigiusset.magazine.api.model.RuggedNotebookDTO;


import java.util.List;

public interface RuggedNotebookService {
    List<RuggedNotebookDTO> getAllRuggedNotebooks();
    RuggedNotebookDTO getRuggedNotebookById(Long id);
    List<RuggedNotebookDTO> getRuggedNotebookByStatus(String status);
    List<RuggedNotebookDTO> getRuggedNotebookByMade(String made);
    List<RuggedNotebookDTO> getRuggedNotebookByWaterproof(String waterproof);
    RuggedNotebookDTO createNewRuggedNotebook(RuggedNotebookDTO ruggedNotebookDTO);
    RuggedNotebookDTO updateRuggedNotebook(Long id,RuggedNotebookDTO ruggedNotebookDTO);
    void deleteRuggedNotebookById(Long id);
}
