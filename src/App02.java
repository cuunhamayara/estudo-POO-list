import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App02 {

static List <Produto> produto = new ArrayList<Produto>();

	public static void main(String[] args) throws ParseException {
		
	    Scanner ler = new Scanner(System.in);
	    
    	System.out.println("---Iniciar novo carrinho---");
		
    	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite a data da operação (dd/MM/yyyy): ");
		String dataString = ler.nextLine();
		Date data = formato.parse(dataString);
		
		Carrinho c1 = new Carrinho(data);
    	System.out.println("Carrinho criado com sucesso!");
	    
        int opcao = 0;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1- Cadastrar produto");
            System.out.println("2- Alterar cadastro do produto");
            System.out.println("3- Remover cadastro de produto");
            System.out.println("4- Listar produtos cadastrados");
            System.out.println("5- Consultar se produto está disponível");
            System.out.println("6- Calcular ICMS de um produto");
            System.out.println("7- Inserir produto no carrinho");
            System.out.println("8- Calcular ICMS total do carrinho");
            System.out.println("9- Calcular valor de venda do carrinho");
            System.out.println("10- Confirmar venda");
            System.out.println("11- Ver informações da venda");
            System.out.println("0- Finalizar");

            try {
                System.out.println("Digite a opção: ");
                opcao = ler.nextInt();
            }
            catch (Exception e) {
                System.out.println("\n>>> erro! a opção deve ser numérica!<<< \n");
                ler.nextLine();
                return;
            }

            switch (opcao) {

                case 1:
                	System.out.println("---Cadastrar produto---");
                	System.out.println("Digite o código do produto: ");
                    ler.nextLine();
                	int cod = ler.nextInt();
                    
                    Produto produtoEncontrado = pesquisarProduto(cod);
                    
                    if (produtoEncontrado != null) {
                    	System.out.println("Este código já foi cadastrado");
                    	break;
                    } 
                    
                	System.out.println("Digite a descrição do produto: ");
                    String descricao = ler.nextLine().toUpperCase();
                    ler.nextLine();
                    System.out.println("Digite o valor do produto: ");
                	float valor = ler.nextFloat();               	
                	System.out.println("Digite a alíquota de ICMS do produto: ");
                	float aliquota = ler.nextFloat();               	

            		Produto produtoAux = new Produto(cod, descricao, valor, aliquota);
            		produtoAux.calcularICMS();
            	    produto.add(produtoAux);
            	    System.out.println("\nProduto cadastrado com sucesso!");
            	    break;
            	    
                case 2:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}
                	
                	System.out.println("---Alterar cadastro de produto---");                          	           	
                	System.out.println("Digite o código do produto: ");
                    ler.nextLine();
                	cod = ler.nextInt();
                	
                	produtoEncontrado = pesquisarProduto(cod);
                	
                	if (produtoEncontrado != null) {
                    	System.out.println("Escolha o que você deseja alterar:");
                    	System.out.println("1- descrição");
                    	System.out.println("2- preço de venda");
                    	System.out.println("3- alíquota do ICMS");
                    	
                    	int opcao1 = 0;
                        ler.nextLine();
                    	opcao1 = ler.nextInt();

                    	switch (opcao1) {
                    	
	                    	case 1:
	                    		String descricaoNova = null;
	                            System.out.println("A descrição atual a ser alterada é: " + produtoEncontrado.getDescricao());
	                    		System.out.println("Digite a nova descrição: ");
	                            ler.nextLine();
	                    		produtoEncontrado.setDescricao(descricaoNova);
	                    		System.out.println("Descrição alterada com sucesso!\n");
	                    		break;
	                                  		
	                    	case 2:
	                    		float valorVendaNovo = 0;
	                            System.out.println("O preço de venda atual a ser alterado é: " + produtoEncontrado.getPrecoVenda());
	                    		System.out.println("Digite o novo preço: ");
	                            ler.nextLine();
	                    		produtoEncontrado.setPrecoVenda(valorVendaNovo);
	                    		System.out.println("Preço de venda alterado com sucesso!\n");
	                    		break;
	                    		
	                    	case 3:
	                    		float aliquotaICMSnovo = 0;
	                            System.out.println("O valor da alíquta do ICMS atual a ser alterado é: " + produtoEncontrado.getAliquotaICMS());
	                    		System.out.println("Digite o novo valor da alíquota do ICMS: ");
	                            ler.nextLine();
	                    		produtoEncontrado.setAliquotaICMS(aliquotaICMSnovo);
	                    		System.out.println("Valor da alíquta do ICMS alterado com sucesso!\n");
	                    		break;
	                    	
	                    	default:	
	                            System.out.println("\n>>> erro! opção inválida <<<\n");
	                            break;	                    	                    		                    	
                    	}
                	} else {
                		System.out.println("Este código não foi cadastrado!");
                		break;
                	}
              
                case 3:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}
                	System.out.println("---Remover cadastro de produto---");
                	System.out.println("Digite o código do produto: ");
                    ler.nextLine();
                	cod = ler.nextInt();
                	
                    produtoEncontrado = pesquisarProduto(cod);
                    if (produtoEncontrado != null) {
                    	System.out.println("Tem certeza que deseja remover esse produto?");
                    	System.out.println("Digite 1 para confirmar ou 0 para cancelar: ");
                        ler.nextLine();
                    	int op = ler.nextInt();
                    		if (op == 1) {
                        	    produto.remove(produtoEncontrado);
                        	    System.out.println("Produto removido com sucesso!");
                        	    break;
                    		} else if (op != 0 && op != 1) {
                    			System.out.println("Opção inválida");
                    			continue;
                    		} else if (op == 0) {
                    			System.out.println("Operação cancelada!");
                    			break;
                    		}
                    } else {
                    	System.out.println("Este código não foi cadastrado");
                    }
                    break;
                
                case 4:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}
                    System.out.println("---Listar produtos---");                          	           	
                    for (Produto produtoListar : produto) {
                        System.out.println(produtoListar.toString());
                       }
                    break;
                    
                case 5:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}
                	System.out.println("---Consultar disponibilidade do produto---");
                                         	
                   	System.out.println("Digite o código do produto: ");
                    ler.nextLine();
                   	cod = ler.nextInt();
                    produtoEncontrado = pesquisarProduto(cod);
                    if (produtoEncontrado != null) {
                    	if (produtoEncontrado.getVendido() == false) {
                    		System.out.println("O produto está disponível");
                    	} else {
                    		System.out.println("Este produto já foi vendido");
                    	}
                    } else {
                    	System.out.println("Este código não foi cadastrado");
                    }
                    break;

                case 6:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}
                	
                	System.out.println("---Calcular ICMS de produto---");
                	System.out.println("Digite o código do produto: ");
                    ler.nextLine();
                	cod = ler.nextInt();
                    produtoEncontrado = pesquisarProduto(cod);
                    if (produtoEncontrado != null) {
                    	System.out.println("O ICMS deste produto é: " + produtoEncontrado.calcularICMS());	
                    } else {
                    	System.out.println("Este código não foi cadastrado");
                    }
                    break;
         
                case 7:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}
                	
                	System.out.println("---Inserir produto no carrinho---");
                	
                   	System.out.println("Digite o código do produto: ");
                    ler.nextLine();
                   	cod = ler.nextInt();
                    produtoEncontrado = pesquisarProduto(cod);
                    if (produtoEncontrado != null) {
                    	if (produtoEncontrado.getVendido() == false) {
	                    	c1.insereItem(produtoEncontrado);
	                    	System.out.println("Produto inserido com sucesso!");
                    	} else {
                    		System.out.println("Este produto já foi vendido");
                    	}
                    } else {
                    	System.out.println("Este código não foi cadastrado");
                    }
                    break;
              
                case 8:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}
                	
                	if (c1.getNumDeItens() == 0) {
                		System.out.println("Não há ítens neste carrinho");
                	} else {
                       	System.out.println("---Calcular ICMS do carrinho---");
                		System.out.println("O valor total do ICMS do carrinho é: " + c1.getValorICMS());
                	}
                	break;
   	
                case 9:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}
                	if (c1.getNumDeItens() == 0) {
                		System.out.println("Não há ítens neste carrinho");
                	} else {
                    	System.out.println("---Calcular valor total do carrinho---");
                		System.out.println("O valor total do carrinho é: " + c1.getValorVenda());
                	}
                	break;
       
                case 10:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}	
                	if (c1.getNumDeItens() == 0) {
                		System.out.println("Não há ítens neste carrinho");
                	} else {
                    	System.out.println("---Confirmar compra---");
                		c1.confirmarCompra();
                		System.out.println("Compra confirmada!");
                	}
                	break;
             	
                case 11:
                	if (produto.size() == 0) {
                		System.out.println("Não tem nenhum produto cadastrado");
                		break;
                	}	
                	
                  	if (c1.getNumDeItens() == 0) {
                		System.out.println("Não há ítens neste carrinho");
                  	} else {
                    	System.out.println("---Informações da venda---");
                  		System.out.println(c1.toString());
                  	}
                  	break;
                  	
                case 0:
                    System.out.println("\n>>> sistema finalizado <<<\n");
                    return;

                default:
                    System.out.println("\n>>> opção inválida! <<<\n");
                    break;  
 	                	
            }
        } while (true);
	}

public static Produto pesquisarProduto(int codigo) {
	for (Produto produtoPesquisado : produto) {
		if (produtoPesquisado.getCodigo() == codigo) {
	       return produtoPesquisado;
	     }
	}
 return null;
}
}