package com.ty.manytoone_uni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytoone_uni.dao.Bankdao;
import com.ty.manytoone_uni.dao.Branchdao;

import manytoone_uni2.Bank;
import manytoone_uni2.Branch;

public class BankMain {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	boolean repeat=true;
	Bank bank=new Bank();
	Branch branch=new Branch();
	Bankdao dao=new Bankdao();
	Branchdao dao1=new Branchdao();
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	do{
		System.out.println("1:Bank \n 2:Branch");
		System.out.println("enter your choice");
		int choice=scanner.nextInt();
		switch(choice){
		case 1:{
			System.out.println("1:save bank \n 2:update bank 3:delete bank \n 4:getbank by id \n 5:getbank");
			System.out.println("enter your choice");
			int choice1=scanner.nextInt();
			switch(choice1){
			case 1:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the headoffice");
				String headOffice=scanner.next();
				System.out.println("enter the ceo");
				String ceo=scanner.next();
				EntityManager entityManager=dao.getEntityManager();
				bank.setId(id);
				bank.setName(name);
				bank.setHeadOffice(headOffice);
				bank.setCeo(ceo);
				
				dao.saveBank(bank);
				System.out.println("inserted successfully");
			}
			break;
			case 2:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the headoffice");
				String headOffice=scanner.next();
				System.out.println("enter the ceo");
				String ceo=scanner.next();
				EntityManager entityManager=dao.getEntityManager();
				bank.setId(id);
				bank.setName(name);
				bank.setHeadOffice(headOffice);
				bank.setCeo(ceo);
				
				dao.updateBank(id, bank);
				System.out.println("updated successfully");
			}
			break;
			case 3:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				EntityManager entityManager=dao.getEntityManager();
				bank.setId(id);
				dao.deleteBank(id);
				System.out.println("deleted successfully");
			}
			break;
			case 4:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				EntityManager entityManager=dao.getEntityManager();
				bank.setId(id);
				dao.getbankById(id);
				Bank bank1=dao.getbankById(id);
				System.out.println(bank1);
				System.out.println("displayed successfully");
			}
			break;
			case 5:{
				EntityManager entityManager=dao.getEntityManager();
				List<Bank>list=dao.getBank();
				System.out.println(list);
			}
			break;
			}
		}
		break;
		case 2:{
			System.out.println("1:save branch \n 2:update branch \n 3:delete branch \n 4:getbranch by id \n 5:getbranch");
			System.out.println("enter your choice");
			int choice2=scanner.nextInt();
			switch(choice2){
			case 1:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the ifsc");
				String ifsc=scanner.next();
				System.out.println("enter the address");
				String address=scanner.next();
				System.out.println("enter the manager");
				String manager=scanner.next();
				System.out.println("enter the phone");
				long phone=scanner.nextLong();
				System.out.println("enter the bank id");
				int bankId=scanner.nextInt();
				bank.setId(bankId);
				Bank bank1=branch.getBank();
				EntityManager entityManager=dao1.getEntityManager();
				branch.setId(id);
				branch.setIfsc(ifsc);
				branch.setName(name);
				branch.setAddress(address);
				branch.setPhone(phone);
				branch.setManager(manager);
				branch.setBank(bank1);
				
				dao1.saveBranch(branch, bank);
				System.out.println("saved successfully");
				}break;
			case 2:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the ifsc");
				String ifsc=scanner.next();
				System.out.println("enter the address");
				String address=scanner.next();
				System.out.println("enter the manager");
				String manager=scanner.next();
				System.out.println("enter the phone");
				long phone=scanner.nextLong();
				branch.setId(id);
				branch.setName(name);
				branch.setAddress(address);
				branch.setIfsc(ifsc);
				branch.setPhone(phone);
				branch.setManager(manager);
				
				dao1.updateBranch(id, branch);
				System.out.println("updated successfully");
			}
			break;
			case 3:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				EntityManager entityManager=dao.getEntityManager();
				branch.setId(id);
				dao1.deleteBranch(id);
				System.out.println("deleted successfully");
			}
			break;
			case 4:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				EntityManager entityManager=dao.getEntityManager();
				branch.setId(id);
				Branch branch1=dao1.getBranchById(id);
				System.out.println(branch1);
				System.out.println("displayed");
			}
			break;
			case 5:{
				EntityManager entityManager=dao.getEntityManager();
				List<Branch>list1=dao1.getBranch();
				System.out.println(list1);
				System.out.println("displayed");
			}
			break;
			default:{
				System.out.println("thank you");
			}
			}
		}
		}
		
	}while(repeat);
}
}
