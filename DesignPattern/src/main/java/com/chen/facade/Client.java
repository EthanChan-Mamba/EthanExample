package com.chen.facade;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
		homeTheaterFacade.ready();
		homeTheaterFacade.play();

		homeTheaterFacade.end();
	}

}
