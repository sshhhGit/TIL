package com.spring.hello2;

public class Computer {
	//필드
	private String name;
	private String cpu;
	private String memory;
	private String disk;
	
	//생성자 
	public Computer(String name){
		this.name=name;
	}

	//name를 제외 하고 , getter/setter
	
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getDisk() {
		return disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}
	
	//기타메서드 
	public String getContents(){
		return name+"["+cpu+"CPU, "+memory+" MEM, "+disk+" HDD]";
	}
	
}// class-end
