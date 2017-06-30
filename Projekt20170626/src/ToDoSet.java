import java.util.LinkedList;
import java.util.ListIterator;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class ToDoSet {
	private LinkedList<ToDoItem> notDone;
	private LinkedList<ToDoItem> done;
	//private ListIterator<ToDoItem> traverseList; 
	public ToDoSet() {
		super();
		// TODO Auto-generated constructor stub
		this.notDone= new LinkedList<ToDoItem>();
		this.done=new LinkedList<ToDoItem>();
	}
	public void addToDoItem(ToDoItem stuff){
		this.notDone.add(stuff);
	}

	public LinkedList<ToDoItem> getDone() {
		return done;
	}
	public LinkedList<ToDoItem> getNotDone() {
		return notDone;
	}
	private boolean whileLoopTest(LinkedList<ToDoItem> tempList, String otherItem){
		if (tempList.isEmpty()){
			return false;
		}else{
			return !otherItem.equals(tempList.get(0).getItem());
		}
	}

	public ToDoItem findToDoItem(String otherItem, LinkedList<ToDoItem> searchList) {
		LinkedList<ToDoItem> tempList=searchList;
		while(whileLoopTest(tempList, otherItem)){
			tempList.remove(0);
		}
		if(tempList.isEmpty()) {
			return null;
		}
		else{
			return tempList.get(0);
		}
	}

	public void setItemToDone(String text){
		ToDoItem foundIt=findToDoItem(text,this.notDone);
		if (foundIt!=null){
			foundIt.setDone(true);
			done.add(foundIt);
			foundIt.setDone(false);
			notDone.remove(foundIt);
		}
	}

	public void setItemToNotDone(String text){
		ToDoItem foundIt=findToDoItem(text,this.done);
		if (foundIt!=null){
			foundIt.setDone(false);
			notDone.add(foundIt);
			foundIt.setDone(true);
			done.remove(foundIt);
		}
	}

	public void removeToDoItem(String text){
		ToDoItem object=findToDoItem(text,this.notDone);
		if (object!=null){
			this.notDone.remove(object);
		}else{
			object=findToDoItem(text,this.done);
			this.done.remove(object);	
		}
	}

	public void removeAllDoneTodoItems(){
		this.done.clear();
	}

	public ToDoItem findToDoItem(String key){
		ToDoItem temp;
		temp = findToDoItem(key, this.notDone);
		if (temp==null){
			temp=findToDoItem(key, this.done);
		}
		return temp;
	}

	public void setItemToDoneStatus(String itemText, boolean newStatus){
		ToDoItem foundIt;
		if (newStatus){
			setItemToDone(itemText);
		}else{
			foundIt=findToDoItem(itemText,this.done);
			if (foundIt!=null){
				foundIt.setDone(false);
				notDone.add(foundIt);
				foundIt.setDone(true);
				done.remove(foundIt);
			}	
		}
	}

	public void setItemToNotDoneStatus(String itemText, boolean newStatus){
		ToDoItem foundIt;
		if (newStatus){
			setItemToDone(itemText);
		}else{
			foundIt=findToDoItem(itemText,this.done);
			if (foundIt!=null){
				foundIt.setDone(false);
				notDone.add(foundIt);
				foundIt.setDone(true);
				done.remove(foundIt);
			}	
		}
	}


	public void printAllObjects(){

		//	for(ToDoItem x : notDone){
		//		x.printToDoObject();
		//	}

		for(ToDoItem x : notDone){
			x.printToDoObject();
		}

		for(ToDoItem x : done){
			x.printToDoObject();
		}


		//	List<ToDoItem> temp=notDone;

		//	while (traverseList){
		//	}
	}
	
//public void storeToFile(){
//	LinkedList<ToDoItem>[] allDataArray = new LinkedList[2];
//	allDataArray[0]=notDone;
//	allDataArray[1]=done;
//    // Using XmlIO to save an object to file, errors are unexpected (write protected files)
//    try {
//        XMLIO.saveObject("todolist.xml", allDataArray);
//    } catch (IOException ex) {
//        Logger.getLogger(Todo.class.getName()).log(Level.SEVERE, null, ex);
//    }
//}
}
