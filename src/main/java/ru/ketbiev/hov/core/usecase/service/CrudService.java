package ru.ketbiev.hov.core.usecase.service;

public interface CrudService<T> {
    public T add(T t);
    public T get(long id);
    public boolean update(T t);
    public boolean delete(long id);
}
