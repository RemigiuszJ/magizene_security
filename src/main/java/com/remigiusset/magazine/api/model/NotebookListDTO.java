package com.remigiusset.magazine.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NotebookListDTO {
    private List<NotebookDTO> notebookList;
}
