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

public class Inicio extends JPanel {
    Image imageOrg = null;
    private static JTextField campoTexto;
	private static JPasswordField senha;
	private static JLabel login;
	private static JLabel pass;
	private static JLabel btnlogin;
	private static JLabel btncadastro;
	private static JLabel btnEsqueciMinhaSenha;
	private static Checkbox checkbox;
	static boolean x = false;
    Image image = null;
    {
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                int w = Inicio.this.getWidth();
                int h = Inicio.this.getHeight();
                image = w > 0 && h > 0 ? imageOrg.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH) : imageOrg;
                Inicio.this.repaint();
            }
        });
    }

    public Inicio(Image i) {
        imageOrg = i;
        image = i;
        setOpaque(false);
        
    }

    public void paint(Graphics g) {
        if (image != null)
            g.drawImage(image, 0, 0, null);
        super.paint(g);
    }

    public Inicio() {
        Image image;
        try {
            image = ImageIO.read(new File("C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\panel-login#11.png"));
            ImageIcon imgbtlogin = new ImageIcon("C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\bt-login-panel-login#11.png");
    		ImageIcon imgbtcadastro = new ImageIcon("C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\bt-cadastro-panel-login#11.png");
            JFrame janela = new JFrame("");
            janela.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\martelo-panel-login#11.png"));
            JPanel painel = new Inicio(image);
            janela.setSize(300, 450);
    		janela.setResizable(false);
            painel.setLayout(new FlowLayout());
            janela.getContentPane().add(painel);
            painel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    		janela.getContentPane().add(painel, BorderLayout.CENTER);
    		painel.setLayout(new MigLayout("", "[0px][0px][10px][10px][0px]", "[100px][10px][40px][10px][40px][20px][20px]"));
    		
    		login = new JLabel("Usuário: ");
    		login.setHorizontalAlignment(SwingConstants.CENTER);
    		login.setForeground(new Color(255, 255, 255));
    		login.setFont(new Font("Tahoma", 11, 11));
    		painel.add(login, "cell 3 1,alignx left,aligny center");
    		
    		campoTexto = new JTextField(20);
    		campoTexto.setHorizontalAlignment(SwingConstants.LEFT);
    		painel.add(campoTexto, "cell 3 2,alignx left,aligny center, spanx");
    		
    		pass = new JLabel("Senha: ");
    		pass.setHorizontalAlignment(SwingConstants.LEFT);
    		pass.setForeground(new Color(255, 255, 255));
    		pass.setFont(new Font("Tahoma", 11, 11));
    		painel.add(pass, "cell 3 3,alignx left,aligny center");
    		
    		senha = new JPasswordField(20);
    		senha.setHorizontalAlignment(SwingConstants.LEFT);
    		painel.add(senha, "cell 3 4,alignx left,spanx");

    		checkbox = new Checkbox("Lembrar login");
    		checkbox.setBackground(new Color (133, 63, 9));
    		checkbox.setForeground(new Color(255, 255, 255));
    		painel.add(checkbox, "cell 3 5,alignx left,aligny center");
    		checkbox.addItemListener(new ItemListener() {
	    		public void itemStateChanged(ItemEvent e) {
					if (x) {
						x = false;
					} else {
						x = true;
					}
	    		}
    		});
    		
    		btnlogin = new JLabel(imgbtlogin);
    		painel.add(btnlogin, "cell 3 7,alignx center,aligny center, spanx");
    		btnlogin.addMouseListener(new MouseListener() {

    			public void mouseEntered(MouseEvent arg0) {
    				btnlogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
    			}
    			public void mouseExited(MouseEvent arg0) {
    				btnlogin.setBorder(null);
    				btnlogin.setForeground(Color.gray);
    			}
    			public void mousePressed(MouseEvent arg0) {
    				btnlogin.setBorder(BorderFactory.createEtchedBorder());
    			}
    			public void mouseClicked(MouseEvent e) {
    				senha.setText("");
    				JOptionPane.showMessageDialog(janela, "Login Efetuado ! ");
    				if (!x) {
    					campoTexto.setText("");
    				}
    			}
    			public void mouseReleased(MouseEvent e) {
    			}
    		});
    		btncadastro = new JLabel(imgbtcadastro);
    		painel.add(btncadastro, "cell 3 8,alignx center,spanx");
    		btncadastro.addMouseListener(new MouseListener() {

    			public void mouseEntered(MouseEvent arg0) {
    				btncadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
    			}

    			public void mouseExited(MouseEvent arg0) {
    				btncadastro.setBorder(null);
    				btncadastro.setForeground(Color.gray);
    			}

    			public void mousePressed(MouseEvent arg0) {
    				btncadastro.setBorder(BorderFactory.createEtchedBorder());
    			}

    			public void mouseClicked(MouseEvent e) {
    				Cadastro x = new Cadastro();
    				x.setVisible(true);
    				janela.dispose();
    				

    			}

    			public void mouseReleased(MouseEvent e) {
    			}
    		});
    		
    		btnEsqueciMinhaSenha = new JLabel("Esqueceu a senha ? ");
    		btnEsqueciMinhaSenha.setHorizontalAlignment(SwingConstants.LEFT);
    		btnEsqueciMinhaSenha.setFont(new Font("Tahoma", Font.ITALIC, 11));
    		btnEsqueciMinhaSenha.setForeground(Color.white);
    		painel.add(btnEsqueciMinhaSenha, "cell 3 10,alignx left,aligny baseline");
    		
    		
    		
    		btnEsqueciMinhaSenha.addMouseListener(new MouseListener() {

    			public void mouseEntered(MouseEvent arg0) {
    				btnEsqueciMinhaSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
    				btnEsqueciMinhaSenha.setForeground(Color.blue);
    			}

    			public void mouseExited(MouseEvent arg0) {
    				btnEsqueciMinhaSenha.setForeground(Color.white);
    			}

    			public void mousePressed(MouseEvent arg0) {
    				btnEsqueciMinhaSenha.setForeground(Color.gray);
    			}

    			public void mouseClicked(MouseEvent e) {
    				JOptionPane.showMessageDialog(janela, "Muda de tela");

    			}

    			public void mouseReleased(MouseEvent e) {
    			}
    		});
		
            janela.setVisible(true);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}