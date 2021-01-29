package com.remigiusset.magazine.api.mapper;

import com.remigiusset.magazine.api.model.DesktopDTO;
import com.remigiusset.magazine.domain.Desktop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DesktopMapper {

    DesktopMapper INSTANCE = Mappers.getMapper(DesktopMapper.class);
    DesktopDTO desktopToDesktopDTO(Desktop desktop);
    Desktop desktopDTOToDesktop(DesktopDTO desktopDTO);

}
