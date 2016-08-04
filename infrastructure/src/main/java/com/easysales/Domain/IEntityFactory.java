package com.easysales.Domain;

import java.awt.Cursor;

import javax.swing.text.html.parser.Entity;

/**
 * Created by drmiller on 03.08.2016.
 */
public interface IEntityFactory<T extends EntityBase> {
    T buildEntity(Cursor cursor);
}
