/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories.impl;

import com.pthtw.pojo.Category;
import com.pthtw.repositories.CategoryRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Linh
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Category> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        query.select(root);
        
        Query q = s.createQuery(query);
        List<Category> listCategory = q.getResultList();
        return listCategory;
    }
    
}
