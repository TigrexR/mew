package com.tigrex.mew.manager.redis;

/**
 * @author linus
 */
public interface BaseRedis<T> {

    /**
     * insert
     * @param key key
     * @param entity entity
     */
    void insert(String key, T entity);

    /**
     * delete
     * @param key
     * @return
     */
    boolean deleteByKey(String key);

    /**
     * update by key
     * @param key key
     * @param entity entity
     */
    void updateByKey(String key, T entity);

    /**
     * select by key
     * @param key key
     * @return T
     */
    T selectByKey(String key);
}
