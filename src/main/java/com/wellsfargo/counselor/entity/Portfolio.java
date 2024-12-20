package com.wellsfargo.counselor.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {
    
    @Id
    @GeneratedValue()
    @Column(name = "potfolio_id")
    private Long portfolioId;

    @Column(name="created_at", nullable = false)
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;


    public Portfolio(){

    }

    public Portfolio(Date created_at){
        this.created_at = created_at;
    }

    public Long getPortfolioId(){
        return this.portfolioId;
    }

    public Date getCreatedAt(){
        return this.created_at;
    }

    public void setCreatedAt(Date createdAt){
        this.created_at = createdAt;
    }


    
}
