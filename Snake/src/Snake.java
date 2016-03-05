import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;

public class Snake {

	protected Shell shlSnake;

	private final int Cx = 500;
	private final int Cy = 400;
	private Serpente snake;
	GC gc;

	Canvas canvas;

	public void disegna() {
		for (int i = 0; i < snake.getElementi(); i++) {
			
			gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			gc.drawRectangle(snake.getCdaP(i).getX(), snake.getCdaP(i).getY(), snake.getCdaP(i).getL(),
					snake.getCdaP(i).getL());
			
			gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			gc.drawRectangle(snake.getCdaP(i).getX()-snake.getCdaP(i).getX(), snake.getCdaP(i).getY()-snake.getCdaP(i).getY(), snake.getCdaP(i).getL(),
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
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shlSnake = new Shell();
		shlSnake.setSize(735, 459);
		shlSnake.setText("Snake");

		canvas = new Canvas(shlSnake, SWT.BORDER);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		canvas.setBounds(0, 10, Cx, Cy);
		canvas.setBounds(10, 10, 500, 400);

		gc = new GC(canvas);

		Button btnStart = new Button(shlSnake, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				snake = new Serpente();
				snake.aggiungi(new Cubo());
				gc.drawRectangle(Cx / 2, Cy / 2, snake.getCdaP(0).getL(), snake.getCdaP(0).getL());
			}
		});
		btnStart.setBounds(582, 10, 60, 25);
		btnStart.setText("START");

		Button btnSu = new Button(shlSnake, SWT.NONE);
		btnSu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				while (snake.getCdaP(0).getY() > 5) {
					System.out.println(snake.getCdaP(0).toString());
					snake.muovi("su");
					disegna();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSu.setBounds(582, 285, 60, 60);
		btnSu.setText("^");

		Button btnSx = new Button(shlSnake, SWT.NONE);
		btnSx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				while (snake.getCdaP(0).getX() > 5) {
					System.out.println(snake.getCdaP(0).toString());
					snake.muovi("sx");
					disegna();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSx.setText("<");
		btnSx.setBounds(516, 351, 60, 60);

		Button btnGiu = new Button(shlSnake, SWT.NONE);
		btnGiu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				while (snake.getCdaP(0).getY() < Cy-10) {
					System.out.println(snake.getCdaP(0).toString());
					snake.muovi("giu");
					disegna();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnGiu.setText("v");
		btnGiu.setBounds(582, 351, 60, 60);

		Button btnDx = new Button(shlSnake, SWT.NONE);
		btnDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				while (snake.getCdaP(0).getX() < Cx-10) {
					System.out.println(snake.getCdaP(0).toString());
					snake.muovi("dx");
					disegna();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnDx.setText(">");
		btnDx.setBounds(649, 350, 60, 60);
	}
}
