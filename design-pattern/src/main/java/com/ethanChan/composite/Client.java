package com.ethanChan.composite;

public class Client {

	public static void main(String[] args) {

		OrganizationComponent university = new University("清华大学", "中国顶级大学 ");

		OrganizationComponent computerCollege = new College("计算机", "计算机");
		OrganizationComponent infoEngineercollege = new College("信息工程", "信息工程");


		computerCollege.add(new Department("软件工程", "软件工程"));
		computerCollege.add(new Department("网络工程", "网络工程"));
		computerCollege.add(new Department("计算机", "计算机"));

		infoEngineercollege.add(new Department("ͨ通信", "ͨ通信"));

		university.add(computerCollege);
		university.add(infoEngineercollege);

		infoEngineercollege.print();
	}

}
