package com.ty.manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni2.Bank;
import manytoone_uni2.Branch;

public class Branchdao {
	public EntityManager getEntityManager(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
}
	public void saveBranch(Branch branch,Bank bank){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		branch.setBank(bank);
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(branch);
		entityTransaction.commit();
	}
	public void updateBranch(int id,Branch branch){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch1=entityManager.find(Branch.class, id);
		if(branch1!=null){
//			branch.setId(id);
		branch1.setName(branch.getName());
		branch1.setIfsc(branch.getIfsc());
		branch1.setAddress(branch.getAddress());
		branch1.setManager(branch.getManager());
		branch1.setPhone(branch.getPhone());
		entityTransaction.begin();
		entityManager.merge(branch1);
		entityTransaction.commit();
	}else{
		System.out.println("this branch doesnot exist");
	}
	}
public void deleteBranch(int id){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Branch branch1=entityManager.find(Branch.class, id);
	if(branch1!=null){
		entityTransaction.begin();
		entityManager.remove(branch1);
		entityTransaction.commit();
	}
}
public Branch getBranchById(int id){
	EntityManager entityManager=getEntityManager();
	Branch branch1=entityManager.find(Branch.class, id);
	return branch1;
}
public List<Branch> getBranch(){
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select b from Branch b");
	List<Branch>list=query.getResultList();
	return list;
	
}
}