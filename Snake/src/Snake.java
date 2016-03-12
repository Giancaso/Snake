import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;

public class Snake {

	protected Shell shlSnake;

	private final int Cx = 500;
	private final int Cy = 400;
	private Serpente snake;
	Cubo mela;
	GC gc;
	//private int move = 0;
	String move;
	Button btnSu;
	Button btnDx;
	Button btnSx;
	Button btnGiu;
	
	Random random = new Random();

	Canvas canvas;
	
	public int casual(int valore){
		int n = random.nextInt(valore);;
		while(n % 5 != 0){
			n = random.nextInt(valore);
		}
		return n;
	}

	public void clean() {
		for (int i = 0; i < snake.getElementi(); i++) {
			gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			gc.drawRectangle(snake.getCdaP(i).getX(), snake.getCdaP(i).getY(), snake.getCdaP(i).getL(),
					snake.getCdaP(i).getL());
		}
	}

	public void disegna() {
		for (int i = 0; i < snake.getElementi(); i++) {
			gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			gc.drawRectangle(snake.getCdaP(i).getX(), snake.getCdaP(i).getY(), snake.getCdaP(i).getL(),
					snake.getCdaP(i).getL());
		}

	}

	public static void main(String[] args) {
		try {
			Snake window = new Snake();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSnake.open();
		shlSnake.layout();
		while (!shlSnake.isDisposed()) {
			if (!display.readAndDispatch()) {
				clean();
				snake.muovi(move);
				System.out.println(snake.getCdaP(0));
				disegna();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				//display.sleep();
			}
		}
	}

	protected void createContents() {
		shlSnake = new Shell();
		shlSnake.addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				snake = new Serpente();
				snake.aggiungi(new Cubo());
				move="su";
				mela = new Cubo(casual(Cx-50), casual(Cy-50), 5);
				System.out.println(mela);
			}
		});
		shlSnake.setSize(735, 459);
		shlSnake.setText("Snake");

		canvas = new Canvas(shlSnake, SWT.BORDER);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				gc.drawRectangle(Cx / 2, Cy / 2, snake.getCdaP(0).getL(), snake.getCdaP(0).getL());
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				gc.fillRectangle(mela.getX(), mela.getY(), mela.getL(), mela.getL());
			}
		});
		
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setBounds(10, 10, Cx, Cy);

		gc = new GC(canvas);

		btnSu = new Button(shlSnake, SWT.NONE);
		btnSu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				move = "su";
				/*
				move = 1;
				while (snake.getCdaP(0).getY() > 5) {
					// System.out.println(snake.getCdaP(0).toString());
					System.out.println(move);
					clean();
					snake.muovi("su");
					disegna();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				//snake.aggiungi(new Cubo(snake.getCdaP(0).getX(), snake.getCdaP(0).getY() + snake.getCdaP(0).getL(), snake.getCdaP(0).getL()));
				//disegna();
				
				*/
			}
		});
		btnSu.setBounds(582, 285, 60, 60);
		btnSu.setText("^");

		btnDx = new Button(shlSnake, SWT.NONE);
		btnDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				move="dx";
				/*move = 2;
				while (snake.getCdaP(0).getX() < Cx - 10) {
					// System.out.println(snake.getCdaP(0).toString());
					System.out.println(move);
					clean();
					snake.muovi("dx");
					disegna();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}*/
			}
		});
		btnDx.setText(">");
		btnDx.setBounds(649, 350, 60, 60);

		btnGiu = new Button(shlSnake, SWT.NONE);
		btnGiu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				move="giu";
				/*
				move = 3;
				while (snake.getCdaP(0).getY() < Cy - 10) {
					// System.out.println(snake.getCdaP(0).toString());
					System.out.println(move);
					clean();
					snake.muovi("giu");
					disegna();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				*/
			}
		});
		btnGiu.setText("v");
		btnGiu.setBounds(582, 351, 60, 60);

		btnSx = new Button(shlSnake, SWT.NONE);
		btnSx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				move="sx";
				/*move = 4;
				while (snake.getCdaP(0).getX() > 5) {
					// System.out.println(snake.getCdaP(0).toString());
					System.out.println(move);
					clean();
					snake.muovi("sx");
					disegna();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}*/
			}
		});
		btnSx.setText("<");
		btnSx.setBounds(516, 351, 60, 60);
	}
}
