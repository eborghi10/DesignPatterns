CoffeeMachineInterface.java

public interface CoffeeMachineInterface {
	public void chooseFirstSelection();
	public void chooseSecondSelection();
}


OldCoffeeMachine.java

public class OldCoffeeMachine {

public void selectA() {
	System.out.println("Flavour A selected");
}

public void selectB() {
	System.out.println("Flavour B selected");
}

}


CoffeeTouchscreenAdapter.java

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

private OldCoffeeMachine OldVendingMachine;

public CoffeeTouchscreenAdapter() {
	if (OldVendingMachine == null) {
		OldVendingMachine = new OldCoffeeMachine();	
	}
}

public void chooseFirstSelection() {
	OldVendingMachine.selectA();
}

public void chooseSecondSelection() {
	OldVendingMachine.selectB();
}

}
