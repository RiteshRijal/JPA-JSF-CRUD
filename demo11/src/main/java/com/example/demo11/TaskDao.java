
package com.example.demo11;


import jakarta.persistence.*;



@Entity
@Table(name="bcd")
public class TaskDao {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    
    @Column(name ="name")
    private String name;
     
     @Column(name ="address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


   
}