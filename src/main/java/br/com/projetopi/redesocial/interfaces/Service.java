package br.com.projetopi.redesocial.interfaces;

import java.util.ArrayList;

public interface Service<T> {
    public void add(T object);
    public boolean update(T object);
    public boolean remove(int id);
    public ArrayList findAllPageable(int qtd_elementos, int num_inicio);
}
