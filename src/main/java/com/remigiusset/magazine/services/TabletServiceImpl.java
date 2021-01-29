package com.remigiusset.magazine.services;

import com.remigiusset.magazine.api.mapper.TabletMapper;
import com.remigiusset.magazine.api.model.TabletDTO;
import com.remigiusset.magazine.domain.Tablet;
import com.remigiusset.magazine.repositories.TabletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TabletServiceImpl implements  TabletService{

    TabletRepository tabletRepository;
    TabletMapper tabletMapper;

    public TabletServiceImpl(TabletRepository tabletRepository, TabletMapper tabletMapper) {
        this.tabletRepository = tabletRepository;
        this.tabletMapper = tabletMapper;

    }

    @Override
    public List<TabletDTO> getAllTablets() {
        return  tabletRepository.findAll()
                .stream()
                .map(tabletMapper::tabletToTabletDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TabletDTO getTabletById(Long id) {
        return tabletMapper.tabletToTabletDTO((tabletRepository.findById(id).get()));
    }

    @Override
    public List<TabletDTO> getTabletByStatus(String status) {
        return tabletRepository.getByStatus(status)
                .stream()
                .map(tabletMapper::tabletToTabletDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TabletDTO> getTabletByColour(String colour) {
        return tabletRepository.getByColour(colour)
                .stream()
                .map(tabletMapper::tabletToTabletDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TabletDTO> getTabletBySize(String size) {
        return tabletRepository.getBySize(size)
                .stream()
                .map(tabletMapper::tabletToTabletDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TabletDTO createNewTablet(TabletDTO tabletDTO) {
        Tablet tablet = tabletMapper.tabletDTOToTablet(tabletDTO);
        Tablet saveTablet = tabletRepository.save(tablet);
        return tabletMapper.tabletToTabletDTO(saveTablet);
    }

    @Override
    public TabletDTO updateTablet(Long id, TabletDTO tabletDTO) {
       Tablet tablet = tabletMapper.tabletDTOToTablet(tabletDTO);
        tablet.setId(id);
       Tablet saveTablet = tabletRepository.save(tablet);

        return tabletMapper.tabletToTabletDTO(saveTablet);
    }

    @Override
    public void deleteTabletById(Long id) {
        tabletRepository.deleteById(id);
    }
}
