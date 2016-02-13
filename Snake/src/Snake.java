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


	protected void createContents() {
		shlSnake = new Shell();
		shlSnake.setSize(735, 459);
		shlSnake.setText("Snake");
		
		Canvas canvas = new Canvas(shlSnake, SWT.BORDER);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setBounds(10, 10, Cx, Cy);
	}
}
