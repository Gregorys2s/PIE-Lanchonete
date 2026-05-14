/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.Gregorys2s.util;

/**
 *
 * @author pedro
 */
public class SelecaoTabela<T> {
    private final T item;
    private final Integer qtd;
    public SelecaoTabela(T item, Integer qtd) {
        this.item = item;
        this.qtd = qtd;
    }

    public T getItem() {return item;}
    public int getQtd() {return qtd;}
    public boolean temQtd() {return qtd != null;}

}
