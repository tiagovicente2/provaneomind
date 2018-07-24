package com.provaneomind.ws.rest.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.provaneomind.ws.rest.vo.VOFornecedor;

@Path("/ProvaNeomind")
public class ServiceLogin {
	private static ArrayList<VOFornecedor> arrayFornecedores = new ArrayList<VOFornecedor>(); //array para armazenamento dos fornecedores
	
	@POST
	@Path("/AddFornecedor")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String adicionaFornecedor( VOFornecedor VO) {
		int n = 0;
		String nomeForn = "";
		Boolean find = false;
		for(VOFornecedor i : arrayFornecedores) {
			if( arrayFornecedores.get(n).getId() == VO.getId()) {
				nomeForn = arrayFornecedores.get(n).getName().toString();
				find = true;
			}
			n++;
		}
		if(!find) {
			arrayFornecedores.add(VO);
			return "Adicionado fornecedor "+nomeForn+"com sucesso!";
		}

		else
			return "ID já existe";
		}
	
	@DELETE
	@Path("/DeletaFornecedor")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String deletaFornecedor(VOFornecedor VO) {
		int n = 0;
		String nomeForn = "";
		Boolean find = false;
		for(VOFornecedor i : arrayFornecedores) {
			if( arrayFornecedores.get(n).getId() == VO.getId()) {
				nomeForn = arrayFornecedores.get(n).getName().toString();
				arrayFornecedores.remove(VO);
				find = true;
			}
			n++;
		}
		
		if(find) return "Fornecedor "+nomeForn+" foi deletado";
		else return "Erro";
	}
	
	@PUT
	@Path("/AlteraFornecedor")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String alteraFornecedor(VOFornecedor VO) {
		int n = 0;
		String nomeForn = "";
		Boolean find = false;
		for(VOFornecedor i : arrayFornecedores) {
			if(arrayFornecedores.get(n).getId() == VO.getId()) {
				nomeForn = arrayFornecedores.get(n).getName().toString();
				arrayFornecedores.set(n, VO);
				find = true;
			}
			n++;
		}
		if(find) return "Fornecedor "+nomeForn+" alterado com sucesso";
		else return "Fornecedor não encontrado";
		}
	
	@POST
	@Path("/BuscaFornecedor")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOFornecedor buscaFornecedor(VOFornecedor VO) {
		int n = 0;
			for(VOFornecedor i : arrayFornecedores) {
				if( arrayFornecedores.get(n).getId() == VO.getId()) {
					VO = arrayFornecedores.get(n);
				}
				n++;
			}

			return VO;
		}
	
}
