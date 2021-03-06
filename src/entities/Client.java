package entities;

public class Client {
	
	private String name;
	private Integer id;
	
	public Client(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
		return name + " - ID: "  + id;
	}

}
