package com.remigiusset.magazine.services;

import com.remigiusset.magazine.api.mapper.DesktopMapper;
import com.remigiusset.magazine.api.model.DesktopDTO;
import com.remigiusset.magazine.domain.Desktop;
import com.remigiusset.magazine.repositories.DesktopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesktopServiceImpl implements  DesktopService {

    DesktopRepository desktopRepository;
    DesktopMapper desktopMapper;

    public DesktopServiceImpl(DesktopRepository desktopRepository, DesktopMapper desktopMapper) {
        this.desktopRepository = desktopRepository;
        this.desktopMapper = desktopMapper;
    }

    @Override
    public List<DesktopDTO> getAllDesktops() {
        return desktopRepository.findAll()
                    .stream()
                    .map(desktopMapper::desktopToDesktopDTO)
                    .collect(Collectors.toList());
    }

    @Override
    public DesktopDTO getDesktopById(Long id) {
        return desktopMapper.desktopToDesktopDTO( desktopRepository.findById(id).get());

    }

    @Override
    public List<DesktopDTO> getDesktopByStatus(String status) {
        return desktopRepository.getByStatus(status)
                .stream()
                .map(desktopMapper::desktopToDesktopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DesktopDTO createNewDesktop(DesktopDTO desktopDTO) {
        Desktop desktop = desktopMapper.desktopDTOToDesktop(desktopDTO);
        Desktop savedDesktop = desktopRepository.save(desktop);
        return desktopMapper.desktopToDesktopDTO(savedDesktop);
    }

    @Override
    public DesktopDTO updateDesktop(Long id, DesktopDTO desktopDTO) {
        Desktop desktop = desktopMapper.desktopDTOToDesktop(desktopDTO);
        desktop.setId(id);
        Desktop savedDesktop = desktopRepository.save(desktop);

        return desktopMapper.desktopToDesktopDTO(savedDesktop);
    }

    @Override
    public void deleteDesktopById(Long id) {
        desktopRepository.deleteById(id);

    }

    @Override
    public List<DesktopDTO> getDesktopByCondition(String condition) {
        return desktopRepository.getByCondition(condition)
                .stream()
                .map(desktopMapper::desktopToDesktopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DesktopDTO> getDesktopByPreorder(String preorder) {
        return desktopRepository.getByPreorder(preorder)
                .stream()
                .map(desktopMapper::desktopToDesktopDTO)
                .collect(Collectors.toList());
    }
}
