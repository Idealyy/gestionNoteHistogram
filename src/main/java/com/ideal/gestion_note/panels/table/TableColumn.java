package com.ideal.gestion_note.panels.table;

import lombok.Getter;

/**
 * Holds all columns for TablePanel
 */
@Getter
public enum TableColumn {
    NumEt(0),
    Nom(1),
    Moyenne(2),
    Observation(3);

    final int index;

    TableColumn(int index) {
        this.index = index;
    }

}
