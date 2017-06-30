import java.time.LocalDate;
import java.util.Date;

public class ToDoItem {
	private String item;
	private boolean done;
	private LocalDate timeStamp;
	public ToDoItem(String item) {
		super();
		this.item = item;
		this.timeStamp = LocalDate.now();
		this.timeStamp.plusDays(2);
		this.done=false;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}

	public String getItem() {
		return item;
	}
	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void addDays(int days){
		this.timeStamp.plusDays(days);
	}

	public void removeDays(int days){
		this.timeStamp.minusDays(days);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoItem other = (ToDoItem) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	//@Override
	//public String toString() {
	//		// TODO Auto-generated method stub
	//		return "Task "+this.item+" DueDate "+this.timeStamp+" done? "+this.done;
	//	}

	public void printToDoObject(){
		System.out.println("Task "+this.item+" DueDate "+this.timeStamp+" done? "+this.done);

	}
}
