import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
	JLabel countLabel;
	JTextField counterTxt;
	JButton startButton;
	JButton pauseButton;
	public static Boolean stop = false;

	static int countValue;

	public MainPanel() {
		countLabel = new JLabel("Counter");
		counterTxt = new JTextField(20);
		startButton = new JButton("Start");
		pauseButton = new JButton("Pause");
		this.add(countLabel, BorderLayout.NORTH);
		this.add(counterTxt, BorderLayout.CENTER);
		this.add(startButton, BorderLayout.SOUTH);
		this.add(pauseButton, BorderLayout.SOUTH);

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				stop = false;
			//	MyThread myThread = new MyThread(counterTxt);
			//	Thread thread = new Thread(myThread);
				Thread thread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						for (int i = 0; i <= 10000; i++) {
							if (MainPanel.stop)
								break;
							counterTxt.setText(MainPanel.countValue + "");
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							MainPanel.countValue++;
						}
						
					}
				});
				
				thread.start();
			}
		});

		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				stop = true;

			}
		});
	}

}

// class MyThread extends Thread {
//
// int countValue;
// JTextField counterText;
//
// MyThread( int counterValue, JTextField counterText) {
//
// this.counterText=counterText;
// this.countValue=counterValue;
// }
//
// @Override
// public void run() {
//
// for (int i = 0; i <= 10000; i++) {
// if (MainPanel.stop)
// break;
// counterText.setText(countValue + "");
// try {
// Thread.sleep(100);
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// countValue++;
// }
// }
// }

//class MyThread implements Runnable {
//	JTextField counterText;
//
//	MyThread(JTextField counterText) {
//		this.counterText = counterText;
//	}
//
//	@Override
//	public void run() {
//		for (int i = 0; i <= 10000; i++) {
//			if (MainPanel.stop)
//				break;
//			counterText.setText(MainPanel.countValue + "");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			MainPanel.countValue++;
//		}
//
//	}
//
//}
