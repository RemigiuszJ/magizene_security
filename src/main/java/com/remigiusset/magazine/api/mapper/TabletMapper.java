package com.remigiusset.magazine.api.mapper;

import com.remigiusset.magazine.api.model.TabletDTO;
import com.remigiusset.magazine.domain.Tablet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TabletMapper {

    TabletMapper INSTANCE = Mappers.getMapper(TabletMapper.class);
    TabletDTO tabletToTabletDTO(Tablet tablet);
    Tablet tabletDTOToTablet(TabletDTO tabletDTO);

}
