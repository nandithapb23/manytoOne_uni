package com.ty.manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni2.Bank;
import manytoone_uni2.Branch;

public class Bankdao {
public EntityManager getEntityManager(){
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	return entityManager;
}
public void saveBank(Bank bank){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(bank);
	entityTransaction.commit();
}
public void updateBank(int id,Bank bank){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Bank bank1=entityManager.find(Bank.class, id);
	if(bank1!=null){
//		bank1.setId(id);
		bank1.setName(bank.getName());
		bank1.setHeadOffice(bank.getHeadOffice());
		bank1.setCeo(bank.getCeo());
		entityTransaction.begin();
		entityManager.merge(bank1);
		entityTransaction.commit();
	}else{
		System.out.println("bank does not exist");
	}
}
public void deleteBank(int id){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Bank bank1=entityManager.find(Bank.class, id);
	if(bank1!=null){
		entityTransaction.begin();
		entityManager.remove(bank1);
		entityTransaction.commit();
	}else{
		System.out.println("this bank doesnt exist");
	}
}
public Bank getbankById(int id){
	EntityManager entityManager=getEntityManager();
	Bank bank1=entityManager.find(Bank.class, id);
	return bank1;
}
public List<Bank> getBank(){
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select b from Bank b");
	List<Bank>list=query.getResultList();
	return list;
}
}
