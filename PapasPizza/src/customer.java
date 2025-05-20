import java.util.ArrayList;

import javax.swing.ImageIcon;

public class customer {
		
		ArrayList<String> ordered;
		private String order;
		private String name;
		private int xPos = 800;
		private int yPos = 600;
		
		public customer(int posX, int posY, String nm, String ord) {
			ordered = new ArrayList<String>();
			posX = xPos;
			posY = yPos;
			name = nm;
			order = ord;
		}
		
		private void addOrder() {
			ordered.add(order);
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}
		
		public String getOrder() {
			return order;
		}

		public int getxPos() {
			return xPos;
		}


		public void setxPos(int xPos) {
			this.xPos = xPos;
		}


		public int getyPos() {
			return yPos;
		}


		public void setyPos(int yPos) {
			this.yPos = yPos;
		}
		
		
}
