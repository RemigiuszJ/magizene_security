package com.remigiusset.magazine.services;

import com.remigiusset.magazine.api.mapper.RuggedNotebookMapper;
import com.remigiusset.magazine.api.model.RuggedNotebookDTO;
import com.remigiusset.magazine.domain.RuggedNotebook;
import com.remigiusset.magazine.repositories.RuggedNotebookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RuggedNotebookImpl implements  RuggedNotebookService{

    RuggedNotebookRepository ruggedNotebookRepository;
    RuggedNotebookMapper ruggedNotebookMapper;

    public RuggedNotebookImpl(RuggedNotebookRepository ruggedNotebookRepository, RuggedNotebookMapper ruggedNotebookMapper) {
        this.ruggedNotebookRepository = ruggedNotebookRepository;
        this.ruggedNotebookMapper = ruggedNotebookMapper;
    }

    @Override
    public List<RuggedNotebookDTO> getAllRuggedNotebooks() {
        return ruggedNotebookRepository.findAll()
                .stream()
                .map(ruggedNotebookMapper::ruggedNotebookToRuggedNotebookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RuggedNotebookDTO getRuggedNotebookById(Long id) {
        return ruggedNotebookMapper.ruggedNotebookToRuggedNotebookDTO( ruggedNotebookRepository.findById(id).get());
    }

    @Override
    public List<RuggedNotebookDTO> getRuggedNotebookByStatus(String status) {
        return ruggedNotebookRepository.getByStatus(status)
                .stream()
                .map(ruggedNotebookMapper::ruggedNotebookToRuggedNotebookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RuggedNotebookDTO> getRuggedNotebookByMade(String made) {
        return ruggedNotebookRepository.getByMade(made)
                .stream()
                .map(ruggedNotebookMapper::ruggedNotebookToRuggedNotebookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RuggedNotebookDTO> getRuggedNotebookByWaterproof(String waterproof) {
        return ruggedNotebookRepository.getByWaterproof(waterproof)
                .stream()
                .map(ruggedNotebookMapper::ruggedNotebookToRuggedNotebookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RuggedNotebookDTO createNewRuggedNotebook(RuggedNotebookDTO ruggedNotebookDTO) {
        RuggedNotebook ruggedNotebook = ruggedNotebookMapper.ruggedNotebookDTOToRuggedNotebook(ruggedNotebookDTO);
        RuggedNotebook saveRuggedNotebook = ruggedNotebookRepository.save(ruggedNotebook);
        return ruggedNotebookMapper.ruggedNotebookToRuggedNotebookDTO(saveRuggedNotebook);
    }

    @Override
    public RuggedNotebookDTO updateRuggedNotebook(Long id, RuggedNotebookDTO ruggedNotebookDTO) {
        RuggedNotebook ruggedNotebook = ruggedNotebookMapper.ruggedNotebookDTOToRuggedNotebook(ruggedNotebookDTO);
        ruggedNotebook.setId(id);
        RuggedNotebook savedRuggedNotebook = ruggedNotebookRepository.save(ruggedNotebook);

        return ruggedNotebookMapper.ruggedNotebookToRuggedNotebookDTO(savedRuggedNotebook);
    }

    @Override
    public void deleteRuggedNotebookById(Long id) {
        ruggedNotebookRepository.deleteById(id);

    }
}
