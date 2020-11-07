package at.ias.mvc;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Model model = new Model();
					
					View1 view1 = new View1(model);
					View2 view2 = new View2(model);
					model.addObserver(view1);
					model.addObserver(view2);
					view1.setVisible(true);
					view2.setVisible(true);
					Controller controller = new Controller(model);
					controller.setVisible(true);
					
			
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
