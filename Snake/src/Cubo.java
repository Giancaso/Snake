public class Cubo {

	private int x;
	private int y;
	private int l;

	public Cubo() {
		this.x = 250;
		this.y = 200;
		this.l = 3;
	}

	public Cubo(int x, int y, int l) {
		setX(x);
		setY(y);
		setL(l);
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public Cubo(Cubo p) {
		x = p.getX();
		y = p.getY();
		l = p.getL();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x >= 1 && x <= 500) {
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y >= 1 && y <= 400) {
			this.y = y;
		}

	}

	public String toString() {
		return "Punto: " + this.x + " " + this.y;

	}

	public double distanza() {
		double dis;
		dis = Math.sqrt((x * x) + (y * y));
		return dis;
	}

	public double distanza(Cubo p) {
		double dis;
		dis = Math.sqrt(((p.getX() - x) * (p.getX() - x)) + ((p.getY() - y) * (p.getY() - y)));
		return dis;
	}

	public Cubo sommaPunto(Cubo p) {
		Cubo p3 = new Cubo();
		p3.setX((x + p.getX()));
		p3.setY(y + p.getY());
		return p3;
	}

	public Cubo medio(Cubo p) {
		Cubo p3 = new Cubo();
		p3.setX(((x + p.getX()) / 2));
		p3.setY(((y + p.getY()) / 2));
		return p3;
	}
}
