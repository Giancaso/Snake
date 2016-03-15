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
	String move;
	Button btnSu;
	Button btnDx;
	Button btnSx;
	Button btnGiu;

	Random random = new Random();

	Canvas canvas;

	public int casual(int valore) {
		int n = random.nextInt(valore);
		while (n % 10 != 0) {
			n = 20 + random.nextInt(valore);
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
				disegna();
				try {
					Thread.sleep(150);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (snake.getCdaP(0).getX() == mela.getX() && snake.getCdaP(0).getY() == mela.getY()) {
					// System.out.println("bella");
					gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
					gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
					gc.fillRectangle(mela.getX(), mela.getY(), mela.getL(), mela.getL());

					if (move.equals("dx")) {
						snake.aggiungi(new Cubo(
								snake.getCdaP(snake.getElementi() - 1).getX()
										- snake.getCubo(snake.getElementi() - 1).getL(),
								snake.getCdaP(snake.getElementi() - 1).getY(),
								snake.getCdaP(snake.getElementi() - 1).getL()));
					}
					if (move.equals("sx")) {
						snake.aggiungi(new Cubo(
								snake.getCdaP(snake.getElementi() - 1).getX()
										+ snake.getCubo(snake.getElementi() - 1).getL(),
								snake.getCdaP(snake.getElementi() - 1).getY(),
								snake.getCdaP(snake.getElementi() - 1).getL()));
					}

					if (move.equals("su")) {
						snake.aggiungi(new Cubo(snake.getCdaP(snake.getElementi() - 1).getX(),
								snake.getCdaP(snake.getElementi() - 1).getY()
										+ snake.getCubo(snake.getElementi() - 1).getL(),
								snake.getCdaP(snake.getElementi() - 1).getL()));
					}

					if (move.equals("giu")) {
						snake.aggiungi(new Cubo(snake.getCdaP(snake.getElementi() - 1).getX(),
								snake.getCdaP(snake.getElementi() - 1).getY()
										- snake.getCubo(snake.getElementi() - 1).getL(),
								snake.getCdaP(snake.getElementi() - 1).getL()));
					}

					mela.setX(casual(Cx - 50));
					mela.setY(casual(Cy - 50));
					gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
					gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					gc.fillRectangle(mela.getX(), mela.getY(), mela.getL(), mela.getL());

				}
				// display.sleep();
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
				move = "su";
				mela = new Cubo(casual(Cx - 50), casual(Cy - 50), 10);
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
			}
		});
		btnSu.setBounds(582, 285, 60, 60);
		btnSu.setText("^");

		btnDx = new Button(shlSnake, SWT.NONE);
		btnDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				move = "dx";

			}
		});
		btnDx.setText(">");
		btnDx.setBounds(649, 350, 60, 60);

		btnGiu = new Button(shlSnake, SWT.NONE);
		btnGiu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				move = "giu";

			}
		});
		btnGiu.setText("v");
		btnGiu.setBounds(582, 351, 60, 60);

		btnSx = new Button(shlSnake, SWT.NONE);
		btnSx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				move = "sx";

			}
		});
		btnSx.setText("<");
		btnSx.setBounds(516, 351, 60, 60);
	}
}
