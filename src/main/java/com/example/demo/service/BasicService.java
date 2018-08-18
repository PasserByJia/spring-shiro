package com.example.demo.service;

import com.example.demo.jpaRepository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class BasicService<T extends Serializable,ID extends Serializable> {

    @Autowired
    MyRepository<T, ID> basicDao;

    public Optional<T> findOne(Example<T> t) {
        return basicDao.findOne(t);
    }

    public Optional<T> findOneByX(Specification<T> spec) {
        return basicDao.findOne(spec);
    }

    //得到某实体类所有信息
//    @Cacheable(value = "t.all", key = "#tName")
    public List<T> findAllT(String tName) {
        return basicDao.findAll();
    }

    //得到可以分页的所有实体类信息
//    @Cacheable(value = "t.pageable.all", key = "#tName")
//    @CacheEvict(value = "t.pageable.all", beforeInvocation=true, key = "#tName")
    public Page<T> findAllPagebleT(Pageable pt, String tName) {
        return basicDao.findAll(pt);
    }

    //多个动态条件查找，查询到满足条件的多个实体类信息
    public List<T> findTsByXX(Specification<T> specification) {
        return basicDao.findAll(specification);
    }

    //多个动态条件查找，查询到满足条件的多个实体类信息---分页显示
    public Page<T> findPageTsByXX(Specification<T> specification, Pageable pageable) {
        return basicDao.findAll(specification, pageable);
    }

    //单个增加
//    @CacheEvict(value = {"t.all","t.pageable.all"}, beforeInvocation=true, key = "#tName")
    public void add(T t, String tName) {
        this.basicDao.save(t);
    }

    //批量增加
    public void addList(Iterable<T> ts) {
        this.basicDao.saveAll(ts);
    }

    //单个更新
//    @CacheEvict(value = {"t.all","t.pageable.all"}, beforeInvocation=true, key = "#tName")
    public void update(T t, String tName) {
        this.basicDao.saveAndFlush(t);
    }

    //单个删除，传的是实体类
//    @CacheEvict(value = {"t.all","t.pageable.all"}, beforeInvocation=true, key = "#tName")
    public void delete(T t, String tName) {
        this.basicDao.delete(t);
    }

    //批量删除,后台是生成一条SQL语句[之前那个是一条条删除]，效率更高些
//    @CacheEvict(value = {"t.all","t.pageable.all"}, beforeInvocation=true, key = "#tName")
    public void deleteList(Iterable<T> ts, String tName) {
        this.basicDao.deleteInBatch(ts);
    }

}