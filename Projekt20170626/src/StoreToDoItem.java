import java.time.LocalDate;
import java.util.Date;

public class StoreToDoItem {
	private String item;
	private boolean done;
	private String timeStamp;
	public StoreToDoItem(ToDoItem original) {
		super();
		this.item=original.getItem();
		this.done=original.isDone();
		this.timeStamp=original.getTimeStamp().toString();
		// TODO Auto-generated constructor stub
	}
	

}
