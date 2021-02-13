/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.shape.Line;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * The Class SampleController.
 * @brief Handling of fxml file.
 */
public class SampleController {
	
	/** The content. */
	@FXML
	private Pane content;
	
	/** The slider. */
	@FXML
	private Slider slider;
	
	/** The updates. */
	//Label timeLabel = new Label();
	private List<tUpdate> updates = new ArrayList<>();
	
	/** The timer. */
	private Timer timer;
	
	/** The time. */
	private LocalTime time = LocalTime.parse("08:00:00");
	
	/** The elements. */
	private List<Draw> elements;
	
	/** The flag. */
	public int flag = 0;
	
	/** The orig X. */
	double origX;
	
	/** The orig Y. */
	double origY;
	
	/** The l1. */
	private int L1 = 0;
	
	/** The l2. */
	private int L2 = 0;
	
	/** The l3. */
	private int L3 = 0;
	
	/** The l4. */
	private int L4 = 0;
	
	/** The path set. */
	private int path_set=0;
	
	/** The pathmap. */
	private PathMap pathmap;
	
	/** The streetmap. */
	private StreetMap streetmap;
	
	/** The line array. */
	private Line[] lineArray;
	
	/** The skip. */
	private int skip = 0;
	
	/** The timeskip. */
	boolean timeskip = false;
	
	/**
	 * On zoom.
	 * @brief What should happen during zooming.
	 * @param event the event
	 */
	@FXML
	private void onZoom(ScrollEvent event) {
		if (flag == 0) {
			origX = content.getScaleX();
			origY =content.getScaleY();
			flag = 1;
		}
		event.consume();
		double zoom = event.getDeltaY() > 0 ? 1.1 : 0.9;
		if ((content.getScaleX()*zoom <= origX) || (content.getScaleY()*zoom <= origY)) return;
		content.setScaleX(zoom * content.getScaleX());
		content.setScaleY(zoom * content.getScaleY());
	}
	
	/**
	 * @brief Changes value of scale using gui slider.
	 */
	@FXML
	private void onSlide() {
		double scale = slider.getValue();
		timer.cancel();
		TimerStart((float)scale);
	}
	
	/**
	 * @brief Sets the maps.
	 * @param pMap the path map
	 * @param sMap the street map
	 */
	public void setMaps (PathMap pMap,StreetMap sMap) {
		this.pathmap = pMap;
		this.streetmap = sMap;
	}
	
	/**
	 * @brief Sets the elements that are supposed to be drawn.
	 * @param elements the new elements
	 */
	public void setElements(List<Draw> elements) {
		this.elements = elements;
		for (Draw drawable : elements) {
			content.getChildren().addAll(drawable.getGUI());
			if(drawable instanceof tUpdate) updates.add((tUpdate)drawable);	
		}
	}
	
	/**
	 * Sets the lines.
	 * @brief Adds lines to streets which represent them.
	 */
	public void setLines() {
		for (Street street: this.streetmap.getStreets()) {
			for (int i = 0; i < this.lineArray.length; i++) {
				if ((street.begin().getX() == this.lineArray[i].getStartX() &&
					street.begin().getY() == this.lineArray[i].getStartY() &&
					street.end().getX() == this.lineArray[i].getEndX() &&
					street.end().getY() == this.lineArray[i].getEndY()) || 
					(street.begin().getX() == this.lineArray[i].getEndX() &&
					street.begin().getY() == this.lineArray[i].getEndY() &&
					street.end().getX() == this.lineArray[i].getStartX() &&
					street.end().getY() == this.lineArray[i].getStartY())) {
					street.setLine(this.lineArray[i]);
					break;
				}
		    }
		}
	}

	/** The line 1. */
	@FXML
    Line line1;
	
	/** The line 2. */
	@FXML
	Line line2;
	
	/** The line 3. */
	@FXML
	Line line3;
	
	/** The line 4. */
	@FXML
	Line line4;
	
	/** The line 5. */
	@FXML
	Line line5;
	
	/** The line 6. */
	@FXML
	Line line6;
	
	/** The line 7. */
	@FXML
    Line line7;
	
	/** The line 8. */
	@FXML
	Line line8;
	
	/** The line 9. */
	@FXML
	Line line9;
	
	/** The line 10. */
	@FXML
	Line line10;
	
	/** The line 11. */
	@FXML
	Line line11;
	
	/** The line 12. */
	@FXML
	Line line12;
	
	/** The line 13. */
	@FXML
	Line line13;
	
	/** The line 14. */
	@FXML
	Line line14;
	
	/** The line 15. */
	@FXML
	Line line15;
	
	/** The line 16. */
	@FXML
	Line line16;
	
	/** The line 17. */
	@FXML
	Line line17;
	
	/** The line 18. */
	@FXML
	Line line18;
	
	/** The line 19. */
	@FXML
	Line line19;
	
	/** The line 20. */
	@FXML
	Line line20;
	
	/** The line 21. */
	@FXML
	Line line21;
	
	/** The line 22. */
	@FXML
	Line line22;
	
	/** The line 23. */
	@FXML
	Line line23;
	
	/** The line 24. */
	@FXML
	Line line24;
	
	/** The line 25. */
	@FXML
	Line line25;
	
	/** The line 26. */
	@FXML
	Line line26;
	
	/** The label 2. */
	@FXML
	Label label2;
	
	/**
	 * Adds the lines to list.
	 */
	void addLinesToList() {
		this.lineArray = new Line[] { line1, line2, line3, line4, line5, line6, line7, line8, line9, line10,
				line11, line12, line13, line14, line15, line16, line17, line18, line19,
				line20, line21, line22, line23, line24, line25, line26};
	}
	
	/**
	 * Highlight PathA on click.
	 * @brief PathA highlighting.
	 */
	@FXML
	private void onPathA() {
		onClear();
		for (int i=0; i<6; i++) {
			lineArray[i].setStroke(Color.rgb(162,160,160));
			lineArray[i].setStrokeWidth(5);	
		}	
		path_set=1;
		Double time = this.pathmap.getPath("PathA").getTimetable();
		label2.setText("  Stop1: "+(LocalTime.parse( "08:02:34" ).plus((long) (time*L1),ChronoUnit.SECONDS)).toString()
				+      "\n\n  Stop2: "+(LocalTime.parse( "08:05:14" ).plus((long) (time*L1),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop3: "+(LocalTime.parse( "08:05:59" ).plus((long) (time*L1),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop4: "+(LocalTime.parse( "08:10:04" ).plus((long) (time*L1),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop5: "+(LocalTime.parse( "08:12:24" ).plus((long) (time*L1),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop6: "+(LocalTime.parse( "08:15:28" ).plus((long) (time*L1),ChronoUnit.SECONDS)).toString());
	}
	
	/**
	 * Highlight PathB on click.
	 * @brief PathB highlighting.
	 */
	@FXML
	private void onPathB() {
		onClear();
		for (int i=6; i<15; i++) {
			lineArray[i].setStroke(Color.rgb(162,160,160));
			lineArray[i].setStrokeWidth(5);	
		}	
		path_set=3;
		Double time = this.pathmap.getPath("PathB").getTimetable();
		label2.setText("  Stop1: "+(LocalTime.parse( "08:00:59" ).plus((long) (time*L3),ChronoUnit.SECONDS)).toString()
				+      "\n\n  Stop2: "+(LocalTime.parse( "08:02:29" ).plus((long) (time*L3),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop3: "+(LocalTime.parse( "08:04:08" ).plus((long) (time*L3),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop4: "+(LocalTime.parse( "08:06:24" ).plus((long) (time*L3),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop5: "+(LocalTime.parse( "08:07:53" ).plus((long) (time*L3),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop6: "+(LocalTime.parse( "08:09:55" ).plus((long) (time*L3),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop6: "+(LocalTime.parse( "08:11:26" ).plus((long) (time*L3),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop6: "+(LocalTime.parse( "08:12:34" ).plus((long) (time*L3),ChronoUnit.SECONDS)).toString());
	}
	
	/**
	 * Highlight PathC on click.
	 * @brief PathC highlighting.
	 */
	@FXML
	private void onPathC() {
		onClear();
		for (int i=15; i<20; i++) {
			lineArray[i].setStroke(Color.rgb(162,160,160));
			lineArray[i].setStrokeWidth(5);	
		}	
		path_set=2;
		Double time = this.pathmap.getPath("PathC").getTimetable();
		label2.setText("  Stop1: "+(LocalTime.parse( "08:00:42" ).plus((long) (time*L2),ChronoUnit.SECONDS)).toString()
				+      "\n\n  Stop2: "+(LocalTime.parse( "08:01:22" ).plus((long) (time*L2),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop3: "+(LocalTime.parse( "08:03:22" ).plus((long) (time*L2),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop4: "+(LocalTime.parse( "08:05:36" ).plus((long) (time*L2),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop5: "+(LocalTime.parse( "08:06:20" ).plus((long) (time*L2),ChronoUnit.SECONDS)).toString());
	}
	
	/**
	 * Highlight PathD on click.
	 * @brief PathD highlighting.
	 */
	@FXML
	private void onPathD()
	{
		onClear();
		for (int i=20;i<26;i++)
		{
			lineArray[i].setStroke(Color.rgb(162,160,160));
			lineArray[i].setStrokeWidth(5);	
		}
		path_set=4;
		Double time = this.pathmap.getPath("PathD").getTimetable();
		label2.setText("  Stop1: "+(LocalTime.parse( "08:00:29" ).plus((long) (time*L4),ChronoUnit.SECONDS)).toString()
				+      "\n\n  Stop2: "+(LocalTime.parse( "08:02:27" ).plus((long) (time*L4),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop3: "+(LocalTime.parse( "08:04:05" ).plus((long) (time*L4),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop4: "+(LocalTime.parse( "08:06:10" ).plus((long) (time*L4),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop5: "+(LocalTime.parse( "08:06:45" ).plus((long) (time*L4),ChronoUnit.SECONDS)).toString()
				+ 	   "\n\n  Stop6: "+(LocalTime.parse( "08:07:34" ).plus((long) (time*L4),ChronoUnit.SECONDS)).toString());
	}
		
		/**
		 * Path clear
		 * @brief Clears previously highlighted Path.
		 */
		@FXML
	    private void onClear() {        
	        Iterator<Street> itr = this.streetmap.getStreets().iterator();
	        while (itr.hasNext()) {
	            Street street = itr.next();
	            Line line = street.getLine();
	            if (line != null) {
	                line.setStroke(Color.rgb(79, 78, 78));
	                line.setStrokeWidth(3);
	            }
	        }
	        label2.setText("");
	        path_set=0;
	    }
		
	/**
	 * Timer reset
	 * @brief Resets previously set timer.
	 */
	public void resetTimer() {
		timer.cancel();
		TimerStart(1); // TODO
	}
	
	/** The stop sign. */
	long stop_sign=1;
	
	@FXML
	Label timeLabel;
	
	/**
	 * Timer start.
	 * @param scale used to increase timer speed
	 */
	public void TimerStart(float scale)
	{
		timer = new Timer(false);
		timer.scheduleAtFixedRate(new TimerTask() 		
		{
			@Override
			public void run() {
				time = time.plusSeconds((long) (1));
				if (skip == 0) {
					for (tUpdate update : updates) {
						Platform.runLater(()-> {
						update.update(time);	
						if(time.equals((LocalTime.parse( "08:15:28" ).plus(974*L1,ChronoUnit.SECONDS)))) {
							L1++;
							if (path_set==1) onPathA();
						}
						if(time.equals((LocalTime.parse( "08:06:20" ).plus(442*L2,ChronoUnit.SECONDS)))) {
							L2++;
							if (path_set==2) onPathC();
						}
						if(time.equals((LocalTime.parse( "08:12:34" ).plus(814*L3,ChronoUnit.SECONDS)))) {
							L3++;
							if (path_set==3) onPathB();
						} 
						if(time.equals((LocalTime.parse( "08:07:34" ).plus(548*L4,ChronoUnit.SECONDS)))) {	
							L4++;
							if (path_set==4) onPathD();
						}
						if(time.getSecond()==0) timeLabel.setText(time.toString()+":00"); // aby zobrazovalo :00 na konci ked su sekundy NULL;
						else timeLabel.setText(time.toString());
						});
					}
				}
					
			}
			
			
		},0,(long)(1000/scale)); // zrychlenie �asu
		
	}
	
	
}
