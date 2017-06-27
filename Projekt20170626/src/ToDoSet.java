import java.util.List;
import java.util.ListIterator;

public class ToDoSet {
private List<ToDoItem> notDone;
private List<ToDoItem> done;
private ListIterator<ToDoItem> traverseList; 
public ToDoSet() {
	super();
	// TODO Auto-generated constructor stub
	
}
public void addToDoItem(ToDoItem stuff){
	this.notDone.add(stuff);
}
public void printAllObjects(){

//	notDone.forEach(notDone->{printToDoObject();});
	List<ToDoItem> temp=notDone;
	
//	while (traverseList){
//	}
}
}
