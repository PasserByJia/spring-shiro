package com.example.demo.jpaRepository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import javax.persistence.EntityManager;
import java.io.Serializable;

    /**
     * 继承SimpleJpaRepository，SimpleJpaRepository帮助实现了JpaRepository中的方法。否则就要重新实现一遍
     * 实现类，写在MyRepository接口中自定义的方法的具体实现
     */
    public class MyRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
            implements MyRepository<T, ID>{

        private final EntityManager entityManager;

        //父类没有不带参数的构造方法，这里手动构造父类
        public MyRepositoryImpl(Class<T> domainClass, EntityManager em) {
            super(domainClass, em);
            this.entityManager = em;
        }

        //写自定义方法的具体实现。。。
    }