package gameplay;

import java.util.ArrayList;
import java.util.Random;


import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

class ColorBall{
	ArrayList<Circle> balls;
	
	ColorBall(Group root)
	{
		balls = new ArrayList<>();
		
		int x = 310;
		int y = 400;
		
		for(int i=0;i<10;i++) 
		{
			Random random = new Random();
			Circle circ = new Circle();
			int UserColor = random.nextInt(4)+1;
			int radius = 15;
			if (UserColor == 1) 
				{
					circ = new Circle(x,y , radius, Color.RED);
				}
			
			if (UserColor == 2) 
				{
					circ = new Circle(x,y , radius, Color.BLUE);
				}
			
			if (UserColor == 3) 
				{
					circ = new Circle(x,y , radius, Color.GREEN);
				}
			
			if (UserColor == 4)
				{
					circ = new Circle(x,y , radius, Color.YELLOW);
				}
			
			balls.add(circ);
			y -= 600;
		}

		root.getChildren().addAll(balls);		
	}
	
	public void name() 
	{	
	}
	
	public int detectCollision(User user) 
	{
		
		for(Circle ball: balls) 
		{
			Shape intersect = Shape.intersect(user.rectangle, ball);
			if (intersect.getBoundsInLocal().getWidth() != -1 && user.rectangle.getFill() != ball.getFill()) 
			{	
				int ballColor=0;
				
				if(ball.getFill() == Color.RED)
					{
						ballColor = 1;
					}
				else if(ball.getFill()==Color.BLUE)
					{
						ballColor=2;
					}
				
				else if (ball.getFill() == Color.GREEN)
				{
					ballColor = 3;
				}
				
				else if(ball.getFill()==Color.YELLOW)
					ballColor=4;
				ball.setFill(Color.TRANSPARENT);
				return ballColor;
			}
		}
		return 0;
	}
	public void update() {//Group root) {
		for(Circle i: balls) {
			TranslateTransition transition=new TranslateTransition();
	    	transition.setDuration(Duration.seconds(0.001));
	    	transition.setToY(i.getLayoutY()+1);
	    	i.setLayoutY(i.getLayoutY()+1);
	    	transition.setNode(i);
	    	transition.play();
		}
	}

	
}
