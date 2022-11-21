package demoFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

class ObjectReadWriteStream {

	public void writeTeam(Object obj) throws IOException {

		// (2) now lets write this team into the file
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("F:/_filesExercise/chicago.dat")));
			out.writeObject(obj);
		} finally {
			if (out != null)
				out.close();
		}

	}

	public BasketBallTeam readTeam() throws IOException, ClassNotFoundException {

		// lets read the team from the file
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("F:/_filesExercise/chicago.dat")));
			BasketBallTeam result = (BasketBallTeam) in.readObject();
			return result;
		} finally {
			if (in != null)
				in.close();
		}
	}

}

// this class will be written into the file 
// and afterwards be read from the file...
// (5) we must make it serializable

//into the one below with implementation. 
class BasketBallTeam implements Serializable {

	private static final long serialVersionUID = 6318583645366351675L;

	private long budget;
	private String name;
	private String[] listOfPlayers;

	public BasketBallTeam(long budget, String name, String[] listOfPlayers) {
		super();
		this.budget = budget;
		this.name = name;
		this.listOfPlayers = listOfPlayers;
	}

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(String[] listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	@Override
	public String toString() {
		return "BasketBallTeam [budget=" + budget + ", name=" + name + ", listOfPlayers="
				+ Arrays.toString(listOfPlayers) + "]";
	}

}

public class _11_Write_Read_Objects_to_from_file {

	public static void main(String[] args) {

		// (1) here we will create a team and write it into the file
		BasketBallTeam bulls = new BasketBallTeam(30_000_000, "Chicago bulls",
				new String[] { "MJ", "Karim", "Shaquil" });

		ObjectReadWriteStream rw = new ObjectReadWriteStream();

		// Write Object to a file
		try {
			rw.writeTeam(bulls);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Write Object from a file
		try {
			BasketBallTeam result = rw.readTeam();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
