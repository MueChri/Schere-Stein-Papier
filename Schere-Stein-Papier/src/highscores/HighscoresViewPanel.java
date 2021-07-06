package highscores;

import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import common.CenteredText;
import common.HomeButtonPanel;
import main.ViewPanel;

public class HighscoresViewPanel extends ViewPanel {

	private ArrayList<JLabel> nameColumn = new ArrayList<JLabel>();
	private ArrayList<JLabel> wonColumn = new ArrayList<JLabel>();
	private ArrayList<JLabel> drawColumn = new ArrayList<JLabel>();
	private ArrayList<JLabel> dateColumn = new ArrayList<JLabel>();

	private int currentPage = 1;
	private int numberOfPages = 0;
	private ArrayList<Highscore> highscores = new ArrayList<Highscore>();
	
	private ArrayList<ArrayList<Highscore>> loadedPages = new ArrayList<ArrayList<Highscore>>();
	
	private HighscoresManager manager = new HighscoresManager();
	
	private JLabel pageIndex;
	private JLabel previousPage;
	private JLabel nextPage;
	private JLabel loading;
	
	public HighscoresViewPanel() {		
		this.add(new HomeButtonPanel());

		this.addKeyListener(new HighscoresViewPanelKeyListener());

		JLabel title = new CenteredText("HIGHSCORES", 29, Font.BOLD);
		title.setBounds(0, 40, 370, 35);
		this.add(title);
		
		int rowPosY = 90;
		int rowHeight = 28;
		int nameColumnWidth = 120;
		int wonColumnWidth = 65;
		int drawColumnWidth = 65;
		int dateColumnWidth = 120;
		
		JLabel nameColumnTitle = new CenteredText("NAME", 18, Font.BOLD);
		nameColumnTitle.setBounds(0, rowPosY, nameColumnWidth, rowHeight);
		this.add(nameColumnTitle);

		JLabel wonColumnTitle = new CenteredText("WON", 18, Font.BOLD);
		wonColumnTitle.setBounds(nameColumnWidth, rowPosY, wonColumnWidth, rowHeight);
		this.add(wonColumnTitle);

		JLabel lostColumnTitle = new CenteredText("DRAW", 18, Font.BOLD);
		lostColumnTitle.setBounds(nameColumnWidth + wonColumnWidth, rowPosY, drawColumnWidth, rowHeight);
		this.add(lostColumnTitle);

		JLabel dateColumnTitle = new CenteredText("DATE", 18, Font.BOLD);
		dateColumnTitle.setBounds(nameColumnWidth + wonColumnWidth + drawColumnWidth, rowPosY, dateColumnWidth, rowHeight);
		this.add(dateColumnTitle);

		this.loading = new CenteredText("LOADING...", 18, Font.BOLD);
		this.loading.setBounds(0, 240, 370, 25);
		this.add(this.loading);

		this.pageIndex = new CenteredText("", 13, Font.BOLD);
		this.pageIndex.setBounds(120, rowPosY + rowHeight * (this.manager.itemsPerPage + 1) + 20, 130, rowHeight);
		this.add(this.pageIndex);

		this.previousPage = new CenteredText("", 13, Font.BOLD);
		this.previousPage.setBounds(0, rowPosY + rowHeight * (this.manager.itemsPerPage + 1) + 20, 120, rowHeight);
		this.previousPage.addMouseListener(new HighscoresViewPanelPreviousPageMouseListener());
		this.add(this.previousPage);

		this.nextPage = new CenteredText("", 13, Font.BOLD);
		this.nextPage.setBounds(250, rowPosY + rowHeight * (this.manager.itemsPerPage + 1) + 20, 120, rowHeight);
		this.nextPage.addMouseListener(new HighscoresViewPanelNextPageMouseListener());
		this.add(this.nextPage);

		for (int i = 1; i <= this.manager.itemsPerPage; i++) {
			JLabel nameColumn = new CenteredText("", 13, Font.BOLD);
			nameColumn.setBounds(0, rowPosY + rowHeight * i, nameColumnWidth, rowHeight);
			this.nameColumn.add(nameColumn);
			this.add(nameColumn);			 

			JLabel wonColumn = new CenteredText("", 13, Font.BOLD);
			wonColumn.setBounds(nameColumnWidth, rowPosY + rowHeight * i, wonColumnWidth, rowHeight);
			this.wonColumn.add(wonColumn);
			this.add(wonColumn);			 

			JLabel drawColumn = new CenteredText("", 13, Font.BOLD);
			drawColumn.setBounds(nameColumnWidth + wonColumnWidth, rowPosY + rowHeight * i, drawColumnWidth, rowHeight);
			this.drawColumn.add(drawColumn);
			this.add(drawColumn);			 

			JLabel dateColumn = new CenteredText("", 13, Font.BOLD);
			dateColumn.setBounds(nameColumnWidth + wonColumnWidth + drawColumnWidth, rowPosY + rowHeight * i, dateColumnWidth, rowHeight);
			this.dateColumn.add(dateColumn);
			this.add(dateColumn);			 
		}
		
		this.loadPage();
		this.loadNumberOfPages();
				
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yy HH:mm");
		this.loading.setVisible(this.highscores.size() == 0);
		for (int i = 0; i < this.manager.itemsPerPage; i++) {
			if (this.highscores.size() > i) {
				Highscore highscore = this.highscores.get(i);
				this.nameColumn.get(i).setText((i + (this.currentPage - 1) * this.manager.itemsPerPage + 1) + "  " + highscore.name);
				this.wonColumn.get(i).setText("" + highscore.roundsWon);
				this.drawColumn.get(i).setText("" + highscore.roundsDraw);
				this.dateColumn.get(i).setText(dateFormatter.format(highscore.time));
			} else {
				this.nameColumn.get(i).setText("");
				this.wonColumn.get(i).setText("");
				this.drawColumn.get(i).setText("");
				this.dateColumn.get(i).setText("");
			}
		}
		if (this.numberOfPages > 0) {
			this.pageIndex.setText("PAGE " + this.currentPage + " OF " + this.numberOfPages);
			this.previousPage.setText(this.hasPreviousPage() ? "❮❮❮" : "");
			this.nextPage.setText(this.hasNextPage() ? "❯❯❯" : "");
		}
	}
	
	public void goToPage(int page) {
		if (page < 1 || page > this.numberOfPages) {
			return;
		}
		this.currentPage = page;
		this.highscores = new ArrayList<Highscore>();
		this.loadPage();
		this.repaint();
	}
	
	public void previousPage() {
		this.goToPage(this.currentPage - 1);
	}
	
	public void nextPage() {
		this.goToPage(this.currentPage + 1);
	}
	
	private boolean hasPreviousPage() {
		if (this.numberOfPages == 0) {
			return false;
		}
		return (this.currentPage - 1) >= 1;
	}
	
	private boolean hasNextPage() {
		if (this.numberOfPages == 0) {
			return false;
		}
		return (this.currentPage + 1) <= this.numberOfPages;
	}
	
	private void loadPage() {
		if (this.loadedPages.size() > (this.currentPage - 1)) {
			this.highscores = this.loadedPages.get(this.currentPage - 1);
			repaint();
		} else {
			Thread t = new Thread() {
				public void run() {
					highscores = manager.get(currentPage);
					loadedPages.add(highscores);
					repaint();
				}
			};
			t.start();
		}
	}

	private void loadNumberOfPages() {
		Thread t = new Thread() {
			public void run() {
				numberOfPages = manager.numberOfPages();
				repaint();
			}
		};
		t.start();
	}

}
