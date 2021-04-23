package dmacc.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/**
 * 
 * @author Tyler Maschoff
 *
 */
@Entity
@Table(name="footballrosters")
@Data
@NoArgsConstructor
public class Roster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String position;
	private String age;
	private String team;
	
	public Roster() {
		super();
	}
	
	public Roster(String name, String position, String age, String team) {
		this.name = name;
		this.position = position;
		this.age = age;
		this.team = team;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Roster [id=" + id + ", name=" + name + ", position=" + position + ", age=" + age + ", team=" + team
				+ "]";
	}
	

}
