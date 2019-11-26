package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.util.Random;

public class Id implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Random r = new Random();
	
    public static String gerarId(int opcao) {
        String id = new String();
        
        switch (opcao) {
            case 1: // Atendente
                id += opcao;
                id += random();
                break;
            case 2: // Medico
                id += opcao;
                id += random();
                break;
            case 3: // Usuario
                id += opcao;
                id += random();
                break;
            case 4: // Consulta
                id+=opcao;
                id+= random();
                break;
            case 5: // Exame
            	id+=opcao;
            	id+=random();
            case 6: // Prontuario
            	id+=opcao;
            	id+=random();
            case 7: // Cirurgia
            	id+=opcao;
            	id+=random();
            default:
                break;
        }
		return id;

    }
    
    static String random() {
        String s = new  String();
        for(int i = 0; i < 3; i++) {
            s += r.nextInt(9);
        }
        return s;
    }
    
    
}
