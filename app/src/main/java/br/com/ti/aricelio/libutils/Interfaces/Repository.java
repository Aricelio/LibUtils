package br.com.ti.aricelio.libutils.Interfaces;

import java.util.List;

/**
 * Created by aricelio on 15/07/16.
 */
public interface Repository<T> {
    // Métodos
    T open(Long id) throws Exception;
    void save(T obj) throws Exception;
    void update(T obj) throws Exception;
    void delete(Long id) throws Exception;
    List<T> find() throws Exception;
}
