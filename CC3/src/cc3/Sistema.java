package cc3;

import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sistema extends JFrame implements 
                                    ActionListener{
    //Área de referências globais e variáveis
    JLabel lMusica, lCantor, lCompo, lGenero;
    JTextField tfMusica, tfCantor, tfCompo, tfGenero;
    JButton bGravar, bLimpar, bSair, bBuscar, bEditar, bExcluir, bListar;
    JCheckBox cbxEditar;
    public ArrayList<Registro> r1 = new ArrayList();
    String texto = "";
    JMenuItem miGravar, miSair, miLimpar;
    JMenu mArquivo, mEditar;
    JMenuBar barra;
    public Registro reg;
        String obMusica;
        String obCantor;
        String obCompo;
        String obGenero;   
    public Sistema(){        
        // layout em fluxo sentido da escrita do caderno
        setLayout(new FlowLayout());    
        
        // instâncias dos campos de texto e seus rótulos
        lMusica = new JLabel("Música");
        add(lMusica);
        tfMusica = new JTextField(25);
        tfMusica.addActionListener(this);
        add(tfMusica);
        lCantor = new JLabel("Cantor(a)");
        add(lCantor);
        tfCantor = new JTextField(25);
        tfCantor.addActionListener(this);
        add(tfCantor);        
        lCompo = new JLabel("Compositores");
        add(lCompo);
        tfCompo = new JTextField(25);
        tfCompo.addActionListener(this);
        add(tfCompo);
        lGenero = new JLabel("Gêneros");
        add(lGenero);
        tfGenero = new JTextField(20);
        tfGenero.addActionListener(this);
        add(tfGenero);
                       
        // instâncias dos buttons
        bGravar = new JButton("Gravar");
        // escuta que aguarda ação no botão e chama o método actionPerformed
        bGravar.addActionListener(this); 
        bGravar.setToolTipText("Gravar os dados no sistema.");
        add(bGravar);
        bListar =new JButton("Listar");
        bListar.addActionListener(this);
        bListar.setToolTipText("Listar todos os Cadastros.");
        add(bListar);
        bBuscar =new JButton("Buscar");
        bBuscar.addActionListener(this);
        bBuscar.setToolTipText("Pesquisar Cadastro.");
        add(bBuscar);
        bEditar = new JButton("Editar");
        bEditar.addActionListener(this);
        bEditar.setToolTipText("Alterar Cadastro.");
        add(bEditar);
        bExcluir =new JButton("Excluir");
        bExcluir.addActionListener(this);
        bExcluir.setToolTipText("Excluir Cadastro.");
        add(bExcluir);
        bLimpar = new JButton("Limpar");
        bLimpar.addActionListener(this);
        bLimpar.setToolTipText("Limpar os campos.");
        add(bLimpar);    
        bSair = new JButton("Sair");
        bSair.addActionListener(this);
        bSair.setToolTipText("Sair do sistema.");
        add(bSair);
        
        //instância do check box e seu rótulo
        cbxEditar = new JCheckBox("Não Editável");
        cbxEditar.addActionListener(this);
        add(cbxEditar);
        
        //Menu de opções
        miGravar = new JMenuItem("Gravar");
        miGravar.setMnemonic('G');  // configura G como tecla de atalho
        miGravar.addActionListener(this);
        miSair = new JMenuItem("Sair");
        miSair.setMnemonic('S');
        miSair.addActionListener(this);
        mArquivo = new JMenu("Arquivo");
        mArquivo.setMnemonic('A'); //configura Alt + A como tecla de atalho
        mArquivo.add(miGravar);
        mArquivo.add(miSair);
        miLimpar = new JMenuItem("Limpar");
        miLimpar.setMnemonic('L');
        miLimpar.addActionListener(this);
        mEditar = new JMenu("Editar");
        mEditar.setMnemonic('E');
        mEditar.add(miLimpar);
        barra = new JMenuBar();
        barra.add(mArquivo);
        barra.add(mEditar);
        setJMenuBar(barra); //configura barra do menu completa na frame
        
        setSize(700, 500);
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        // quando pressionado enter no campo 
        // manda cursor para outro campo
        if (e.getSource()==tfMusica){
            tfCantor.requestFocus();
        }else if (e.getSource()==tfCantor){
            tfCompo.requestFocus();
        }else if (e.getSource()==tfCompo){
            tfGenero.requestFocus();
        }
        // quando marcado desabilita e torna não editável os campos
        // quando desmarcado retorna edição e habilita campos
        if (e.getSource()==cbxEditar){
            if (cbxEditar.isSelected()){            
                tfMusica.setEnabled(false);
                tfCantor.setEnabled(false);
                tfCompo.setEnabled(false);
                tfGenero.setEnabled(false);
                bBuscar.setEnabled(false);
                bEditar.setEnabled(false);
                bExcluir.setEnabled(false);
                bListar.setEnabled(false);
                bGravar.setEnabled(false);
                bLimpar.setEnabled(false);
            }
            if (cbxEditar.isSelected()==false){            
                tfMusica.setEnabled(true);
                tfCantor.setEnabled(true);
                tfCompo.setEnabled(true);
                tfGenero.setEnabled(true);
                bBuscar.setEnabled(true);
                bEditar.setEnabled(true);
                bExcluir.setEnabled(true);
                bListar.setEnabled(true);
                bGravar.setEnabled(true);
                bLimpar.setEnabled(true);
            }
        } 
        
        //ações para o botão gravar
        if (e.getSource()==bGravar | e.getSource()==miGravar){
           /* if (tfMusica.getText().equals("")){
                JOptionPane.showMessageDialog(null, 
                        "Campo Música vazio");
            }
            if (tfCantor.getText().equals("")){
                JOptionPane.showMessageDialog(null, 
                        "Campo Cantor(a) vazio");
            }
            if (tfCompo.getText().equals("")){
                JOptionPane.showMessageDialog(null, 
                        "Campo Compositores vazio");
            }
            if (tfGenero.getText().equals("")){
                JOptionPane.showMessageDialog(null, 
                        "Campo Gêneros vazio");
            } */
            
            if (tfMusica.getText().equals("") | tfCantor.getText().equals("") |
                    tfCompo.getText().equals("") | tfGenero.getText().equals(""))
                JOptionPane.showMessageDialog(null, 
                        "Não foi possível realizar o cadastro");
            else{
                JOptionPane.showMessageDialog(null, 
                        "Cadastro realizado com Sucesso");
            }
            
            //grava os dados em uma variável
            /*texto += "\nMúsica: "+ r1.getMusica()+
                    "\nCantor(a): "+ r1.getCantor()+
                    "\nCompositores: "+ r1.getCompo()+
                    "\nGênero: "+ r1.getGenero()+"\n---\n";*/
            this.obMusica = this.tfMusica.getText();
            this.obCantor = this.tfCantor.getText();
            this.obCompo = this.tfCompo.getText();
            this.obGenero = this.tfGenero.getText();
            Registro novo = new Registro(obMusica,obCantor,obCompo,obGenero);
            r1.add(novo);           
            //apresenta os dados gravados em um painel de opções
            
            
            //limpa os campos para os próximos dados
            tfMusica.setText("");
            tfCantor.setText("");
            tfCompo.setText("");
            tfGenero.setText("");
        }else if(e.getSource()==bListar){
            String  list = "";
            for(int i = 0; i<r1.size();i++)
                list +=(i+1)+"º\n*Música: "+r1.get(i).getMusica()+
                        "\n*Cantor(a): "+r1.get(i).getCantor()+
                        "\n*Compositores: "+r1.get(i).getCompo()+
                        "\n*Gênero: "+r1.get(i).getGenero()+"\n---------------------------\n";            
            if(list.isEmpty()){  
                JOptionPane.showMessageDialog(null, "Lista Vazia");  
            }else{  
                JOptionPane.showMessageDialog(null, list);   
            }
               
        }else if(e.getSource()==bEditar){
            int psc;
               
                psc = parseInt(JOptionPane.showInputDialog("Digite a posição que deseja editar"))-1;
            
                r1.get(psc).setMusica(JOptionPane.showInputDialog("Digite o novo nome da música"));
                r1.get(psc).setCantor(JOptionPane.showInputDialog("Digite o novo nome"));
                r1.get(psc).setCompo(JOptionPane.showInputDialog("Digite o novo compositor"));
                r1.get(psc).setGenero(JOptionPane.showInputDialog("Digite o novo gênero"));
        
        }else if(e.getSource()==bBuscar){
            int psc=0; String msc1;
            msc1 = JOptionPane.showInputDialog("Digite o nome da música:");
            
            while(psc<r1.size()){
                if(msc1.equals(r1.get(psc).getMusica()))
                    break;
                else{
                    System.out.println(r1.get(psc).getMusica()+"\n"+psc);
                    psc++;
                }
            }
            JOptionPane.showMessageDialog(null,"Música: "+r1.get(psc).getMusica()+
                                                "\nCantor(a): "+r1.get(psc).getCantor()+
                                                "\nCompositores: "+r1.get(psc).getCompo()+
                                                "\nGênero: "+r1.get(psc).getGenero());
        
        }else if(e.getSource()==bExcluir){
            int psc;
            psc = parseInt(JOptionPane.showInputDialog("Digite a posição que deseja excluir"))-1;
            r1.remove(psc);
            
        }else if (e.getSource()==bLimpar | e.getSource()==miLimpar){
            //limpa todos os campos
            tfMusica.setText("");
            tfCantor.setText("");
            tfCompo.setText("");
            tfGenero.setText("");
        }else if (e.getSource()==bSair | e.getSource() == miSair){
            // sai do sistema
            System.exit(0);
        }        
    }
    
    public static void main (String [] args){
        //inicia o programa
        Sistema s = new Sistema();
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}