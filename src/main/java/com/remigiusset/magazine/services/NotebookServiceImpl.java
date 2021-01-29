package com.remigiusset.magazine.services;

import com.remigiusset.magazine.api.mapper.NotebookMapper;
import com.remigiusset.magazine.api.model.NotebookDTO;
import com.remigiusset.magazine.domain.Notebook;
import com.remigiusset.magazine.repositories.NotebookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotebookServiceImpl implements NotebookService{

    NotebookRepository notebookRepository;
    NotebookMapper notebookMapper;

    public NotebookServiceImpl(NotebookRepository notebookRepository, NotebookMapper notebookMapper) {
        this.notebookRepository = notebookRepository;
        this.notebookMapper = notebookMapper;
    }

    @Override
    public List<NotebookDTO> getAllNotebooks() {
        return notebookRepository.findAll()
                .stream()
                .map(notebookMapper::notebookToNotebookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NotebookDTO getNotebookById(Long id) {
        return notebookMapper.notebookToNotebookDTO( notebookRepository.findById(id).get());
    }

    @Override
    public List<NotebookDTO> getNotebookByStatus(String status) {
        return notebookRepository.getByStatus(status)
                .stream()
                .map(notebookMapper::notebookToNotebookDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<NotebookDTO> getNotebookByPreorder(String preorder) {
        return notebookRepository.getByPreorder(preorder)
                .stream()
                .map(notebookMapper::notebookToNotebookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotebookDTO> getNotebookByRanking(String ranking) {
        return notebookRepository.getByRanking(ranking)
                .stream()
                .map(notebookMapper::notebookToNotebookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NotebookDTO createNewNotebook(NotebookDTO notebookDTO) {
        Notebook notebook = notebookMapper.notebookDTOToNotebook(notebookDTO);
        Notebook saveNotebook = notebookRepository.save(notebook);
        return notebookMapper.notebookToNotebookDTO(saveNotebook);
    }

    @Override
    public NotebookDTO updateNotebook(Long id, NotebookDTO notebookDTO) {
        Notebook notebook = notebookMapper.notebookDTOToNotebook(notebookDTO);
        notebook.setId(id);
        Notebook savedNotebook = notebookRepository.save(notebook);

        return notebookMapper.notebookToNotebookDTO(savedNotebook);
    }

    @Override
    public void deleteNotebookById(Long id) {
        notebookRepository.deleteById(id);


    }



}
