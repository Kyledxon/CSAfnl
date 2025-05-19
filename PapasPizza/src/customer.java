import java.util.ArrayList;

public class customer {
		private String name;
		private int xPos = 500;
		private int yPos = 500;
		
		public customer(int posX, int posY, String nm) {
			posX = xPos;
			posY = yPos;
			name = nm;
		}
		
		private static String order() {
			ArrayList<String> orders = new ArrayList<String>();
			
			return "";
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
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
