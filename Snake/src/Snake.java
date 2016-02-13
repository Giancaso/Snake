import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;

public class Snake {

	protected Shell shlSnake;
	
	private final int Cx = 500;
	private final int Cy = 400;
	
	private Serpente snake = new Serpente();

	/**
	 * Launch the application.
	 * @param args
	 */
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSnake = new Shell();
		shlSnake.setSize(735, 459);
		shlSnake.setText("Snake");
		
		Canvas canvas = new Canvas(shlSnake, SWT.BORDER);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setBounds(10, 10, 500, 400);
		
		Button btnStart = new Button(shlSnake, SWT.NONE);
		btnStart.setBounds(582, 10, 60, 25);
		btnStart.setText("START");
		
		Button btnSu = new Button(shlSnake, SWT.NONE);
		btnSu.setBounds(582, 285, 60, 60);
		btnSu.setText("^");
		
		Button btnSx = new Button(shlSnake, SWT.NONE);
		btnSx.setText("<");
		btnSx.setBounds(516, 351, 60, 60);
		
		Button btnGiu = new Button(shlSnake, SWT.NONE);
		btnGiu.setText("v");
		btnGiu.setBounds(582, 351, 60, 60);
		
		Button btnDx = new Button(shlSnake, SWT.NONE);
		btnDx.setText(">");
		btnDx.setBounds(649, 350, 60, 60);
	}
}
