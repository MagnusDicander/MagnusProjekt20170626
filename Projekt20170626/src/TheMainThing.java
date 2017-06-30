import java.util.Scanner;
public class TheMainThing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToDoSet thingsToDo = new ToDoSet();		
		String task1,task2;
		ToDoItem toDoObject1,toDoObject2;
		boolean newStatus;
		task1="Test";
		toDoObject1=new ToDoItem(task1);
		thingsToDo.addToDoItem(toDoObject1);
		task2="Test";
		toDoObject2=new ToDoItem(task2);
		thingsToDo.addToDoItem(toDoObject2);
		thingsToDo.printAllObjects();
		Boolean same=toDoObject1.equals(toDoObject2);
		System.out.println(same);
		System.out.println(null==null);

		String moreComputing="Yes";
		String inputText;
		int days;
		Scanner keyboard = new Scanner(System.in);
		while (moreComputing.equals("Yes")){
			System.out.println("Enter a command string (add/printall/itemdone/removeone/removealldone/"
					+ "printoneitem/adddays/removedays/changestatus/setnotdone");
			inputText = keyboard.next();
			System.out.println("You wrote "+inputText);
			switch (inputText){
			case "add":System.out.println("Name the ToDOItem ");
			inputText = keyboard.next();
			System.out.println("How many days from now should it be done? ");
			try{
				days=Integer.parseInt(keyboard.next());
				toDoObject1=new ToDoItem(inputText);
				toDoObject1.removeDays(2);
				toDoObject1.addDays(days);
				thingsToDo.addToDoItem(toDoObject1);
			} catch (NumberFormatException ignore){
				System.out.println("Wrong format. You should have used digits. ");	
			}
			break;
			case "printall":thingsToDo.printAllObjects();
			break;
			case "itemdone":System.out.println("You wrote "+inputText);
			System.out.println("Name the ToDOItem ");
			inputText = keyboard.next();
			thingsToDo.setItemToDone(inputText);
			break;
			case "removeone":System.out.println("Name the ToDOItem ");
			inputText = keyboard.next();
			thingsToDo.removeToDoItem(inputText);
			break;
			case "removealldone":thingsToDo.removeAllDoneTodoItems();
			break;
			case "printoneitem":System.out.println("Name the ToDOItem ");
			inputText = keyboard.next();
			toDoObject1=thingsToDo.findToDoItem(inputText);
			if (toDoObject1==null){
				System.out.println("That ToDoItem does not exist ");
			}else{
				toDoObject1.printToDoObject();	
			}
			break;
			case "adddays":System.out.println("Name the ToDOItem ");
			inputText = keyboard.next();
			System.out.println("Add how many days? ");
			days=Integer.parseInt(keyboard.next());
			toDoObject1=thingsToDo.findToDoItem(inputText,thingsToDo.getNotDone());
			if (toDoObject1==null){
				System.out.println("That ToDoItem does not exist ");
			}else{
				toDoObject1.addDays(days);	
			}
			break;
			case "removedays":System.out.println("Name the ToDOItem ");
			inputText = keyboard.next();
			System.out.println("Remove how many days? ");
			days=Integer.parseInt(keyboard.next());
			toDoObject1=thingsToDo.findToDoItem(inputText,thingsToDo.getNotDone());
			if (toDoObject1==null){
				System.out.println("That ToDoItem does not exist ");
			}else{
				toDoObject1.removeDays(days);	
			}
			break;
			case "changestatus":System.out.println("Name the ToDOItem ");
			inputText = keyboard.next();
			System.out.println("Is the ToDoItem done (true/fale)?  ");
			newStatus=Boolean.parseBoolean(keyboard.next());
			if (newStatus){
				thingsToDo.setItemToDone(inputText);
			}else{
				thingsToDo.setItemToNotDone(inputText);	
			}
			break;
			case "setnotdone":System.out.println("Name the ToDOItem ");
			inputText = keyboard.next();
			thingsToDo.setItemToNotDone(inputText);	
			break;
			}
			System.out.println("More computing (Yes/No)?");
			moreComputing = keyboard.next();
			System.out.println("You wrote "+moreComputing);

			//if ()
		}
		keyboard.close();

	}

}
