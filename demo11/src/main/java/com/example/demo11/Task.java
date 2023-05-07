 package com.example.demo11;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.util.List;

@Named
@RequestScoped
public class Task {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    private String address;
    
    
     public List<TaskDao> getEntities() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        List<TaskDao> entities = em.createQuery("SELECT c FROM TaskDao c").getResultList();
        em.close();
        emf.close();
        return entities;
    }
     
     
 public void addTask() {
        TaskDao taskDao = new TaskDao();
        taskDao.setId(id);
        taskDao.setName(name);
        taskDao.setAddress(address);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(taskDao);
        transaction.commit();
        em.close();
        emf.close();
        // reset the form fields after adding the task
        name = null;
        address = null;
        id=null;
    }
 
  public void modifyDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default"); // Replace with your persistence unit name
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createQuery("UPDATE TaskDao e SET e.name = :name, e.address = :address WHERE e.id = :id");
        query.setParameter("name", name);
        query.setParameter("address", address);
        query.setParameter("id", id);
        
        int rowsUpdated = query.executeUpdate();
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        if (rowsUpdated > 0) {
            // Successful update
            // You can add a success message or perform any other desired action
        } else {
            // ID not found or no rows updated
            // You can add an error message or perform any other desired action
        }
         name = null;
        address = null;
        id=null;
    }
  public void deleteFromDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default"); // Replace with your persistence unit name
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createQuery("DELETE FROM TaskDao e WHERE e.id = :id");
        query.setParameter("id", id);
        
        int rowsDeleted = query.executeUpdate();
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        if (rowsDeleted > 0) {
            // Successful deletion
            // You can add a success message or perform any other desired action
        } else {
            // ID not found or no rows deleted
            // You can add an error message or perform any other desired action
        }
         name = null;
        address = null;
        id=null;
    }



    
}