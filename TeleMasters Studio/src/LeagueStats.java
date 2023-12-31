import java.awt.EventQueue;	
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
	
	public class LeagueStats extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JButton btnNewButton;
		private JPanel contentBG;
		private JLabel lblTeamName;
		private JLabel lblMostKillsName;
		private JLabel lblMostKillCount;
		private JLabel lblMostPlantsName;
		private JLabel lblMostPlantsCount;
		private JLabel lblMostPlants;
		private JLabel lblMatchMVPName;
		private JLabel lblMatchMVPKDA;
		private JLabel lblMatchMvp;
		private JLabel lblSupportName;
		private JLabel lblSupportAssists;
		private JLabel lblTeamMvp;
		private JLabel lblMostDefusesName;
		private JLabel lblMostDefusesCount;
		private JLabel lblTeamDefuses;
		private JLabel lblMostKills;
		private JLabel lblTeam;
		private JLabel lblOvrWL;
		private JLabel lblOvrPlantsDefuses;
		private JLabel lblWins;
		private JLabel lblLosses;
		private JLabel lblDefuses;
		private JLabel lblPlants;
		private JLabel lblWin;
		String fileDirectory = ExcelHandler.fileDirectory();
		private JPanel panelLosses;
		private JLabel lblLoss;
		private JPanel panelDefuses;
		private JPanel panelPlants;
		private JLabel lblDef;
		private JLabel lblPlant;
		
		ExcelHandler excelHandler = new ExcelHandler();
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				 public void run() {
			            try {
			                LeagueStats frame = new LeagueStats();
			                frame.setVisible(true);

			                
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }
			});
			
		}
		
		public void updateLabels(String mostKillsName, String mostKillCount, String mostPlantsName, String mostPlantCount, String supportName, String supportAssistCount, String mostDefusesName, String mostDefusesCount, String matchMVPName, String MatchMVPKDA ) {
		    lblMostKillsName.setText(mostKillsName);
		    lblMostKillCount.setText(mostKillCount);
		    lblMostPlantsName.setText(mostPlantsName);
		    lblMostPlantsCount.setText(mostPlantCount);
		    lblSupportName.setText(supportName);
		    lblSupportAssists.setText(supportAssistCount);
		    lblMostDefusesName.setText(mostDefusesName);
		    lblMostDefusesCount.setText(mostDefusesCount);
		    lblMatchMVPName.setText(matchMVPName);
		    lblMatchMVPKDA.setText(MatchMVPKDA);
		}
		
		public void updateLabelsBasedOnGame(String gameNum) {
		    try (FileInputStream fis = new FileInputStream(fileDirectory + "LeagueLeaders_" + gameNum + ".xlsx");
		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
		        XSSFSheet sheet = workbook.getSheetAt(0);
		        System.out.println("Reading Excel for " + gameNum);

		        String mostKillsName = getCellValue(sheet.getRow(2).getCell(2));
		        String mostKillCount = getCellValue(sheet.getRow(2).getCell(1));
		        String mostPlantsName = getCellValue(sheet.getRow(3).getCell(2));
			        String mostPlantCount = getCellValue(sheet.getRow(3).getCell(1));
			        String supportName = getCellValue(sheet.getRow(4).getCell(2));
			        String supportAssistCount = getCellValue(sheet.getRow(4).getCell(1));
			        String mostDefusesName = getCellValue(sheet.getRow(1).getCell(2));
			        String mostDefusesCount = getCellValue(sheet.getRow(1).getCell(1));
			        String matchMVPName = getCellValue(sheet.getRow(5).getCell(4));
			        String matchMVPKDA = getCellValue(sheet.getRow(5).getCell(1)) + "/" + getCellValue(sheet.getRow(5).getCell(2)) + "/" + getCellValue(sheet.getRow(5).getCell(3));
	
			        // Update the JLabels in LeagueStats
			        updateLabels(mostKillsName, mostKillCount, mostPlantsName, mostPlantCount, supportName, supportAssistCount, mostDefusesName, mostDefusesCount, matchMVPName, matchMVPKDA);
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
		
			}
			private String getCellValue(Cell cell) {
			    if (cell != null) {
			        CellType cellType = cell.getCellType();
			        switch (cellType) {
			            case STRING:
			                return cell.getStringCellValue();
			            case NUMERIC:
			                // Check if it's a whole number (integer)
			                if (DateUtil.isCellDateFormatted(cell) || cell.getNumericCellValue() != (int) cell.getNumericCellValue()) {
			                    return String.valueOf(cell.getNumericCellValue());
			                } else {
			                    return String.valueOf((int) cell.getNumericCellValue());
			                }
			            default:
			                return "";
			        }
			    }
			    return ""; 
			}
		
		/**
		 * Create the frame.
		 */
		public LeagueStats() {
			getContentPane().setLayout(null);
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1080, 750);
			contentBG = new JPanel();
			contentBG.setBorder(null);
			contentBG.setBackground(new Color(255,251,245));
			setContentPane(contentBG);
			contentBG.setLayout(null);
			
			panelDefuses = new JPanel();
			panelDefuses.setBackground(new Color(192, 192, 192));
			panelDefuses.setBounds(557, 621, 72, 31);
			contentBG.add(panelDefuses);
			panelDefuses.setLayout(null);
			
			lblDef = new JLabel("");
			lblDef.setBounds(10, 10, 52, 11);
			panelDefuses.add(lblDef);
			
			panelLosses = new JPanel();
			panelLosses.setBackground(new Color(192, 192, 192));
			panelLosses.setForeground(new Color(192, 192, 192));
			panelLosses.setBounds(129, 659, 72, 31);
			contentBG.add(panelLosses);
			panelLosses.setLayout(null);
			
			lblLoss = new JLabel("");
			lblLoss.setBounds(10, 5, 48, 26);
			panelLosses.add(lblLoss);
			
			JPanel panelWins = new JPanel();
			panelWins.setBackground(new Color(192, 192, 192));
			panelWins.setBounds(129, 621, 72, 31);
			contentBG.add(panelWins);
			panelWins.setLayout(null);
			
			lblWin = new JLabel("");
			lblWin.setBounds(10, 10, 58, 26);
			panelWins.add(lblWin);
			lblWin.setBackground(new Color(192, 192, 192));
			
			lblTeamDefuses = new JLabel();
			lblTeamDefuses.setText("MOST DEFUSES");
			lblTeamDefuses.setHorizontalAlignment(SwingConstants.CENTER);
			lblTeamDefuses.setForeground(new Color(253, 69, 86));
			lblTeamDefuses.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
			lblTeamDefuses.setBorder(null);
			lblTeamDefuses.setBackground(new Color(255, 251, 245));
			lblTeamDefuses.setBounds(784, 295, 170, 41);
			contentBG.add(lblTeamDefuses);
			
			lblTeamMvp = new JLabel();
			lblTeamMvp.setText("BEST SUPPORT");
			lblTeamMvp.setHorizontalAlignment(SwingConstants.CENTER);
			lblTeamMvp.setForeground(new Color(253, 69, 86));
			lblTeamMvp.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
			lblTeamMvp.setBorder(null);
			lblTeamMvp.setBackground(new Color(255, 251, 245));
			lblTeamMvp.setBounds(566, 334, 182, 41);
			contentBG.add(lblTeamMvp);
			
			lblMatchMvp = new JLabel();
			lblMatchMvp.setText("MATCH MVP");
			lblMatchMvp.setHorizontalAlignment(SwingConstants.CENTER);
			lblMatchMvp.setForeground(new Color(253, 69, 86));
			lblMatchMvp.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
			lblMatchMvp.setBorder(null);
			lblMatchMvp.setBackground(new Color(255, 251, 245));
			lblMatchMvp.setBounds(398, 431, 203, 60);
			contentBG.add(lblMatchMvp);
			
			lblMatchMVPKDA = new JLabel();
			lblMatchMVPKDA.setText("?? K/D/A");
			lblMatchMVPKDA.setHorizontalAlignment(SwingConstants.CENTER);
			lblMatchMVPKDA.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
			lblMatchMVPKDA.setBorder(null);
			lblMatchMVPKDA.setBackground(new Color(255, 251, 245));
			lblMatchMVPKDA.setBounds(440, 393, 111, 49);
			contentBG.add(lblMatchMVPKDA);
			
			lblMostKills = new JLabel();
			lblMostKills.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
			lblMostKills.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostKills.setBorder(null);
			lblMostKills.setText("MOST KILLS");
			lblMostKills.setBounds(41, 295, 160, 41);
			lblMostKills.setBackground(new Color(255,251,245));
			contentBG.add(lblMostKills);
			Color c = new Color(253, 69, 86);
		    lblMostKills.setForeground(c);
			
			JLabel lblTop = new JLabel("");
			lblTop.setBounds(0, -59, 1054, 218);
			lblTop.setIcon(new ImageIcon(fileDirectory + "LEAGUE STATS.png"));
			contentBG.add(lblTop);
			
			lblTeamName = new JLabel();
			lblTeamName.setBorder(null);
			lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
			lblTeamName.setFont(new Font("Tungsten Bold", Font.PLAIN, 45));
			lblTeamName.setText("LEAGUE LEADERS");
			lblTeamName.setBackground(new Color(255,251,245));
			lblTeamName.setBounds(371, 145, 242, 66);
			contentBG.add(lblTeamName);
			
			lblMostKillsName = new JLabel();
			lblMostKillsName.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostKillsName.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
			lblMostKillsName.setText("[name]");
			lblMostKillsName.setBorder(null);
			lblMostKillsName.setBounds(60, 246, 100, 30);
			contentBG.add(lblMostKillsName);
			lblMostKillsName.setBackground(new Color(255,251,245));
			
			lblMostKillCount = new JLabel();
			lblMostKillCount.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostKillCount.setFont(new Font("Tungsten Bold", Font.PLAIN, 19));
			lblMostKillCount.setText("?? kills");
			lblMostKillCount.setBorder(null);
			lblMostKillCount.setBounds(71, 270, 83, 30);
			contentBG.add(lblMostKillCount);
			lblMostKillCount.setBackground(new Color(255,251,245));
			
			lblMostPlantsName = new JLabel();
			lblMostPlantsName.setText("[name]");
			lblMostPlantsName.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostPlantsName.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
			lblMostPlantsName.setBorder(null);
			lblMostPlantsName.setBackground(new Color(255, 251, 245));
			lblMostPlantsName.setBounds(251, 275, 100, 30);
			contentBG.add(lblMostPlantsName);
			
			lblMostPlantsCount = new JLabel();
			lblMostPlantsCount.setText("?? plants");
			lblMostPlantsCount.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostPlantsCount.setFont(new Font("Tungsten Bold", Font.PLAIN, 19));
			lblMostPlantsCount.setBorder(null);
			lblMostPlantsCount.setBackground(new Color(255, 251, 245));
			lblMostPlantsCount.setBounds(261, 305, 83, 30);
			contentBG.add(lblMostPlantsCount);
			
			lblMostPlants = new JLabel();
			lblMostPlants.setText("MOST PLANTS");
			lblMostPlants.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostPlants.setForeground(new Color(253, 69, 86));
			lblMostPlants.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
			lblMostPlants.setBorder(null);
			lblMostPlants.setBackground(new Color(255, 251, 245));
			lblMostPlants.setBounds(219, 334, 160, 41);
			contentBG.add(lblMostPlants);
			
			lblMatchMVPName = new JLabel();
			lblMatchMVPName.setText("[name]");
			lblMatchMVPName.setHorizontalAlignment(SwingConstants.CENTER);
			lblMatchMVPName.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
			lblMatchMVPName.setBorder(null);
			lblMatchMVPName.setBackground(new Color(255, 251, 245));
			lblMatchMVPName.setBounds(451, 362, 100, 41);
			contentBG.add(lblMatchMVPName);
			
			lblSupportName = new JLabel();
			lblSupportName.setText("[name]");
			lblSupportName.setHorizontalAlignment(SwingConstants.CENTER);
			lblSupportName.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
			lblSupportName.setBorder(null);
			lblSupportName.setBackground(new Color(255, 251, 245));
			lblSupportName.setBounds(603, 275, 100, 30);
			contentBG.add(lblSupportName);
			
			lblSupportAssists = new JLabel();
			lblSupportAssists.setText("?? K/D/A");
			lblSupportAssists.setHorizontalAlignment(SwingConstants.CENTER);
			lblSupportAssists.setFont(new Font("Tungsten Bold", Font.PLAIN, 19));
			lblSupportAssists.setBorder(null);
			lblSupportAssists.setBackground(new Color(255, 251, 245));
			lblSupportAssists.setBounds(610, 305, 83, 30);
			contentBG.add(lblSupportAssists);
			
			lblMostDefusesName = new JLabel();
			lblMostDefusesName.setText("[name]");
			lblMostDefusesName.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostDefusesName.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
			lblMostDefusesName.setBorder(null);
			lblMostDefusesName.setBackground(new Color(255, 251, 245));
			lblMostDefusesName.setBounds(792, 246, 100, 30);
			contentBG.add(lblMostDefusesName);
			
			lblMostDefusesCount = new JLabel();
			lblMostDefusesCount.setText("?? most defuses");
			lblMostDefusesCount.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostDefusesCount.setFont(new Font("Tungsten Bold", Font.PLAIN, 19));
			lblMostDefusesCount.setBorder(null);
			lblMostDefusesCount.setBackground(new Color(255, 251, 245));
			lblMostDefusesCount.setBounds(812, 270, 100, 30);
			contentBG.add(lblMostDefusesCount);
			
			JComboBox<String> cmbTeams = new JComboBox<String>();
			cmbTeams.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
			cmbTeams.setBackground(new Color(192, 192, 192));
			cmbTeams.setBounds(71, 527, 280, 30);
			contentBG.add(cmbTeams);
			cmbTeams.addItem("");
			cmbTeams.addItem("Team 1");
			cmbTeams.addItem("Team 2");
			cmbTeams.addItem("Team 3");
			cmbTeams.addItem("Team 4");
			cmbTeams.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedTeam = (String) cmbTeams.getSelectedItem();
					 if (selectedTeam == "") {
							lblWin.setText("");
							lblLoss.setText("");
							lblDef.setText("");
							lblPlant.setText("");
				        } else { 
				        	try {
				        		String noOfDefuses = excelHandler.columnSum(ExcelHandler.checkTeam(selectedTeam), 5);
				        		String noOfPlants = excelHandler.columnSum(ExcelHandler.checkTeam(selectedTeam), 4);
				        		String noOfWins = excelHandler.columnSum(ExcelHandler.checkTeam(selectedTeam), 6);
				        		String noOfLoss = excelHandler.columnSum(ExcelHandler.checkTeam(selectedTeam), 7);

				        		lblWin.setText(noOfWins);
				        		lblLoss.setText(noOfLoss);
				        		lblDef.setText(noOfDefuses);
								lblPlant.setText(noOfPlants);
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				        }
				}
			});
			

		       
			
			
			lblTeam = new JLabel();
			lblTeam.setText("TEAM");
			lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
			lblTeam.setForeground(new Color(253, 69, 86));
			lblTeam.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
			lblTeam.setBorder(null);
			lblTeam.setBackground(new Color(255, 251, 245));
			lblTeam.setBounds(29, 493, 141, 41);
			contentBG.add(lblTeam);
			
			lblOvrWL = new JLabel();
			lblOvrWL.setText("OVERALL W/L");
			lblOvrWL.setHorizontalAlignment(SwingConstants.CENTER);
			lblOvrWL.setForeground(new Color(253, 69, 86));
			lblOvrWL.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
			lblOvrWL.setBorder(null);
			lblOvrWL.setBackground(new Color(255, 251, 245));
			lblOvrWL.setBounds(60, 586, 141, 41);
			contentBG.add(lblOvrWL);
			
			lblWins = new JLabel();
			lblWins.setText("WINS");
			lblWins.setHorizontalAlignment(SwingConstants.CENTER);
			lblWins.setForeground(new Color(253, 69, 86));
			lblWins.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
			lblWins.setBorder(null);
			lblWins.setBackground(new Color(255, 251, 245));
			lblWins.setBounds(53, 621, 83, 41);
			contentBG.add(lblWins);
			
			lblLosses = new JLabel();
			lblLosses.setText("LOSSES");
			lblLosses.setHorizontalAlignment(SwingConstants.CENTER);
			lblLosses.setForeground(new Color(253, 69, 86));
			lblLosses.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
			lblLosses.setBorder(null);
			lblLosses.setBackground(new Color(255, 251, 245));
			lblLosses.setBounds(53, 659, 83, 41);
			contentBG.add(lblLosses);
			
			lblOvrPlantsDefuses = new JLabel();
			lblOvrPlantsDefuses.setText("OVERALL PLANTS AND DEFUSES");
			lblOvrPlantsDefuses.setHorizontalAlignment(SwingConstants.CENTER);
			lblOvrPlantsDefuses.setForeground(new Color(253, 69, 86));
			lblOvrPlantsDefuses.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
			lblOvrPlantsDefuses.setBorder(null);
			lblOvrPlantsDefuses.setBackground(new Color(255, 251, 245));
			lblOvrPlantsDefuses.setBounds(468, 586, 280, 41);
			contentBG.add(lblOvrPlantsDefuses);
			
			lblDefuses = new JLabel();
			lblDefuses.setText("DEFUSES");
			lblDefuses.setHorizontalAlignment(SwingConstants.CENTER);
			lblDefuses.setForeground(new Color(253, 69, 86));
			lblDefuses.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
			lblDefuses.setBorder(null);
			lblDefuses.setBackground(new Color(255, 251, 245));
			lblDefuses.setBounds(468, 621, 83, 41);
			contentBG.add(lblDefuses);
			
			lblPlants = new JLabel();
			lblPlants.setText("PLANTS");
			lblPlants.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlants.setForeground(new Color(253, 69, 86));
			lblPlants.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
			lblPlants.setBorder(null);
			lblPlants.setBackground(new Color(255, 251, 245));
			lblPlants.setBounds(468, 659, 83, 41);
			contentBG.add(lblPlants);
			
			panelPlants = new JPanel();
			panelPlants.setBackground(new Color(192, 192, 192));
			panelPlants.setBounds(557, 659, 72, 31);
			contentBG.add(panelPlants);
			panelPlants.setLayout(null);
			
			lblPlant = new JLabel("");
			lblPlant.setBounds(10, 10, 52, 21);
			panelPlants.add(lblPlant);
			
			JButton btnExit = new JButton("MATCH SCHED");
			btnExit.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
			btnExit.setBackground(new Color(189, 57, 68));
			btnExit.setForeground(new Color(255, 255, 255));

			btnExit.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	try {
			    		dispose();
			    		Match window = new Match();
				       window. matchSchedFrame.setVisible(true);
					} catch (Exception e2) {
						// TODO: handle exception
					} 
			       
			    }
			});


			btnExit.setBounds(819, 612, 176, 60);
			contentBG.add(btnExit);
			
		}

		
	}