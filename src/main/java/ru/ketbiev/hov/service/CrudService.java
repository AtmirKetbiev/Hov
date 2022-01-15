package ru.ketbiev.hov.service;

public interface CrudService<T> {
    public T add(T t);
    public T get(int id);
    public T update(T t);
    public boolean delete(int id);
}
