import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.color.*;


public class Cadastro extends JPanel {
    Image imageOrg = null;
    Image image = null;
    private static JTextField campoEmail, campoNome;
	private static JPasswordField primeirasenha, confirmacaoSenha;
	private static JLabel email, nome, senha, OK, mesmasenha;
	public static String nomecadastrado, emailcadastrado, senhacadastrada, confirmacaosenhacadastrada;
    {
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                int w = Cadastro.this.getWidth();
                int h = Cadastro.this.getHeight();
                image = w > 0 && h > 0 ? imageOrg.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH) : imageOrg;
                Cadastro.this.repaint();
            }
        });
    }

    public Cadastro(Image i) {
        imageOrg = i;
        image = i;
        setOpaque(false);
    }
    public void paint(Graphics g) {
        if (image != null)
            g.drawImage(image, 0, 0, null);
        super.paint(g);
    }
    public Cadastro() {
    	Image image;
        try {
            image = ImageIO.read(new File("C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\panel-cadastro#11.png"));
            ImageIcon imgbtok = new ImageIcon("C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\bt-ok-cadastro-login#11.png");
            JFrame janelacadastro = new JFrame("");
            JPanel painelcadastro = new Cadastro(image);
            janelacadastro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\martelo-panel-login#11.png"));
            janelacadastro.setSize(300, 450);
    		janelacadastro.setResizable(false);
            painelcadastro.setLayout(new FlowLayout());
            janelacadastro.add(painelcadastro);
            painelcadastro.setLayout(new MigLayout("", "[0px][0px][10px][10px][0px]", "[60px][10px][40px][10px][40px][10px][40px][10px][40px]"));
            
            nome = new JLabel("Nome: ");
    		nome.setHorizontalAlignment(SwingConstants.CENTER);
    		nome.setForeground(new Color(255, 255, 255));
    		nome.setFont(new Font("Tahoma", 11, 11));
    		painelcadastro.add(nome, "cell 3 1,alignx left,aligny center");
    		
    		campoNome = new JTextField(20);
    		campoNome.setHorizontalAlignment(SwingConstants.LEFT);
    		painelcadastro.add(campoNome, "cell 3 2,alignx left,aligny center, spanx");

    		email = new JLabel("E-mail: ");
    		email.setHorizontalAlignment(SwingConstants.CENTER);
    		email.setForeground(new Color(255, 255, 255));
    		email.setFont(new Font("Tahoma", 11, 11));
    		painelcadastro.add(email, "cell 3 3,alignx left,aligny center");
    		
    		campoEmail = new JTextField(20);
    		campoEmail.setHorizontalAlignment(SwingConstants.LEFT);
    		painelcadastro.add(campoEmail, "cell 3 4,alignx left,aligny center, spanx");
    		
    		senha = new JLabel("Senha: ");
    		senha.setHorizontalAlignment(SwingConstants.CENTER);
    		senha.setForeground(new Color(255, 255, 255));
    		senha.setFont(new Font("Tahoma", 11, 11));
    		painelcadastro.add(senha, "cell 3 5,alignx left,aligny center");
    		
    		primeirasenha = new JPasswordField(20);
    		primeirasenha.setHorizontalAlignment(SwingConstants.LEFT);
    		painelcadastro.add(primeirasenha, "cell 3 6,alignx left,aligny center, spanx");
    		
    		mesmasenha = new JLabel("Confirmação Senha: ");
    		mesmasenha.setHorizontalAlignment(SwingConstants.CENTER);
    		mesmasenha.setForeground(new Color(255, 255, 255));
    		mesmasenha.setFont(new Font("Tahoma", 11, 11));
    		painelcadastro.add(mesmasenha, "cell 3 7,alignx left,aligny center");
    		
    		confirmacaoSenha = new JPasswordField(20);
    		confirmacaoSenha.setHorizontalAlignment(SwingConstants.LEFT);
    		painelcadastro.add(confirmacaoSenha, "cell 3 8,alignx left,aligny center, spanx");
    		
    		OK = new JLabel(imgbtok);
    		painelcadastro.add(OK, "cell 3 10,alignx center,spanx");
    		OK.addMouseListener(new MouseListener() {

    			public void mouseEntered(MouseEvent arg0) {
    				OK.setCursor(new Cursor(Cursor.HAND_CURSOR));
    			}

    			public void mouseExited(MouseEvent arg0) {
    				OK.setBorder(null);
    				
    			}

    			public void mousePressed(MouseEvent arg0) {
    				OK.setBorder(BorderFactory.createEtchedBorder());
    			}

    			@SuppressWarnings("deprecation")
				public void mouseClicked(MouseEvent e) {
    				Inicio y = new Inicio ();
    				nomecadastrado = campoNome.getText();
    				emailcadastrado = campoEmail.getText();
    				senhacadastrada = primeirasenha.getText();
    				confirmacaosenhacadastrada = confirmacaoSenha.getText();
    				y.setVisible(true);
    				janelacadastro.dispose();
    				

    			}

    			public void mouseReleased(MouseEvent e) {
    			}
    		});
            
            janelacadastro.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	}

	







