package lab9.viz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lab9.GameProperties;
import lab9.Guess;
import lab9.implementations.RandomColorProvider;
import lab9.providers.ProvidesColor;
import lab9.providers.ProvidesGuess;

/**
 * WindowBuilder-designed frame for choosing colors interactively for Mastermind
 * @author roncytron
 *
 */
public class ColorChooser extends JFrame {

	private JPanel contentPane;
	private int holeNum;
	private int[] response;
	private Choice[] holes;
	private JButton btnSubmit; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorChooser frame = new ColorChooser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ColorChooser() {
		this(new GameProperties(), null);
	}
	
	private ColorChooser(GameProperties gp, ReceivesGuess rt) {
		this(gp, new RandomColorProvider(gp), rt);
	}

	/**
	 * Create the frame.
	 */
	public ColorChooser(GameProperties gp, ProvidesColor pc, final ReceivesGuess rt) {
		final int numChoices = gp.getNumColors();
		final int numPegs = gp.getNumHoles();
		this.holeNum = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.response = new int[numPegs];

		Swatch[] panels = new Swatch[numChoices];
		holes  = new Choice[numPegs];

		btnSubmit = new JButton("XXXXXXX");
		btnSubmit.setOpaque(true);
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (holeNum == numPegs) {
					if (rt != null) rt.sendGuess(new Guess(response));
					response = new int[numPegs];
				}
				resetHoles();
			}
		});
		btnSubmit.setBounds(333, 243, 117, 29);
		contentPane.add(btnSubmit);
		buttonClear();




		int pixsper = 450/(numChoices+1);
		for (int i=0; i < numChoices; ++i) {

			final int ii=i;

			Swatch panel = new Swatch(pc.getColorForPeg(i));
			panels[i] = panel;
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (holeNum == numPegs) resetHoles();
					holes[holeNum].setColor(pc.getColorForPeg(ii));
					response[holeNum] = ii;
					holeNum = holeNum + 1;
					if (holeNum == numPegs) {
						buttonSubmit();
					}
				}
			});
			panel.setBounds(i*pixsper+pixsper/2, 0, pixsper-10, 150);
			contentPane.add(panel);

		}

		pixsper = 450/(numPegs+2);
		for (int i=0; i < numPegs; ++i) {
			Choice panel = new Choice();
			holes[i]   = panel;
			panel.setBounds(i*pixsper+pixsper, 175, pixsper-10, pixsper-10);
			contentPane.add(panel);
		}
	}
	
	private void buttonClear() {
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setText("Clear");
	}
	
	private void buttonSubmit() {
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.setText("Submit");
	}

	private void resetHoles() {
		for (int i=0; i < holes.length; ++i) {
			holes[i].resetColor();
		}
		holeNum = 0;
		buttonClear();
	}

	public static ProvidesGuess launchChooser(GameProperties gp, ProvidesColor pc) {
		class GuessPushPullAdapter implements ProvidesGuess, ReceivesGuess {
			
			private Guess trial;
			
			/* (non-Javadoc)
			 * @see mastermindsolved.viz.ProvidesTrial#getTrial()
			 */
			@Override
			public synchronized Guess getGuess() {
				while (trial == null)
					try {
						wait();
					} catch (InterruptedException e) {
						// FIXME Auto-generated catch block
						e.printStackTrace();
					}
				Guess ans = trial;
				trial = null;
				return ans;
			}
			
			public synchronized void sendGuess(Guess trial) {
				this.trial = trial;
				this.notifyAll();
			}

		}
		
		final GuessPushPullAdapter ta = new GuessPushPullAdapter();
		
		new Thread() {

			public void run() {
				Frame f = new ColorChooser(gp, pc, ta);
				f.setVisible(true);
			}

		}.start();
		return ta;
	}
	


}
